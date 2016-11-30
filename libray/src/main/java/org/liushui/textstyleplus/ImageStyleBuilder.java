package org.liushui.textstyleplus;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class ImageStyleBuilder {

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
    private int imageColor;
    private int imageColorRes;
    private int imageRes;
    private Bitmap imageBitmap;
    private Drawable imageDrawable;
    private int width;
    private int height;

    public ImageStyleBuilder(StyleBuilder styleBuilder, String text) {
        this.styleBuilder = styleBuilder;
        this.text = text;
    }

    public ImageStyleBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public ImageStyleBuilder setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public ImageStyleBuilder setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public ImageStyleBuilder setHighlightAlpha(float highlightAlpha) {
        this.highlightAlpha = highlightAlpha;
        return this;
    }

    public ImageStyleBuilder setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public ImageStyleBuilder setBackgroundColorRes(int backgroundColorRes) {
        this.backgroundColorRes = backgroundColorRes;
        return this;
    }

    public ImageStyleBuilder setTypeFaceStyle(int typeFaceStyle) {
        this.typeFaceStyle = typeFaceStyle;
        return this;
    }

    public ImageStyleBuilder setIconRes(int iconRes) {
        this.iconRes = iconRes;
        return this;
    }

    public ImageStyleBuilder setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
        return this;
    }

    public ImageStyleBuilder setIconBitmap(Bitmap iconBitmap) {
        this.iconBitmap = iconBitmap;
        return this;
    }

    public ImageStyleBuilder setUnderLined(boolean underLined) {
        this.underLined = underLined;
        return this;
    }

    public ImageStyleBuilder setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
        return this;
    }

    public ImageStyleBuilder setSuperscript(boolean superscript) {
        this.superscript = superscript;
        return this;
    }

    public ImageStyleBuilder setSubscript(boolean subscript) {
        this.subscript = subscript;
        return this;
    }

    public ImageStyleBuilder setClickListener(TextStyleItem.OnClickListener clickListener) {
        this.clickListener = clickListener;
        return this;
    }

    public ImageStyleBuilder setLongClickListener(TextStyleItem.OnLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
        return this;
    }

    public ImageStyleBuilder setImageColor(int imageColor) {
        this.imageColor = imageColor;
        return this;
    }

    public ImageStyleBuilder setImageColorRes(int imageColorRes) {
        this.imageColorRes = imageColorRes;
        return this;
    }

    public ImageStyleBuilder setImageRes(int imageRes) {
        this.imageRes = imageRes;
        return this;
    }

    public ImageStyleBuilder setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
        return this;
    }

    public ImageStyleBuilder setImageDrawable(Drawable imageDrawable) {
        this.imageDrawable = imageDrawable;
        return this;
    }

    public ImageStyleBuilder setSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public StyleBuilder commit() {
        ImageStytleItem stytleItem = new ImageStytleItem(
                text, textSize,
                textColor, highlightAlpha,
                backgroundColor,
                backgroundColorRes, typeFaceStyle,
                iconRes, iconDrawable, iconBitmap,
                underLined, strikethrough,
                superscript, subscript,
                clickListener, longClickListener,
                imageColor, imageColorRes, imageRes,
                imageBitmap, imageDrawable,
                width, height
        );
        return styleBuilder.addStyleItem(stytleItem);
    }
}