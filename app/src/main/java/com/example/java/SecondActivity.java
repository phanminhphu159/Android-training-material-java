package com.example.java;

import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends BaseActivity{
    @Override
    protected void initialize() {
        setContentView(R.layout.activity_second);
        Product product = getIntent().getExtras().getParcelable("parcelable");
        TextView tvHelloWorld = findViewById(R.id.tvHelloWorld);
        tvHelloWorld.setText(product.id);
//        tvHelloWorld.setText(getResources().getString(R.string.text_view));
    }
}
