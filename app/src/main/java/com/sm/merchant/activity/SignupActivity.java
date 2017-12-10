package com.sm.merchant.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.sm.merchant.R;
import com.sm.merchant.spinner.NiceSpinner;

import java.util.ArrayList;

public class SignupActivity extends AppCompatActivity {

    ImageView back;
    ArrayList<String> spinnerItems = new ArrayList<String>();
    ArrayList<String> merchantCategoryItems = new ArrayList<String>();
    NiceSpinner spinnerSalutation, merchantCategory;
    TextView submit, save, terms;
    CheckBox termBox;
    RelativeLayout frame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_scale);

        spinnerSalutation = (NiceSpinner) findViewById(R.id.gender);
        merchantCategory = (NiceSpinner) findViewById(R.id.merchant_category);
        submit = (TextView) findViewById(R.id.btn_submit);
        save = (TextView) findViewById(R.id.btn_save);
        terms = (TextView) findViewById(R.id.tv_terms);
        termBox = (CheckBox) findViewById(R.id.cb_register1);
        frame = (RelativeLayout) findViewById(R.id.rv_frame);

        back = (ImageView) findViewById(R.id.iv_close);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SignupActivity.this.overridePendingTransition(R.anim.activity_open_scale, R.anim.activity_close_translate);
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(getBaseContext(), TermsActivity.class));
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (termBox.isChecked()) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            SignupActivity.this);
                    alertDialogBuilder
                            .setMessage("Data submitted")
                            .setCancelable(false)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    alertDialog.show();
                } else {
                    Snackbar.make(frame, "Please, Accept terms & conditions", Snackbar.LENGTH_LONG).setAction("Dismiss", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        SignupActivity.this);
                alertDialogBuilder
                        .setMessage("Data saved")
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();
            }
        });

        spinnerItems.clear();
        spinnerItems.add("Male");
        spinnerItems.add("Female");
        spinnerItems.add("Other");
        spinnerSalutation.attachDataSource(spinnerItems);
        merchantCategoryItems.clear();
        merchantCategoryItems.add("Grocery Shop");
        merchantCategoryItems.add("Gas Station");
        merchantCategory.attachDataSource(merchantCategoryItems);


    }

    @Override
    public void onBackPressed() {
        finish();
        SignupActivity.this.overridePendingTransition(R.anim.activity_open_scale, R.anim.activity_close_translate);
    }
}
