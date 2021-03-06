package com.example.zbk.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


public abstract class AppBaseActivity extends AppCompatActivity {


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
