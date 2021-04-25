package com.msh.tablayout_viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
            case R.id.button2: {
                start(2);
            }

            case R.id.button3: {
                start(3);
            }

            case R.id.button4: {
                start(4);
            }
            case R.id.button5: {
                start(5);
            }

        }
    }
}