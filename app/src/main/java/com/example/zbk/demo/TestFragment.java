package com.example.zbk.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by zhangbaokun on 05/12/2016.
 */

public class TestFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TestFragment","onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("TestFragment","onCreateView");
        View v = inflater.inflate(R.layout.fragment_test, container, false);
        EditText mEditText = (EditText)v.findViewById(R.id.test_editTextId);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        CheckBox checkBox = (CheckBox)v.findViewById(R.id.test_checkBoxId);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("TestFragmet", "isChecked "+isChecked);
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TestFragment","onActivityCreated");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("TestFragment","onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TestFragment","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TestFragment","onResume");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TestFragment","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TestFragment","onDetach");
    }
}
