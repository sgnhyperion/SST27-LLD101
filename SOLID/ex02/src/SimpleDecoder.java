public class SimpleDecoder implements IDecoder {

    @Override
    public Frame decode(byte[] data) {
        return new Frame(data);
    }
    
}
