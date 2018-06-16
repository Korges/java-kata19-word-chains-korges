package com.korges.krk.graph;

import java.util.ArrayList;


public class Word {

    private String text;
    private ArrayList<Word> closeWords;

    public Word(String text) {

        this.text = text;
        this.closeWords = new ArrayList<>();
    }

    public void addCloseWord(Word closeWord) {
        this.closeWords.add(closeWord);
    }

    public ArrayList<Word> getCloseWords() {
        return closeWords;
    }

    public String getWordValue() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
