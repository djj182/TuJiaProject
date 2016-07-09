package com.dwz1676.tujiaproject.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.dwz1676.tujiaproject.R;

/**
 * Created by Administrator on 16-7-8.
 */
public class MoreActivity extends AppCompatActivity {

    private ImageView imageview_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_activity);
        imageview_back = (ImageView) findViewById(R.id.imageview_back);
        imageview_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
