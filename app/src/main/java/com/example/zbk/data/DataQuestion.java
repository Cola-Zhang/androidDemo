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

    public boolean getIsSelect(){
        return isSelect;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setSelect(boolean isSelect){
        this.isSelect = isSelect;
    }

    public DataQuestion(int questionId){
        this.questionId = questionId;
        this.isSelect = questionId%2==0;
    }

    private int questionId;
    private String questionText;
    private boolean isSelect;
}
