package com.example.zbk.fragment;

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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.zbk.data.DataQuestion;
import com.example.zbk.demo.R;
import com.example.zbk.manager.DataManager;


public class DescFragment extends Fragment {

    public static String QUESTION_ID = "QUESTION_ID";

    public static DescFragment newInstance(int questionId) {
        DescFragment fragment = new DescFragment();
        Bundle args = new Bundle();
        args.putSerializable(QUESTION_ID, questionId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questionId = (int)getArguments().getSerializable(QUESTION_ID);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("DescFragment","onCreateView");
        View v = inflater.inflate(R.layout.fragment_desc, container, false);
        final EditText mEditText = (EditText)v.findViewById(R.id.desc_editTextId);

        final DataQuestion question = DataManager.getInstance().getDataQuestion(questionId);
        mEditText.setText(question.getQuestionText());
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

        final CheckBox checkBox = (CheckBox)v.findViewById(R.id.desc_checkBoxId);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("DescFragment", "isChecked "+isChecked);
            }
        });

        Button returnBtn = (Button)v.findViewById(R.id.desc_returnBtnId);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        Button confirmButton = (Button)v.findViewById(R.id.desc_confirmBtnId);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mEditText.getText().toString();
                boolean isSelect = checkBox.isSelected();
                question.setQuestionText(text);
                question.setSelect(isSelect);
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("DescFragment","onActivityCreated");
    }


    private int questionId;
}
