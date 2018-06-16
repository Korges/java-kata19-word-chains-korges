package com.korges.krk.exception;

public class WordNotInWordListException extends Exception {

    public WordNotInWordListException(String word) {
        System.out.println("Word '" + word + "' not in dictionary");
    }
}
