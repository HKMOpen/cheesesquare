package com.support.android.designlibdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hesk on 2016/9/18.
 */

public class CheeseFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentparent);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_ls_fmc, new CHomedFragment()).commit();
    }
}
