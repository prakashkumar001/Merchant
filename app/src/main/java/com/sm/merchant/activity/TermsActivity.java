package com.sm.merchant.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.sm.merchant.R;

public class TermsActivity extends AppCompatActivity {

    RelativeLayout frame;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        overridePendingTransition(R.anim.activity_open_translate_bottom, R.anim.activity_close_scale_bottom);

        frame = (RelativeLayout) findViewById(R.id.rv_frame);

        back = (ImageView) findViewById(R.id.iv_close);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                TermsActivity.this.overridePendingTransition(R.anim.activity_open_scale_bottom, R.anim.activity_close_translate_bottom);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        TermsActivity.this.overridePendingTransition(R.anim.activity_open_scale_bottom, R.anim.activity_close_translate_bottom);
    }
}
