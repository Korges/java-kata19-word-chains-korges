package com.korges.krk;

import com.korges.krk.exception.ConnectionNotFoundException;
import com.korges.krk.exception.WordNotInWordListException;
import com.korges.krk.graph.Word;
import com.korges.krk.graph.WordGraph;
import com.korges.krk.program.body.ChainFinder;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class SampleRunTest {

    private static WordGraph wordGraph;
    private static ChainFinder chainFinder;
    private static String[] sampleInputs;

    @Test
    void findShortestPathTestIfConnectionExist() throws WordNotInWordListException, ConnectionNotFoundException {

        sampleInputs = new String[]{"dog", "cat"};
        chainFinder = new ChainFinder(sampleInputs[0].length());
        chainFinder.buildConnectionsAndGetEndPoints(sampleInputs[0], sampleInputs[1]);
        wordGraph = chainFinder.getWordGraph();

        Word sourceTest = wordGraph.getWordByValue("dog");
        Word destinationTest = wordGraph.getWordByValue("cat");

        List<Word> testList = wordGraph.breadthFirstSearch(sourceTest, destinationTest);

        LinkedList<Word> expectedList = new LinkedList<>();

        expectedList.add(wordGraph.getWordByValue("dog"));
        expectedList.add(wordGraph.getWordByValue("dot"));
        expectedList.add(wordGraph.getWordByValue("dat"));
        expectedList.add(wordGraph.getWordByValue("cat"));

        assertEquals(expectedList.toString(), testList.toString());
    }

    @Test
    void findShortestPathTestIfConnectionNotExist() throws WordNotInWordListException {
        sampleInputs = new String[]{"benson", "benoni"};
        chainFinder = new ChainFinder(sampleInputs[0].length());
        wordGraph = chainFinder.getWordGraph();

        Word sourceTest = wordGraph.getWordByValue("benson");
        Word destinationTest = wordGraph.getWordByValue("benoni");

        assertThrows(ConnectionNotFoundException.class, () -> wordGraph.breadthFirstSearch(sourceTest, destinationTest));

    }
}
