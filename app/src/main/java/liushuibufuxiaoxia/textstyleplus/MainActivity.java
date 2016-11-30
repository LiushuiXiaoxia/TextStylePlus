package liushuibufuxiaoxia.textstyleplus;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.liushui.textstyleplus.StyleBuilder;
import org.liushui.textstyleplus.TextStyleItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = (TextView) findViewById(R.id.textview);


        new StyleBuilder()
                .addTextStyle("Test click.").setTextColor(Color.parseColor("#ff0000"))
                .setClickListener(new TextStyleItem.OnClickListener() {
                    @Override
                    public void onClick(String clickedText) {
                        Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_SHORT).show();
                    }
                })
                .commit().addNewLine().addNewLine()

                .addTextStyle("Test long click.").setTextColor(Color.parseColor("#ff0000"))
                .setLongClickListener(new TextStyleItem.OnLongClickListener() {
                    @Override
                    public void onLongClick(String clickedText) {
                        Toast.makeText(MainActivity.this, "onLongClick", Toast.LENGTH_SHORT).show();
                    }
                })
                .commit().addNewLine().addNewLine()

                .addTextStyle("Test background.").setTextColor(Color.GREEN).setBackgroundColor(Color.BLUE)
                .setTextSize(Utils.dip2px(this, 20))
                .setLongClickListener(new TextStyleItem.OnLongClickListener() {
                    @Override
                    public void onLongClick(String clickedText) {
                        Toast.makeText(MainActivity.this, "onLongClick", Toast.LENGTH_SHORT).show();
                    }
                })
                .commit().addNewLine().addNewLine()

                .addTextStyle("Test under line. http://www.google.com").setUnderLined(true).setTextColor(Color.BLUE)
                .commit().addNewLine().addNewLine()

                .addTextStyle("Test strikethrough. http://www.google.com").setStrikethrough(true).setTextColor(Color.BLUE)
                .commit().addNewLine().addNewLine()

                .addTextStyle("Test subscript.").setSubscript(true).setTextColor(Color.GREEN)
                .commit().addNewLine().addNewLine()

                .addTextStyle("Test superscript.").setSuperscript(true).setTextColor(Color.GREEN)
                .commit().addNewLine().addNewLine()

                .addTextStyle("Test type face.").setTypeFaceStyle(Typeface.BOLD).setTextColor(Color.BLACK)
                .commit().addNewLine().addNewLine()

                .addText("Test image1.")
                .addTextStyle("image").setIconRes(R.drawable.ic1)
                .commit().addNewLine().addNewLine()

                .addText("Test image2.")
                .addTextStyle("image").setIconDrawable(getResources().getDrawable(R.drawable.ic2))
                .commit().addNewLine().addNewLine()

                .addText("Test image3.")
                .addTextStyle("image").setIconBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic3))
                .commit().addNewLine().addNewLine()

                .addText("Test text and image.")
                .addImageStyle("流水不腐").setImageRes(R.drawable.image_drawable).setTextColor(Color.BLUE)
                .commit().addNewLine().addNewLine()

                .addImageStyle("Test text and image.").setImageRes(R.drawable.ic_launcher).setTextColor(Color.BLACK)
                .commit().addNewLine().addNewLine()

                .show(textView);
    }
}