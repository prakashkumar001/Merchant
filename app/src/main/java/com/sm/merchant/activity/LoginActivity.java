package com.sm.merchant.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sm.merchant.R;
import com.sm.merchant.pinbox.PinEntryView;


public class LoginActivity extends AppCompatActivity {

    TextView signup;
    Button login, reset;
    LinearLayout userIDboxs, passwordBoxs;
    PinEntryView userid, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_scale);


        signup = (TextView) findViewById(R.id.register);
        login = (Button) findViewById(R.id.btn_login);
        reset = (Button) findViewById(R.id.btn_reset);

        userid = (PinEntryView) findViewById(R.id.pin_entry_userid);
        password = (PinEntryView) findViewById(R.id.pin_entry_password);

        userid.setOnPinEnteredListener(new PinEntryView.OnPinEnteredListener() {
            @Override
            public void onPinEntered(String pin) {

            }
        });
        password.setOnPinEnteredListener(new PinEntryView.OnPinEnteredListener() {
            @Override
            public void onPinEntered(String pin) {
                if (password.getText().toString().trim().length() >= 6) {
                    hidekeyboard();
                }
            }
        });

        userIDboxs = (LinearLayout) findViewById(R.id.ll_userid);
        passwordBoxs = (LinearLayout) findViewById(R.id.ll_password);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userid.getText().toString().trim().isEmpty() || !password.getText().toString().trim().isEmpty()) {
                    userid.getText().clear();
                    password.getText().clear();
                    showkeyboard();
                }
            }
        });
        userIDboxs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showkeyboard();

            }
        });
        passwordBoxs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showkeyboard();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), SignupActivity.class));
            }
        });
        /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), HomeActivity.class));
            }
        });*/

    }

    private void showkeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    private void hidekeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
