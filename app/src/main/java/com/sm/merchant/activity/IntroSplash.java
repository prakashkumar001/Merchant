package com.sm.merchant.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.sm.merchant.R;
import com.sm.merchant.adapter.IntroTabAdapter;
import com.sm.merchant.indicator.CircleIndicator;


public class IntroSplash extends AppCompatActivity {

    ViewPager viewPager;
    CircleIndicator indicator;
    Button next;
    public static IntroSplash activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        activity = this;

        next = (Button) findViewById(R.id.tv_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });


        viewPager = (ViewPager) findViewById(R.id.v_pager);
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        IntroTabAdapter adapter = new IntroTabAdapter(getSupportFragmentManager(), 2);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    next.setVisibility(View.VISIBLE);
                    Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                    next.startAnimation(animation2);
                } else if(position == 1){
                    next.setVisibility(View.GONE);
                    Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                    next.startAnimation(animation2);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}
