package com.korges.krk.graph;

import com.korges.krk.exception.WordNotInWordListException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;


class WordGraphTest {

    private static WordGraph wordGraph;

    @BeforeAll
    static void createWordGraph() {
        wordGraph = new WordGraph();
    }

    @Test
    void getWordByValue1() {
        Word testWord = new Word("testWord");
        wordGraph.addWord(testWord);

        try {
            assertEquals(testWord, wordGraph.getWordByValue("testWord"));
        } catch (WordNotInWordListException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getWordByValue2() {
        assertThrows(WordNotInWordListException.class, ()->wordGraph.getWordByValue("wrongData"));

    }



    @Test
    void compareWordsTestifTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = wordGraph.getClass().getDeclaredMethod("compareWords", String.class, String.class);
        method.setAccessible(true);

        boolean response = (boolean) method.invoke(wordGraph, "dog", "dod");

        assertTrue(response);

    }

    @Test
    void compareWordsTestifFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = wordGraph.getClass().getDeclaredMethod("compareWords", String.class, String.class);
        method.setAccessible(true);

        boolean response = (boolean) method.invoke(wordGraph, "dog", "did");

        assertFalse(response);
    }

}