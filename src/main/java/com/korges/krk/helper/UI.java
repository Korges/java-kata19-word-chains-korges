package com.korges.krk.helper;

import java.util.Scanner;

public class UI {

    Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    public String chooseOption() {
        System.out.println("Type name of option:\nCHECK\nEXIT");
        return scanner.nextLine().toUpperCase();
    }

    public String[] typeWords() {
        String[] words = new String[2];
        do {
            System.out.println("Type source word:");
            words[0] = scanner.nextLine().toLowerCase();
            System.out.println("Type destination word");
            words[1] = scanner.nextLine().toLowerCase();
        } while (words[0].length() != words[1].length());

        return words;
    }
}
