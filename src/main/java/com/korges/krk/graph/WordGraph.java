package com.korges.krk.graph;

import com.korges.krk.exception.ConnectionNotFoundException;
import com.korges.krk.exception.WordNotInWordListException;
import java.util.*;


public class WordGraph {

    private List<Word> wordList;

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

    public List<Word> breadthFirstSearch(Word source, Word destination) throws ConnectionNotFoundException {

        double startTime = System.currentTimeMillis();

        Map<Word, Word> previous = new HashMap<>();
        List<Word> nextToVisit = new LinkedList<>();

        nextToVisit.add(source);

        while(!nextToVisit.isEmpty()) {

            Word word = nextToVisit.remove(0);

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

    private List<Word> backtrace(Map<Word, Word> map, Word source, Word destination) {

        List<Word> list = new LinkedList<>();

        list.add(destination);
        while(!list.get(0).equals(source)) {
            list.add(0, map.get(list.get(0)));
        }
        return list;
    }

    public void buildConnections() {

        for (Word parent : wordList) {
            for (Word children : wordList) {
                if (compareWords(parent.getWordValue(), children.getWordValue())) {
                    if (!parent.getCloseWords().contains(children) && !parent.getWordValue().equals(children.getWordValue())) {
                        parent.addCloseWord(children);
                    }
                }
            }
        }
    }

    private boolean compareWords(String firstWord, String secondWord) {

        int amountOfDifferentLetters = 0;
        int wordLength = firstWord.length();
        for (int i = 0; i < wordLength; i++) {
            if (firstWord.charAt(i) != secondWord.charAt(i)) {
                amountOfDifferentLetters++;
            }
            if(amountOfDifferentLetters > 1)
                return false;
        }
        return true;
    }

    private void countSearchTime(double startTime) {
        System.out.println("Search took : " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
