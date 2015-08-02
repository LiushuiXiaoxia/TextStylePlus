# TextStylePlus
android textview style

Ii's like [BabushkaText](https://github.com/quiqueqs/BabushkaText) or [Android-TextView-LinkBuilder](https://github.com/klinker24/Android-TextView-LinkBuilder)
# Demo

```
TextView textView = (TextView) findViewById(R.id.textview);

TextStyleItem one = new TextStyleItem("http://www.baidu.com")
        .setTextColor(Color.parseColor("#f00f0f"))
        .setClickListener(new TextStyleItem.OnClickListener() {
            @Override
            public void onClick(String clickedText) {
                Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_SHORT).show();
            }
        });


TextStyleItem two = new TextStyleItem("Liushuixiaoxia")
        .setTextColor(Color.parseColor("#f0aa0f"))
        .setLongClickListener(new TextStyleItem.OnLongClickListener() {
            @Override
            public void onLongClick(String clickedText) {
                Toast.makeText(MainActivity.this, "onLongClick", Toast.LENGTH_SHORT).show();
            }
        });

TextStyleItem three = new TextStyleItem("TestBackground")
        .setTextColor(Color.WHITE)
        .setBackgroundColor(Color.BLACK)
        .setTextSize(Utils.dip2px(this, 20))
        .setLongClickListener(new TextStyleItem.OnLongClickListener() {
            @Override
            public void onLongClick(String clickedText) {
                Toast.makeText(MainActivity.this, "onLongClick", Toast.LENGTH_SHORT).show();
            }
        });

new StyleBuilder()
        .addStyleItem(one)
        .newLine()
        .addStyleItem(two)
        .newLine()
        .addStyleItem(three)
        .newLine()
        .addStyleItem(new TextStyleItem("http://www.google.com").setUnderLined(true))
        .newLine()
        .addStyleItem(new TextStyleItem("http://www.google.com").setStrikethrough(true))
        .newLine()
        .text("TEST")
        .addStyleItem(
                new TextStyleItem("subscript")
                        .setSubscript(true)
                        .setTextColor(Color.parseColor("#f00f0f"))
        )
        .addStyleItem(
                new TextStyleItem("superscript")
                        .setSuperscript(true)
                        .setTextColor(Color.parseColor("#f00f0f"))
        )
        .newLine()
        .addStyleItem(new TextStyleItem("Style").setTypeFaceStyle(Typeface.BOLD))
        .newLine()
        .show(textView);
```

![Demo](image/device-2015-08-02-154539.png)


![Demo](image/device-2015-08-02-154611.png)