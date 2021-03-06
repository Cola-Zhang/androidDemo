package com.example.zbk.demo;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.zbk.fragment.MainFragment;

public class MainActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
    }

    @Override
    public Fragment createCommonFragment() {
        return MainFragment.newInstance();
    }
}
