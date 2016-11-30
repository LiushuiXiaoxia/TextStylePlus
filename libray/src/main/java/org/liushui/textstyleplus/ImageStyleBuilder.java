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
    private ClickListener clickListener;
    private LongClickListener longClickListener;
    private int imageColor;
    private int imageColorRes;
    private int imageRes;
    private Bitmap imageBitmap;
    private Drawable imageDrawable;
    private int width;
    private int height;

    ImageStyleBuilder(StyleBuilder styleBuilder, String text) {
        this.styleBuilder = styleBuilder;
        this.text = text;
    }

    public ImageStyleBuilder text(String text) {
        this.text = text;
        return this;
    }

    public ImageStyleBuilder textSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public ImageStyleBuilder textColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public ImageStyleBuilder highlightAlpha(float highlightAlpha) {
        this.highlightAlpha = highlightAlpha;
        return this;
    }

    public ImageStyleBuilder backgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public ImageStyleBuilder backgroundColorRes(int backgroundColorRes) {
        this.backgroundColorRes = backgroundColorRes;
        return this;
    }

    public ImageStyleBuilder typeFaceStyle(int typeFaceStyle) {
        this.typeFaceStyle = typeFaceStyle;
        return this;
    }

    public ImageStyleBuilder iconRes(int iconRes) {
        this.iconRes = iconRes;
        return this;
    }

    public ImageStyleBuilder iconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
        return this;
    }

    public ImageStyleBuilder iconBitmap(Bitmap iconBitmap) {
        this.iconBitmap = iconBitmap;
        return this;
    }

    public ImageStyleBuilder underLined(boolean underLined) {
        this.underLined = underLined;
        return this;
    }

    public ImageStyleBuilder strikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
        return this;
    }

    public ImageStyleBuilder superscript(boolean superscript) {
        this.superscript = superscript;
        return this;
    }

    public ImageStyleBuilder subscript(boolean subscript) {
        this.subscript = subscript;
        return this;
    }

    public ImageStyleBuilder click(ClickListener clickListener) {
        this.clickListener = clickListener;
        return this;
    }

    public ImageStyleBuilder longClick(LongClickListener longClickListener) {
        this.longClickListener = longClickListener;
        return this;
    }

    public ImageStyleBuilder imageColor(int imageColor) {
        this.imageColor = imageColor;
        return this;
    }

    public ImageStyleBuilder imageColorRes(int imageColorRes) {
        this.imageColorRes = imageColorRes;
        return this;
    }

    public ImageStyleBuilder imageRes(int imageRes) {
        this.imageRes = imageRes;
        return this;
    }

    public ImageStyleBuilder imageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
        return this;
    }

    public ImageStyleBuilder imageDrawable(Drawable imageDrawable) {
        this.imageDrawable = imageDrawable;
        return this;
    }

    public ImageStyleBuilder size(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public StyleBuilder commit() {
        ImageStytle stytleItem = new ImageStytle(
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