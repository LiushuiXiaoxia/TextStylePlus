package org.liushui.textstyleplus;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class TextStyleBuilder {

    private StyleBuilder styleBuilder;
    private String text;
    private int textSize;
    private int textColor;
    private float highlightAlpha;
    private int backgroundColor;
    private int backgroundColorRes;
    private int typeFaceStyle;
    private int iconRes;
    private Drawable iconDrawable;
    private Bitmap iconBitmap;
    private boolean underLined;
    private boolean strikethrough;
    private boolean superscript;
    private boolean subscript;
    private ClickListener clickListener;
    private LongClickListener longClickListener;

    public TextStyleBuilder(StyleBuilder styleBuilder, String text) {
        this.styleBuilder = styleBuilder;
        this.text = text;
    }

    public TextStyleBuilder textSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public TextStyleBuilder textColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public TextStyleBuilder highlightAlpha(float highlightAlpha) {
        this.highlightAlpha = highlightAlpha;
        return this;
    }

    public TextStyleBuilder backgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public TextStyleBuilder backgroundColorRes(int backgroundColorRes) {
        this.backgroundColorRes = backgroundColorRes;
        return this;
    }

    public TextStyleBuilder typeFaceStyle(int typeFaceStyle) {
        this.typeFaceStyle = typeFaceStyle;
        return this;
    }

    public TextStyleBuilder iconRes(int iconRes) {
        this.iconRes = iconRes;
        return this;
    }

    public TextStyleBuilder iconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
        return this;
    }

    public TextStyleBuilder iconBitmap(Bitmap iconBitmap) {
        this.iconBitmap = iconBitmap;
        return this;
    }

    public TextStyleBuilder underLined(boolean underLined) {
        this.underLined = underLined;
        return this;
    }

    public TextStyleBuilder strikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
        return this;
    }

    public TextStyleBuilder superscript(boolean superscript) {
        this.superscript = superscript;
        return this;
    }

    public TextStyleBuilder subscript(boolean subscript) {
        this.subscript = subscript;
        return this;
    }

    public TextStyleBuilder click(ClickListener clickListener) {
        this.clickListener = clickListener;
        return this;
    }

    public TextStyleBuilder longClick(LongClickListener longClickListener) {
        this.longClickListener = longClickListener;
        return this;
    }

    public StyleBuilder commit() {
        TextStyle item = new TextStyle(
                text,
                textSize,
                textColor,
                highlightAlpha,
                backgroundColor,
                backgroundColorRes,
                typeFaceStyle,
                iconRes,
                iconDrawable,
                iconBitmap,
                underLined,
                strikethrough,
                superscript,
                subscript,
                clickListener,
                longClickListener);
        return styleBuilder.addStyleItem(item);
    }
}