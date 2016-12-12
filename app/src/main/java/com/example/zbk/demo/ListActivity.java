package com.example.zbk.demo;


import android.os.Bundle;
import android.support.v4.app.Fragment;

public class ListActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
    }

    @Override
    public Fragment createCommonFragment() {
        return null;
    }
}
