package com.korges.krk.graph;

import java.util.ArrayList;
import java.util.List;


public class Word {

    private String text;
    private List<Word> closeWords;

    public Word(String text) {

        this.text = text;
        this.closeWords = new ArrayList<>();
    }

    public void addCloseWord(Word closeWord) {
        this.closeWords.add(closeWord);
    }

    public List<Word> getCloseWords() {
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
