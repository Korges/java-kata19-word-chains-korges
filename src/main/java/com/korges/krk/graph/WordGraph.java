package com.korges.krk.graph;

import com.korges.krk.exception.ConnectionNotFoundException;
import com.korges.krk.exception.WordNotInWordListException;
import java.util.*;


public class WordGraph {

    private ArrayList<Word> wordList;

    public WordGraph() {

        wordList = new ArrayList<>();
    }

    public void addWord(Word word) {
        this.wordList.add(word);
    }

    public Word getWordByValue(String value) throws WordNotInWordListException {
        for (Word word : wordList) {
            if (word.getWordValue().equals(value)) {
                return word;
            }
        }
        throw new WordNotInWordListException(value);
    }

    public LinkedList<Word> breadthFirstSearch(Word source, Word destination) throws ConnectionNotFoundException {

        double startTime = System.currentTimeMillis();

        HashMap<Word, Word> previous = new HashMap<>();
        LinkedList<Word> nextToVisit = new LinkedList<>();

        nextToVisit.add(source);

        while(!nextToVisit.isEmpty()) {

            Word word = nextToVisit.remove();

            if (word == destination) {
                countSearchTime(startTime);
                return backtrace(previous, source, destination);
            }

            for(Word child : word.getCloseWords()) {
                if (!previous.containsKey(child)) {
                    previous.put(child, word);
                    nextToVisit.add(child);
                }
            }
        }
        throw new ConnectionNotFoundException();
    }

    private LinkedList<Word> backtrace(HashMap<Word, Word> map, Word source, Word destination) {

        LinkedList<Word> list = new LinkedList<>();

        list.add(destination);
        while(!list.getFirst().equals(source)) {
            list.addFirst(map.get(list.getFirst()));
        }
        return list;
    }

    public void buildConnections() {

        for (Word parent : wordList) {
            for (Word children : wordList) {
                if (compareWords(parent.getWordValue(), children.getWordValue())) {
                    if (!parent.getCloseWords().contains(children)) {
                        parent.addCloseWord(children);
                    }
                }
            }
        }
    }

    private boolean compareWords(String firstWord, String secondWord) {

        int amountOfDiffrentLetters = 0;
        int wordLength = firstWord.length();
        for (int i = 0; i < wordLength; i++) {
            if (firstWord.charAt(i) != secondWord.charAt(i)) {
                amountOfDiffrentLetters++;
            }
            if(amountOfDiffrentLetters > 1)
                return false;
        }
        return true;
    }

    private void countSearchTime(double startTime) {
        System.out.println("Search took : " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
