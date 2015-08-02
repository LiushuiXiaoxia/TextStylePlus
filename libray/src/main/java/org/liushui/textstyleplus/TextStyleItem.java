package org.liushui.textstyleplus;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
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
    private int textSize;// 字体大小
    private int textColor = 0;// 字体颜色
    private float highlightAlpha = DEFAULT_ALPHA; // 按下的颜色
    private int backgroundColor;// 背景颜色
    private int backgroundColorRes;// 背景颜色
    private int typeFaceStyle = 0; // 样式

    private boolean underLined = false; // 下划线
    private boolean strikethrough = false; // 中划线
    private boolean superscript = false; // 上坐标
    private boolean subscript = false;// 下坐标

    private OnClickListener clickListener; // 点击事件
    private OnLongClickListener longClickListener;// 长按事件

    public TextStyleItem(String text) {
        this.text = text;
    }

    public int getTextColor() {
        return textColor;
    }

    public OnClickListener getClickListener() {
        return clickListener;
    }

    public OnLongClickListener getLongClickListener() {
        return longClickListener;
    }

    public String getText() {
        return text;
    }

    public TextStyleItem setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;

        return this;
    }

    public TextStyleItem setBackgroundColorRes(int backgroundColorRes) {
        this.backgroundColorRes = backgroundColorRes;
        return this;
    }

    public TextStyleItem setClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
        return this;
    }

    public TextStyleItem setHighlightAlpha(float highlightAlpha) {
        this.highlightAlpha = highlightAlpha;
        return this;
    }

    public TextStyleItem setLongClickListener(OnLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
        return this;
    }

    public TextStyleItem setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
        return this;
    }

    public TextStyleItem setSubscript(boolean subscript) {
        this.subscript = subscript;
        return this;
    }

    public TextStyleItem setSuperscript(boolean superscript) {
        this.superscript = superscript;
        return this;
    }

    public TextStyleItem setText(String text) {
        this.text = text;
        return this;
    }

    public TextStyleItem setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public TextStyleItem setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public TextStyleItem setTypeFaceStyle(int typeFaceStyle) {
        this.typeFaceStyle = typeFaceStyle;
        return this;
    }

    public TextStyleItem setUnderLined(boolean underLined) {
        this.underLined = underLined;
        return this;
    }

    @Override
    public SpannableString makeSpannableString(Context context) {
        SpannableString spannableString = new SpannableString(text);
        int length = spannableString.length();

        // strikethrough
        if (strikethrough) {
            spannableString.setSpan(new StrikethroughSpan(), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // underLined
        if (underLined) {
            spannableString.setSpan(new UnderlineSpan(), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // subscript
        if (subscript) {
            spannableString.setSpan(new SubscriptSpan(), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // superscript
        if (superscript) {
            spannableString.setSpan(new SuperscriptSpan(), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // click listener or long click listener
        if (clickListener != null || longClickListener != null) {
            TouchableSpan span = new TouchableSpan(context, this);
            spannableString.setSpan(span, 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // style
        if (typeFaceStyle != 0) {
            spannableString.setSpan(new StyleSpan(typeFaceStyle), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // background color
        if (backgroundColor == 0 && backgroundColorRes != 0) {
            backgroundColor = context.getResources().getColor(backgroundColorRes);
        }
        if (backgroundColor != 0) {
            spannableString.setSpan(new BackgroundColorSpan(backgroundColor), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // text color
        if (textColor != 0) {
            spannableString.setSpan(new ForegroundColorSpan(textColor), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // textSize
        if (textSize != 0) {
            spannableString.setSpan(new AbsoluteSizeSpan(textSize), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return spannableString;
    }
}