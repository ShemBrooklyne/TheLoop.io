package com.example.testbg.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testbg.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.register) Button mRegister;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.loginbtn) Button mLogin;

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
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mRegister) {
            Intent intent = new Intent(MainActivity.this, TechNews.class);
            startActivity(intent);
        }

        if (view == mLogin) {
            Intent intent = new Intent(MainActivity.this, KenyanNews.class);
            startActivity(intent);
        }
    }
}