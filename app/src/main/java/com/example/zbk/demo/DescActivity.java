package com.example.zbk.demo;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.example.zbk.fragment.DescFragment;

public class DescActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
    }

    @Override
    public Fragment createCommonFragment() {
        return DescFragment.newInstance();
    }
}
