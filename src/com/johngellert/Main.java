package com.johngellert;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        List<String> wordPuzzleList = new LinkedList<String>();


        char[][] wordPuzzle = new char[10][10];
//        char[][] wordPuzzle = {
//                {'a', 'b', 'c', 'd', 'e'},
//                {'a', 'b', 'c', 'd', 'e'},
//                {'a', 'b', 'c', 'd', 'e'},
//                {'a', 'b', 'c', 'd', 'e'},
//                {'a', 'b', 'c', 'd', 'e'}};

        Random random = new Random();
        int startRange = 97; // ASCII decimal representation of character 'a'
        int endRange = 122; //  ASCII decimal representation of character 'z'

        // 97 through 122 decimal representations of a through z
        // Creates a gird of random characters
        for (int i = 0; i < wordPuzzle.length; i++) {
            for (int j = 0; j < wordPuzzle[i].length; j++) {
                wordPuzzle[i][j] = (char) (random.nextInt(endRange - startRange + 1) + startRange);
            }
        }


// processing the 2D array in one column at a time and printing out the character
        for (int j = 0; j < wordPuzzle.length; j++) {
            for (int i = 0; i < wordPuzzle[j].length; i++) {
                System.out.print(wordPuzzle[j][i] + "  ");
            }
            System.out.println(); // next line after each column
        }

    }

//    File to read
    File inputFile = new File ("/Users/johngellert/Desktop/pass/word-find.txt");
}
