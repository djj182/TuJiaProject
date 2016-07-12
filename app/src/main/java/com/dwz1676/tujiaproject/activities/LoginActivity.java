package com.dwz1676.tujiaproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dwz1676.tujiaproject.R;

/**
 * Created by Administrator on 2016/7/6.
 */
public class LoginActivity extends AppCompatActivity {

    private View mLoginLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        View back = findViewById(R.id.loginactivity_back);
        mLoginLayout = findViewById(R.id.third_login_ll);
        Intent intent = getIntent();
        int thirdFlag = intent.getIntExtra("thirdFlag", 0);
        if (thirdFlag == 0)
            mLoginLayout.setVisibility(View.GONE);
        else if (thirdFlag == 1) {
            mLoginLayout.setVisibility(View.VISIBLE);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void thirdLogin(View view) {

    }
}