package com.example.mike168m.lab1;

public class Question {
    private int textResId;
    private boolean anserTrue;

    public Question(int textResId, boolean anserTrue) {
        this.textResId = textResId;
        this.anserTrue = anserTrue;
    }

    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    public boolean isAnserTrue() {
        return anserTrue;
    }

    public void setAnserTrue(boolean anserTrue) {
        this.anserTrue = anserTrue;
    }
}
