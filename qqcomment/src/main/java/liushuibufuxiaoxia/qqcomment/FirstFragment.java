package liushuibufuxiaoxia.qqcomment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * FirstFragment <br/>
 * Created by xiaqiulei on 2015-08-05.
 */
public class FirstFragment extends Fragment {

    @InjectView(R.id.textview)
    TextView textview;

    String host = "流水不腐";
    String[] names = {"张三", "李四", "二狗子"};
    String comment = "土豪求带啊";

    int color = Color.BLUE;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        for (String name : names) {
            String text = String.format("%s回复%s:%sicon\n", name, host, comment);
            SpannableString string = new SpannableString(text);
            string.setSpan(new ForegroundColorSpan(color), 0, name.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            string.setSpan(new ForegroundColorSpan(color), name.length() + 2, name.length() + 2 + host.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            string.setSpan(new ImageSpan(bitmap), text.length() - 5, text.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.append(string);
        }

        textview.setText(builder);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}