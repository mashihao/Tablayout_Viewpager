package com.msh.tablayout_viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);


        List<String> urls = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            urls.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2496571732,442429806&fm=26&gp=0.jpg");
        }
        LinearLayout imageGroup = findViewById(R.id.iamges);
        imageGroup.removeAllViews();
        for (int i = 0; i < urls.size(); i++) {
            String url = urls.get(i);
            Log.e("MSH",url);
            ImageView img = new ImageView(this);
            img.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            Glide.with(img).load(url).into(img);
            imageGroup.addView(img);

        }

    }


    private void start(int tab) {

        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("tab", tab - 1);
        startActivity(intent);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Log.e("MSH", "onClick");
        switch (v.getId()) {
            case R.id.button1: {
                start(1);
            }
            break;
            case R.id.button2: {
                start(2);
            }
            break;
            case R.id.button3: {
                start(3);
            }
            break;
            case R.id.button4: {
                start(4);
            }
            break;
            case R.id.button5: {
                start(5);
            }
            break;
        }
    }
}