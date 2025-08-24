public class Cache implements ICache {
    private Frame last;

    @Override
    public void cache(Frame frame) {
        last = frame;
    }

    @Override
    public boolean isCached() {
        return last != null;
    }
    
}
