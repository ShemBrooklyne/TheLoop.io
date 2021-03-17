package com.example.testbg.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testbg.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.registerId) Button mRegister2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mRegister2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mRegister2) {
            Intent intent = new Intent(LoginActivity.this, KenyanNews.class);
            startActivity(intent);
        }
    }
}