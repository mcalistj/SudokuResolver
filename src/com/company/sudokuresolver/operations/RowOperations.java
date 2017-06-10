package com.company.sudokuresolver.operations;

import com.company.sudokuresolver.IndividualEntry;

import static com.company.sudokuresolver.Utility.DIMENSION;

public class RowOperations {

    public static void eliminateDueToNumberInRow(final IndividualEntry[][] grid, final int rowIndex, final int
            columnIndex, final int number) {
        for (int i = 0; i < DIMENSION; i++) {
            if (i != columnIndex) {
                grid[rowIndex][i].eliminatePossibility(number);
            }
        }
    }
}
