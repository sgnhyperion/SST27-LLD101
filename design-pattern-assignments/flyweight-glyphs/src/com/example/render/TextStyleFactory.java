import java.util.HashMap;

public class TextStyleFactory {
     private static final HashMap<String,TextStyle>cache = new HashMap<>();

     public static TextStyle getTextStyle(String font, int size, boolean bold) {
        String key = font + "|" + size + "|" + (bold ? "B" : "K");
        TextStyle style = cache.get(key);
        if (style == null) {
            style = new TextStyle(font, size, bold);
            cache.put(key, style);
        }
        return style;
    } 
}
