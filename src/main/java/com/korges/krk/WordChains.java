package com.korges.krk;

import com.korges.krk.exception.ConnectionNotFoundException;
import com.korges.krk.exception.WordNotInWordListException;
import com.korges.krk.graph.Word;
import com.korges.krk.helper.UI;
import com.korges.krk.helper.UserOption;
import com.korges.krk.program.body.ChainFinder;


/**
 * 16.06.2018
 * Korga Mateusz
 */
public class WordChains {

    static UI ui;

    public static void main( String[] args ) {

        String userInput;
        ui = new UI();
        UserOption userOption = UserOption.START;

        do {
            userInput = ui.chooseOption();
            try {
                userOption = userOption.recognizeUserOption(userInput);
                if (userOption.equals(UserOption.CHECK)) {
                    checkOption();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("There is no such option!");
            } catch (WordNotInWordListException | ConnectionNotFoundException e) {

            }

        } while (!userOption.equals(UserOption.EXIT));
    }

    private static void checkOption() throws WordNotInWordListException, ConnectionNotFoundException {

        String[] words = ui.typeWords();

        ChainFinder chainFinder = new ChainFinder(words[0].length());

        Word[] endPoints = chainFinder.buildConnectionsAndGetEndPoints(words[0], words[1]);
        chainFinder.findShortestPath(endPoints);
    }
}
