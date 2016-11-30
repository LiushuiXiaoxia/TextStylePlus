package org.liushui.textstyleplus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

/**
 * ImageSytemItem <br/>
 * Created by xiaqiulei on 2015-07-28.
 */
class ImageStytle extends TextStyle {

    @ColorInt
    private int imageColor;
    @ColorRes
    private int imageColorRes;

    @DrawableRes
    private int imageRes;
    private Bitmap imageBitmap;
    private Drawable imageDrawable;

    // 如果传入的不是图片，如color，则需要传入显示的大小
    private int width, height;

    ImageStytle(String text,
                int textSize,
                int textColor,
                float highlightAlpha,
                int backgroundColor,
                int backgroundColorRes,
                int typeFaceStyle,
                int iconRes,
                Drawable iconDrawable,
                Bitmap iconBitmap,
                boolean underLined,
                boolean strikethrough,
                boolean superscript,
                boolean subscript,
                ClickListener clickListener,
                LongClickListener longClickListener,
                int imageColor,
                int imageColorRes,
                int imageRes,
                Bitmap imageBitmap,
                Drawable imageDrawable,
                int width,
                int height) {

        super(text, textSize, textColor, highlightAlpha,
                backgroundColor, backgroundColorRes,
                typeFaceStyle, iconRes, iconDrawable,
                iconBitmap, underLined, strikethrough,
                superscript, subscript, clickListener,
                longClickListener);

        this.imageColor = imageColor;
        this.imageColorRes = imageColorRes;
        this.imageRes = imageRes;
        this.imageBitmap = imageBitmap;
        this.imageDrawable = imageDrawable;
        this.width = width;
        this.height = height;
    }


    @Override
    public SpannableString makeSpannableString(Context context) {
        SpannableString spannableString = super.makeSpannableString(context);
        int length = spannableString.length();

        if (imageDrawable == null && imageRes != 0) {
            try {
                imageDrawable = context.getResources().getDrawable(imageRes);
            } catch (Exception e) {
                Logs.i("get drawable fail, imageRes = %s, e = %s", imageRes, e);
            }
        }

        if (imageDrawable == null) {
            if (imageColor == 0 && imageColorRes != 0) {
                try {
                    imageColor = context.getResources().getColor(imageColorRes);
                } catch (Exception e) {
                    Logs.i("get color fail, imageColor = %s, e = %s", imageColorRes, e);
                }
            }
            if (imageColor != 0) {
                imageDrawable = new ColorDrawable(imageColor);
            }
        }

        if (imageDrawable == null && imageBitmap != null) {
            imageDrawable = new BitmapDrawable(imageBitmap);
        }

        if (imageDrawable != null) {
            // 背景大小
            final Rect padding = new Rect();
            imageDrawable.getPadding(padding);

            ImageSpan imageSpan = new ImageSpan(imageDrawable) {
                @Override
                public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end,
                                 float x, int top, int y, int bottom, @NonNull Paint paint) {

                    // 设置边框
                    Drawable drawable = getDrawable();
                    int width = Math.round(paint.measureText(text, start, end)) + padding.left + padding.right;
                    int height = Math.round(paint.ascent() - paint.descent() - padding.top - padding.bottom);
                    drawable.setBounds(0, 0, width, Math.abs(height));

                    super.draw(canvas, text, start, end, x, top, y, bottom, paint);

                    // 绘制字体
                    Paint textPaint = new Paint(paint);
                    textPaint.setColor(textColor);
                    // textPaint.textSize(textSize);
                    float newY = y - padding.bottom - (textPaint.getFontMetrics().bottom - textPaint.descent());
                    canvas.drawText(text.subSequence(start, end).toString(), x + padding.left, newY, textPaint);
                }
            };
            spannableString.setSpan(imageSpan, 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return spannableString;
    }
}
