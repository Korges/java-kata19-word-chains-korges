package com.korges.krk.program.body;

import com.korges.krk.exception.ConnectionNotFoundException;
import com.korges.krk.exception.WordNotInWordListException;
import com.korges.krk.graph.Word;
import com.korges.krk.graph.WordGraph;


import java.util.LinkedList;

public class ChainFinder {

    private FileReader reader;
    private WordGraph wordGraph;

    public ChainFinder(Integer wordLength) {
        reader = new FileReader();
        wordGraph = reader.readFile(wordLength);
    }

    public Word[] buildConnectionsAndGetEndPoints(String fromWord, String finalWord) throws WordNotInWordListException {

        Word source = wordGraph.getWordByValue(fromWord);
        Word destination = wordGraph.getWordByValue(finalWord);

        wordGraph.buildConnections();

        return new Word[]{source, destination};
    }

    public void findShortestPath(Word[] endPoints) throws ConnectionNotFoundException {

        LinkedList<Word> shortestPath = wordGraph.breadthFirstSearch(endPoints[0], endPoints[1]);

        System.out.println(shortestPath);
    }

    public WordGraph getWordGraph() {
        return wordGraph;
    }
}
