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
    private TextStyleItem.OnClickListener clickListener;
    private TextStyleItem.OnLongClickListener longClickListener;

    public TextStyleBuilder(StyleBuilder styleBuilder, String text) {
        this.styleBuilder = styleBuilder;
        this.text = text;
    }

    public TextStyleBuilder setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public TextStyleBuilder setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public TextStyleBuilder setHighlightAlpha(float highlightAlpha) {
        this.highlightAlpha = highlightAlpha;
        return this;
    }

    public TextStyleBuilder setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public TextStyleBuilder setBackgroundColorRes(int backgroundColorRes) {
        this.backgroundColorRes = backgroundColorRes;
        return this;
    }

    public TextStyleBuilder setTypeFaceStyle(int typeFaceStyle) {
        this.typeFaceStyle = typeFaceStyle;
        return this;
    }

    public TextStyleBuilder setIconRes(int iconRes) {
        this.iconRes = iconRes;
        return this;
    }

    public TextStyleBuilder setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
        return this;
    }

    public TextStyleBuilder setIconBitmap(Bitmap iconBitmap) {
        this.iconBitmap = iconBitmap;
        return this;
    }

    public TextStyleBuilder setUnderLined(boolean underLined) {
        this.underLined = underLined;
        return this;
    }

    public TextStyleBuilder setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
        return this;
    }

    public TextStyleBuilder setSuperscript(boolean superscript) {
        this.superscript = superscript;
        return this;
    }

    public TextStyleBuilder setSubscript(boolean subscript) {
        this.subscript = subscript;
        return this;
    }

    public TextStyleBuilder setClickListener(TextStyleItem.OnClickListener clickListener) {
        this.clickListener = clickListener;
        return this;
    }

    public TextStyleBuilder setLongClickListener(TextStyleItem.OnLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
        return this;
    }

    public StyleBuilder commit() {
        TextStyleItem item = new TextStyleItem(
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