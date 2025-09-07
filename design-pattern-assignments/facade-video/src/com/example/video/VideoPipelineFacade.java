package com.example.video;

import java.nio.file.Path;

public class VideoPipelineFacade {
    private Decoder dec;
    private FilterEngine fe;
    private Encoder enc;
    private SharpenAdapter sa;

    public VideoPipelineFacade(){
        dec = new Decoder();
        fe = new FilterEngine();
        enc = new Encoder();
        sa = new SharpenAdapter(new LegacySharpen());
    }

    void process(String[] args){
        Frame[] frames = dec.decode(Path.of("in.mp4"));
        frames = fe.grayscale(frames);
        frames = fe.scale(frames, 0.5);
        // Legacy filter not used due to odd API
        frames = sa.sharpen(frames, 5);
        Path out = enc.encode(frames, Path.of("out.mp4"));
        System.out.println("Wrote " + out);
    }
    
}
