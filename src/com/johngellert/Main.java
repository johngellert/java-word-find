package com.johngellert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        List<String> wordPuzzleList = new LinkedList<String>();


        char[][] wordPuzzle = new char[11][15];
//        char[][] wordPuzzle = {
//                {'a', 'b', 'c', 'd', 'e', 'f', 'g'},
//                {'a', 'b', 'c', 'd', 'e', 'f', 'g'},
//                {'a', 'b', 'c', 'd', 'e', 'f', 'g'},
//                {'a', 'b', 'c', 'd', 'e', 'f', 'g'}};

        Random random = new Random();
        int startRange = 97; // ASCII decimal representation of character 'a'
        int endRange = 122; //  ASCII decimal representation of character 'z'

        // 97 through 122 decimal representations of a through z
        // Creates a gird of random characters
        int counter = 0;
        for (int i = 0; i < wordPuzzle.length; i++) {
            for (int j = 0; j < wordPuzzle[i].length; j++) {
                wordPuzzle[i][j] = (char) (random.nextInt(endRange - startRange + 1) + startRange);
            }
        }


// processing the 2D array in one column at a time and printing out the character
//        System.out.println(wordPuzzle.length);
//        for (int j = 0; j < wordPuzzle.length; j++) {
//            for (int i = 0; i < wordPuzzle[0].length; i++) {
//                System.out.print(wordPuzzle[j][i] + "  ");
//            }
//            System.out.println(); // next line after each column
//        }

        System.out.println(wordPuzzle.length);
        for (int i = 0; i < wordPuzzle.length; i++) {
            for (int j = 0; j < wordPuzzle[i].length; j++) {
                System.out.print(wordPuzzle[i][j] + "  ");
            }
            System.out.println(); // next line after each column
        }

//    File to read
        System.out.println(new File(".").getAbsolutePath());
        File inputFile = new File("/Users/johngellert/Documents/word-find.txt");

        Scanner scan;

        {
            try {
                scan = new Scanner(inputFile);
                System.out.println("in scanner");

                while (scan.hasNext()) {

                    for (int i = 0; i < wordPuzzle.length; i++) {
                        for (int j = 0; j < wordPuzzle[i].length; j++) {
                            wordPuzzle[i][j] = scan.next().charAt(0);
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println(wordPuzzle.length); // length of columns
        System.out.println(wordPuzzle[0].length); // length of rows


        for (int i = 0; i < wordPuzzle.length; i++) {
            for (int j = 0; j < wordPuzzle[i].length; j++) {
                System.out.print(wordPuzzle[i][j] + "  ");
            }
            System.out.println(); // next line after each column
        }

        System.out.println();
        String word = "";

        for (int i = 0; i < wordPuzzle.length; i++) {
            int wordLengthIncrementer = 4;
            int loopFlag = 0;

            for (int j = 0; j < wordPuzzle[i].length; j++) {
//                System.out.print(wordPuzzle[i][j] + "  ");

                int rowIndex = 0;
                // prevents index out of bounds for column length on row 105
                if(j < wordPuzzle.length) {
                    rowIndex = j;
                }

                // while wordStarting index is less than the length of the column minus the starting index keep looping
                while (loopFlag < wordPuzzle[0].length) {
                    // grab each character for the current length of word and concatenate to word
                    for (int k = 0; k < wordLengthIncrementer; k++) {
                        word = word + (String.valueOf(wordPuzzle[rowIndex][k]));
//                        System.out.println("in k loop" + "the String value: " + String.valueOf(wordPuzzle[j][k]));

                    }
                    System.out.println("the word is: " + word);
                    loopFlag = word.length();
//                    System.out.println("loop flag = " + loopFlag);
                    word = "";
                    wordLengthIncrementer++;


                }
                System.out.println("index j =" + j);
                loopFlag = 0;
                wordLengthIncrementer = 4;
            }
            System.out.println("index i = " + i); // next line after each column
        }


    }
}



