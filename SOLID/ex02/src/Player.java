public class Player {
    private IDecoder decoder;
    private Iui ui;
    private ICache cache;

    public Player(IDecoder decoder, Iui ui, ICache cache) {
        this.decoder = decoder;
        this.ui = ui;
        this.cache = cache;
    }

    void play(byte[] fileBytes){
        // decode
        Frame f = decoder.decode(fileBytes); // pretend decoding
        // draw UI
        ui.showPlaying(fileBytes);
        // cache
        cache.cache(f);
        System.out.println("Cached last frame? " + (cache.isCached()));
    }
}