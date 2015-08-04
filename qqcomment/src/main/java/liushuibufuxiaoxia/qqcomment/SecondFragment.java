package liushuibufuxiaoxia.qqcomment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.liushui.textstyleplus.StyleBuilder;
import org.liushui.textstyleplus.TextStyleItem;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * FirstFragment <br/>
 * Created by xiaqiulei on 2015-08-05.
 */
public class SecondFragment extends Fragment {

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

        StyleBuilder styleBuilder = new StyleBuilder();
        for (String name : names) {
            styleBuilder.addStyleItem(
                    new TextStyleItem(name).setTextColor(color).setClickListener(new TextStyleItem.OnClickListener() {
                        @Override
                        public void onClick(String clickedText) {
                            Toast.makeText(SecondFragment.this.getActivity(), "text = " + clickedText, Toast.LENGTH_SHORT).show();
                        }
                    }))
                    .text("回复:")
                    .addStyleItem(new TextStyleItem(host).setTextColor(color))
                    .addStyleItem(new TextStyleItem("icon").setIconRes(R.drawable.ic_launcher))
                    .newLine();
        }
        styleBuilder.show(textview);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}