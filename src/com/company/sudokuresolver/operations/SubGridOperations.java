package com.company.sudokuresolver.operations;

import com.company.sudokuresolver.IndividualEntry;

import static com.company.sudokuresolver.Utility.SUB_GRID_DIMENSION;

public class SubGridOperations {

    public static void eliminatePossibilitiesInSubGrid(final IndividualEntry[][] grid, final int rowIndexOfNumber,
                                                       final int columnIndexOfNumber, final int number) {
        int firstRowIndex = getFirstRowIndex(rowIndexOfNumber);
        int firstColumnIndex = getFirstColumnIndex(rowIndexOfNumber);

        for (int rowIndex = firstRowIndex; rowIndex < firstRowIndex + SUB_GRID_DIMENSION; rowIndex++) {
            for (int columnIndex = firstColumnIndex; columnIndex < firstColumnIndex + SUB_GRID_DIMENSION; columnIndex++) {
                if (!(rowIndex == rowIndexOfNumber && columnIndex == columnIndexOfNumber)) {
                    grid[rowIndex][columnIndex].eliminatePossibility(number);
                }
            }
        }
    }

    private static int getFirstRowIndex(final int rowIndex) {
        return ((rowIndex) / SUB_GRID_DIMENSION) * SUB_GRID_DIMENSION;
    }

    private static int getFirstColumnIndex(final int columnIndex) {
        return ((columnIndex) / SUB_GRID_DIMENSION) * SUB_GRID_DIMENSION;
    }

}
