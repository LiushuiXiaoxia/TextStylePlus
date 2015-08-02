package org.liushui.textstyleplus;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;

/**
 * StyleItem <br/>
 * Created by xiaqiulei on 2015-07-27.
 */
public class TextStyleItem implements ISpannable {

    private static final float DEFAULT_ALPHA = 0.20F;

    public interface OnClickListener {
        void onClick(String clickedText);
    }

    public interface OnLongClickListener {
        void onLongClick(String clickedText);
    }

    private String text;
    private int textColor = 0;
    private float highlightAlpha = DEFAULT_ALPHA;

    private boolean underLined = false;
    private boolean strikethrough = false; // 中划线

    private int backgroundColor;
    private int backgroundColorRes;

    private OnClickListener clickListener;
    private OnLongClickListener longClickListener;

    private int textSize;

    public TextStyleItem(String text) {
        this.text = text;
    }


    public OnClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public float getHighlightAlpha() {
        return highlightAlpha;
    }

    public void setHighlightAlpha(float highlightAlpha) {
        this.highlightAlpha = highlightAlpha;
    }

    public OnLongClickListener getLongClickListener() {
        return longClickListener;
    }

    public void setLongClickListener(OnLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public boolean isUnderLined() {
        return underLined;
    }

    public void setUnderLined(boolean underLined) {
        this.underLined = underLined;
    }

    public boolean isStrikethrough() {
        return strikethrough;
    }

    public void setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getBackgroundColorRes() {
        return backgroundColorRes;
    }

    public void setBackgroundColorRes(int backgroundColorRes) {
        this.backgroundColorRes = backgroundColorRes;
    }

    @Override
    public SpannableString makeSpannableString(Context context) {
        SpannableString spannableString = new SpannableString(text);

        int length = text.length();
        TouchableSpan span = new TouchableSpan(context, this);
        spannableString.setSpan(span, 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        if (backgroundColor == 0 && backgroundColorRes != 0) {
            backgroundColor = context.getResources().getColor(backgroundColorRes);
        }
        if (backgroundColor != 0) {
            spannableString.setSpan(new BackgroundColorSpan(backgroundColor), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        if (textSize != 0) {
            spannableString.setSpan(new AbsoluteSizeSpan(textSize), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        if (strikethrough) {
            spannableString.setSpan(new StrikethroughSpan(), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        if (underLined) {
            spannableString.setSpan(new UnderlineSpan(), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return spannableString;
    }
}