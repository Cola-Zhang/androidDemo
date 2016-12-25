package com.example.zbk.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.zbk.data.DataQuestion;
import com.example.zbk.fragment.DescFragment;
import com.example.zbk.manager.DataManager;

import java.util.List;


public class DescActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);

        viewPager = (ViewPager)findViewById(R.id.activity_desc_pager_view_id);
        FragmentManager fragmentManager = getSupportFragmentManager();
        int targetQuestionId = (int)getIntent().getSerializableExtra("desc_questionId");

        final List<DataQuestion> questions = DataManager.getInstance().getDataQuestions();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                DataQuestion question = questions.get(position);
                return DescFragment.newInstance(question.getQuestionId());
            }

            @Override
            public int getCount() {
                return questions.size();
            }
        });
        int index = 0;
        for (int i=0;i<questions.size();i++){
            DataQuestion question = questions.get(i);
            if(question.getQuestionId() == targetQuestionId){
                index = i;
                break;
            }
        }

        viewPager.setCurrentItem(index);
    }

    public static Intent newIntent(Context packageContext, int questionId){
        Intent intent = new Intent(packageContext, DescActivity.class);
        intent.putExtra("desc_questionId", questionId);
        return intent;
    }

    private ViewPager viewPager;
}
