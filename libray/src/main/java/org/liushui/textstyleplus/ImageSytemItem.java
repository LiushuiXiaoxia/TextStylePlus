package org.liushui.textstyleplus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ImageSpan;

/**
 * ImageSytemItem <br/>
 * Created by xiaqiulei on 2015-07-28.
 */
public class ImageSytemItem implements ISpannable {

    private int imageRes;

    private int imageColor;

    private int imageColorRes;

    private Bitmap imageBitmap;

    private Drawable imageDrawable;

    private int width, height;

    public ImageSytemItem() {
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }

    public int getImageColor() {
        return imageColor;
    }

    public void setImageColor(int imageColor) {
        this.imageColor = imageColor;
    }

    public int getImageColorRes() {
        return imageColorRes;
    }

    public void setImageColorRes(int imageColorRes) {
        this.imageColorRes = imageColorRes;
    }

    public Drawable getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(Drawable imageDrawable) {
        this.imageDrawable = imageDrawable;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    /**
     * 如果传入的不是图片，如color，则需要传入显示的大小
     *
     * @param width
     * @param height
     */
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public SpannableString makeSpannableString(Context context) {
        String text = "1234567890->1234567890->1234567890->1234567890->1234567890->";
        int length = text.length();

        SpannableString spannableString = new SpannableString(text);

        if (imageDrawable == null && imageRes != 0) {
            imageDrawable = context.getResources().getDrawable(imageRes);
        }

        if (imageDrawable == null) {
            if (imageColor == 0 && imageColorRes != 0) {
                imageColor = context.getResources().getColor(imageColorRes);
            }
            if (imageColor != 0) {
                imageDrawable = new ColorDrawable(imageColor);
            }
        }

        if (imageDrawable != null) {
//            if (width != 0 && height != 0) {
//                imageDrawable.setBounds(0, 0, width, height);
//            } else {
//                imageDrawable.setBounds(0, 0, imageDrawable.getIntrinsicWidth(), imageDrawable.getIntrinsicHeight());
//            }


            TextPaint tp = new TextPaint();
            tp.setColor(Color.BLUE);
            tp.setStyle(Paint.Style.FILL);
            tp.setTextSize(100);

            Rect padding = new Rect();
            imageDrawable.getPadding(padding);
            int textWidth = (int) tp.measureText(text) + padding.left + padding.right;
            int textHeight = (int) (tp.ascent() - tp.descent()) - padding.top - padding.bottom;

            imageDrawable.setBounds(0, 0, textWidth, -textHeight);

            Bitmap bitmap = Bitmap.createBitmap(textWidth, 0 - textHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            imageDrawable.draw(canvas);

            canvas.save();
            canvas.translate(0, padding.top);
            StaticLayout layout = new StaticLayout(text, tp, canvas.getWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            layout.getHeight();
            layout.draw(canvas);
            canvas.restore();

            spannableString.setSpan(new ImageSpan(bitmap), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else if (imageBitmap != null) {
//            Bitmap bitmap = Bitmap.createBitmap(imageBitmap.getWidth(), imageBitmap.getHeight(), Bitmap.Config.ARGB_8888);
//            Canvas canvas = new Canvas(bitmap);
//            canvas.drawBitmap(imageBitmap, 0, 0, null);
//
//            TextPaint tp = new TextPaint();
//            tp.setColor(Color.BLUE);
//            tp.setStyle(Paint.Style.FILL);
//            tp.setTextSize(200);
//            StaticLayout layout = new StaticLayout(text, tp, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
//            layout.draw(canvas);

            spannableString.setSpan(new ImageSpan(imageBitmap), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }


        return spannableString;
    }
}
