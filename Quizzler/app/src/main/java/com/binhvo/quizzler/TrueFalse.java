package com.binhvo.quizzler;

// Template class
public class TrueFalse {
    private int questionID; // questions in string xml
    private boolean answer;

    public TrueFalse(int questionResourceID, boolean trueORfalse) {
        questionID = questionResourceID;
        answer = trueORfalse;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
