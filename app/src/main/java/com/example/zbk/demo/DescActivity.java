package com.example.zbk.demo;

import android.content.Context;
import android.content.Intent;
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
        int questionId = (int)getIntent().getSerializableExtra("desc_questionId");
        return DescFragment.newInstance(questionId);
    }

    public static Intent newIntent(Context packageContext, int questionId){
        Intent intent = new Intent(packageContext, DescActivity.class);
        intent.putExtra("desc_questionId", questionId);
        return intent;
    }
}
