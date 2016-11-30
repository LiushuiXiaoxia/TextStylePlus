/*
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */

package org.liushui.textstyleplus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.View;

class TouchableSpan extends ClickableSpan {

    protected static TypedArray obtainStyledAttrsFromThemeAttr(Context context, int themeAttr, int[] styleAttrs) {
        // Need to get resource id of style pointed to from the theme attr
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(themeAttr, outValue, true);
        final int styleResId = outValue.resourceId;

        // Now return the values (from styleAttrs) from the style
        return context.obtainStyledAttributes(styleResId, styleAttrs);
    }

    private final TextStyleItem textStyleItem;
    public boolean touched = false;
    private int textColor;

    /**
     * Construct new TouchableSpan using the styleItem
     */
    TouchableSpan(Context context, TextStyleItem textStyleItem) {
        this.textStyleItem = textStyleItem;

        if (textStyleItem.textColor == 0) {
            this.textColor = getDefaultColor(context);
        } else {
            this.textColor = textStyleItem.textColor;
        }
    }

    /**
     * Finds the default color for links based on the current theme.
     *
     * @param context activity
     * @return color as an integer
     */
    private int getDefaultColor(Context context) {
//        TypedArray array = obtainStyledAttrsFromThemeAttr(context, R.attr.linkBuilderStyle, R.styleable.LinkBuilder);
//        int color = array.getColor(R.styleable.LinkBuilder_defaultLinkColor, Link.DEFAULT_COLOR);
//        array.recycle();

        return Color.BLACK;
    }

    /**
     * This TouchableSpan has been clicked.
     *
     * @param widget TextView containing the touchable span
     */
    public void onClick(View widget) {

        // handle the click
        if (textStyleItem.clickListener != null) {
            textStyleItem.clickListener.onClick(textStyleItem.text);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TouchableMovementMethod.touched = false;
            }
        }, 500);
    }

    /**
     * This TouchableSpan has been long clicked.
     *
     * @param widget TextView containing the touchable span
     */
    void onLongClick(View widget) {

        // handle the long click
        if (textStyleItem.longClickListener != null) {
            textStyleItem.longClickListener.onLongClick(textStyleItem.text);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TouchableMovementMethod.touched = false;
            }
        }, 500);
    }


    /**
     * Draw the links background and set whether or not we want it to be underlined
     *
     * @param ds the styleItem
     */
    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);

        ds.setUnderlineText(false);
        ds.setColor(textColor);
        // ds.bgColor = touched ? adjustAlpha(textColor, textStyleItem.getHighlightAlpha()) : Color.TRANSPARENT;
    }

    /**
     * Set the alpha for the color based on the alpha factor
     *
     * @param color  original color
     * @param factor how much we want to scale the alpha to
     * @return new color with scaled alpha
     */
    protected int adjustAlpha(int color, float factor) {
        int alpha = Math.round(Color.alpha(color) * factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }

    /**
     * Specifiy whether or not the styleItem is currently touched
     */
    void setTouched(boolean touched) {
        this.touched = touched;
    }
}