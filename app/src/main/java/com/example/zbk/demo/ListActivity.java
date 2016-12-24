package com.example.zbk.demo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.zbk.fragment.ListFragment;

public class ListActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        Log.e("ListActivity", "onCreate");
    }

    @Override
    public Fragment createCommonFragment() {
        return ListFragment.newInstance();
    }
}
