package org.liushui.textstyleplus;

import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * StyleBuilder <br/>
 * Created by xiaqiulei on 2015-07-27.
 */
public class StyleBuilder {

    private List<ISpannable> items;
    private SpannableStringBuilder builder;

    public StyleBuilder() {
        items = new ArrayList<>();
        builder = new SpannableStringBuilder();
    }

    public StyleBuilder addStyleItem(ISpannable item) {
        items.add(item);

        return this;
    }

    public StyleBuilder newLine() {
        items.add(new TextStyleItem("\n"));

        return this;
    }

    public void show(TextView textView) {
        for (ISpannable item : items) {
            builder.append(item.makeSpannableString(textView.getContext()));
        }

        textView.setText(builder);

        addLinkMovementMethod(textView);
    }

    /**
     * Add the movement method to handle the clicks.
     */
    private void addLinkMovementMethod(TextView textView) {
        MovementMethod m = textView.getMovementMethod();

        boolean isTouchableMovementMethod = m instanceof TouchableMovementMethod;

        if (m == null || !isTouchableMovementMethod) {
            if (textView.getLinksClickable()) {
                textView.setMovementMethod(TouchableMovementMethod.getInstance());
            }
        }
    }
}