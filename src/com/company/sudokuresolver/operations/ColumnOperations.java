package com.company.sudokuresolver.operations;

import com.company.sudokuresolver.IndividualEntry;

import static com.company.sudokuresolver.Utility.DIMENSION;

public class ColumnOperations {

    public static void eliminatePossibilitiesInColumn(final IndividualEntry[][] grid, final int rowIndex, final int
            columnIndex, final int number) {
        for (int i = 0; i < DIMENSION; i++) {
            if (i != rowIndex) {
                grid[i][columnIndex].eliminatePossibility(number);
            }
        }
    }
}
