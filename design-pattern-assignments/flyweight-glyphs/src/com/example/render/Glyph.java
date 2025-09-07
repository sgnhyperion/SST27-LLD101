package com.example.render;

import org.w3c.dom.Text;

public class Glyph {
    // Smell: style stored per instance → not memory efficient
    private final char ch;
    private final TextStyle style;

    public Glyph(char ch, TextStyle style) {
        this.ch = ch;
        this.style = style;
    }

    public char getCh() { return ch; }

    public TextStyle getStyle() { return style; }
    public int drawCost() { return style.drawCost(); }
}
