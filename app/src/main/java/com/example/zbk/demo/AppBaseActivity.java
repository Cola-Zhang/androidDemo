package com.example.zbk.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by zhangbaokun on 12/12/2016.
 */

public abstract class AppBaseActivity extends FragmentActivity {


    public abstract Fragment createCommonFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.fragment_container);
        if (frag == null) {
            frag = createCommonFragment();
            fm.beginTransaction().add(R.id.fragment_container, frag).commit();
        }
    }
}
