package com.korges.krk.program.body;

import com.korges.krk.graph.Word;
import com.korges.krk.graph.WordGraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class FileReader {

    private static final String PATH_TO_WORD_LIST = "src/main/resources/wordlist.csv";
    private WordGraph wordGraph;

    FileReader() {
        this.wordGraph = new WordGraph();
    }

    public WordGraph readFile(int wordLength) {

        String absolutePath = new File(PATH_TO_WORD_LIST).getAbsolutePath();
        String line;

        try (Scanner scanner = new Scanner(new File(absolutePath))) {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.length() == wordLength) {
                    wordGraph.addWord(new Word(line.toLowerCase()));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return wordGraph;
    }
}
