package com.company.sudokuresolver.operations;

import com.company.sudokuresolver.IndividualEntry;

import java.util.ArrayList;

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

    public static void populateIfNumberCanOnlyGoInOnePosition(final IndividualEntry[][] grid) {
        ArrayList<Integer> possibleNumbers = new ArrayList<Integer>();

        for (int columnIndex = 0; columnIndex < DIMENSION; columnIndex++) {
            for (int rowIndex = 0; rowIndex < DIMENSION; rowIndex++) {
                if (!grid[rowIndex][columnIndex].isFilled()) {
                    OperationsHelper.exclusiveOrPossibleNumbers(grid[rowIndex][columnIndex], possibleNumbers);
                }
            }
            if (possibleNumbers.size() == 1) {
                for (int rowIndex = 0; rowIndex < DIMENSION; rowIndex++) {
                    if (grid[rowIndex][columnIndex].getPossibleNumbers()[possibleNumbers.get(0)]) {
                        grid[rowIndex][columnIndex].setNumber(possibleNumbers.get(0));
                    }
                }
            }
        }
    }
}
