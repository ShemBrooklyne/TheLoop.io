package com.example.testbg.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.testbg.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavScreen extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.localCard) CardView mLocal;
    @BindView(R.id.techCard) CardView mTech;
    @BindView(R.id.worldCard) CardView mWorld;
    @BindView(R.id.sportsCard) CardView mSports;
    @BindView(R.id.healthCard) CardView mHealth;
    @BindView(R.id.businessCard) CardView mBusiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_screen);
        ButterKnife.bind(this);

        mLocal.setOnClickListener(this);
        mTech.setOnClickListener(this);
        mWorld.setOnClickListener(this);
        mSports.setOnClickListener(this);
        mHealth.setOnClickListener(this);
        mBusiness.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == mLocal) {
            Intent intent = new Intent(NavScreen.this, KenyanNews.class);
            startActivity(intent);
        }

        if (view == mTech) {
            Intent intent = new Intent(NavScreen.this, TechNews.class);
            startActivity(intent);
        }

        if (view == mWorld) {
            Intent intent = new Intent(NavScreen.this, WorldNews.class);
            startActivity(intent);
        }

        if (view == mSports) {
            Intent intent = new Intent(NavScreen.this, SportsNews.class);
            startActivity(intent);
        }

        if (view == mHealth) {
            Intent intent = new Intent(NavScreen.this, HealthNews.class);
            startActivity(intent);
        }

        if (view == mBusiness) {
            Intent intent = new Intent(NavScreen.this, BusinessNews.class);
            startActivity(intent);
        }

    }
}
