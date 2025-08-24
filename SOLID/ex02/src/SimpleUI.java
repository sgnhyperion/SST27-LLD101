public class SimpleUI implements Iui {
    @Override
    public void showPlaying(byte[] data) {
        System.out.println("\u25B6 Playing " + data.length + " bytes");
    }
    
}
