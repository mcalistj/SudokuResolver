package com.company.sudokuresolver;

import java.util.Scanner;

public class Main {
    SudokuGrid sudokuGrid = new SudokuGrid();

    public static void main(final String[] args) {

        System.out.println("Initialise the  grid.\nInput numbers to that reflect the initial state of the Sudoku game" +
                "\nInput the numbers in the following format \"2a, 5\" ENTER." +
                "\nEnter \"EXIT\" once all the initial entries are input.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("EXIT")) {
            System.out.println(input);
            // Validate entry
            // if Valid entry
            //    populateSquare
            // else
            // Prompt user of incorrect input
            input = scanner.nextLine();

        }
        // Next Stage
        // Ask for hint,
        // Fill Grid
        // Or exit
        //Print Grid
        System.out.println("Exiting Program.\nThank you for playing");
    }

    private void populateSquare(final char row, final int column, final int number) {
        //Convert char to int
        //sudokuGrid.putNumber(row, column, number);
    }

    /*private void printGrid() {
        // print sudokuGrid
    }*/
}
