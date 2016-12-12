package com.example.zbk.data;

/**
 * Created by zhangbaokun on 12/12/2016.
 */

public class DataQuestion {
    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public DataQuestion(int questionId){
        this.questionId = questionId;
    }

    private int questionId;
    private String questionText;
}
