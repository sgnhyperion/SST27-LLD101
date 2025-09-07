package com.example.video;

import java.util.HashMap;
import java.util.Map;

public class SharpenAdapter implements Sharpen {
    LegacySharpen legacySharpen;
    private static final Map<String, Frame[]> map = new HashMap<>();
    private static int x = 1;


    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = legacySharpen;
    }

    @Override
    public Frame[] sharpen(Frame[] frames, int strength) {
        String inHandle = "H" + (x++);
        map.put(inHandle, frames);
        String outHandle = legacySharpen.applySharpen(inHandle, strength);

        return map.getOrDefault(outHandle, new Frame[0]);
    }

    // @Override
    // public String sharpen(String framesHandle, int strength) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'sharpen'");
    // }
}
