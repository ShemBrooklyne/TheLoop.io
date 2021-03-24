package com.example.testbg.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testbg.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavScreen extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.localCard) CardView mLocal;
    @BindView(R.id.techCard) CardView mTech;
    @BindView(R.id.worldCard) CardView mWorld;
    @BindView(R.id.sportsCard) CardView mSports;
    @BindView(R.id.healthCard) CardView mHealth;
    @BindView(R.id.businessCard) CardView mBusiness;


    CarouselView customCarouselView;


    int[] sampleImages = {
            R.drawable.carousel1,
            R.drawable.carousel2,
            R.drawable.carousel3,
            R.drawable.carousel4,
            R.drawable.carousel5,
            R.drawable.carousel6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_screen);
        ButterKnife.bind(this);

//        ActionBar actionBar = getActionBar();
//        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#93E9FA"));
//        actionBar.setBackgroundDrawable(colorDrawable);

        customCarouselView = (CarouselView) findViewById(R.id.customCarouselView);
        customCarouselView.setPageCount(sampleImages.length);
        customCarouselView.setSlideInterval(4000);
        customCarouselView.setViewListener(viewListener);


        mLocal.setOnClickListener(this);
        mTech.setOnClickListener(this);
        mWorld.setOnClickListener(this);
        mSports.setOnClickListener(this);
        mHealth.setOnClickListener(this);
        mBusiness.setOnClickListener(this);
    }

    // To set custom views
    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {

            View customView = getLayoutInflater().inflate(R.layout.view_custom, null);

            ImageView IntroImageView = (ImageView) customView.findViewById(R.id.intoImageView);


            IntroImageView.setImageResource(sampleImages[position]);

            return customView;
        }
    };

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
