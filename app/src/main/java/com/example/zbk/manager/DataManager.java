package com.example.zbk.manager;

import com.example.zbk.data.DataQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangbaokun on 12/12/2016.
 */

public class DataManager {

    public static DataManager getInstance(){
        if(instance == null){
            instance = new DataManager();
        }
        return instance;
    }

    public List<DataQuestion> getDataQuestions() {
        return dataQuestions;
    }

    public DataQuestion getDataQuestion(int questionId){
        for (DataQuestion dataQuestion:dataQuestions) {
            if(dataQuestion.getQuestionId() == questionId){
                return dataQuestion;
            }
        }
        return null;
    }

    private DataManager(){
        dataQuestions = new ArrayList<DataQuestion>();
        for (int i=0;i<100;i++){
            DataQuestion dt = new DataQuestion(i+1);
            dt.setQuestionText("this is question"+(i+1));
        }
    }

    private static DataManager instance;
    private List<DataQuestion> dataQuestions;
}
