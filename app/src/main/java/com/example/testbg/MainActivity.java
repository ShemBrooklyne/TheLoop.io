package com.example.testbg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.register) Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            int startColor = getWindow().getStatusBarColor();
//            int endColor = ContextCompat.getColor(context, R.color.teal_700);
//            ObjectAnimator.ofArgb(getWindow(), "statusBarColor", startColor, endColor).start();
//        }

        mRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mRegister) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}