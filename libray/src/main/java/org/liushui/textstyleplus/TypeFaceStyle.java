package org.liushui.textstyleplus;

import android.graphics.Typeface;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * TypeFaceStyle <br/>
 * Created by xiaqiulei on 2016-11-30.
 */
@IntDef({Typeface.NORMAL, Typeface.BOLD, Typeface.BOLD_ITALIC, Typeface.ITALIC})
@Retention(RetentionPolicy.SOURCE)
@interface TypeFaceStyle {
}