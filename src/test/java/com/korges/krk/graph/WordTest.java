package com.korges.krk.graph;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordTest {

    static private Word word;

    @BeforeAll
    static void createWord() {
        word = new Word("testWord");
    }

    @Test
    void addCloseWordTest() {
        Word closeWord = new Word("testCloseWord");
        word.addCloseWord(closeWord);
        ArrayList<Word> closeWordsList = word.getCloseWords();

        assertEquals(closeWord, closeWordsList.get(0));
    }

    @Test
    void getWordValueTest() {

        String expected = "testWord";

        assertEquals(expected, word.getWordValue());
    }

    @Test
    void toStringTest() {

        String expected = "testWord";
        assertEquals(expected, word.toString());
    }

}