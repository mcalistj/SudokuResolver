package com.company.sudokuresolver;

import java.util.Scanner;

public class Main {
    SudokuGrid sudokuGrid = new SudokuGrid();

    public static void main(final String[] args) {

        System.out.println("Initialise grid");
        Scanner input = new Scanner(System.in);

        while (input.next() != "n") {

        }
    }

    private void initiliseGrid (final int column, final int row, final int number){
        //sudokuGrid.grid[column][row] = number;
    }
}
