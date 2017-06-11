package com.company.sudokuresolver.operations;

import com.company.sudokuresolver.IndividualEntry;

import java.util.ArrayList;

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

    public static void populateIfNumberCanOnlyGoInOnePosition(final IndividualEntry[][] grid) {
        //for a given row
        //Get possible numbers
        //When going through iteration eliminate 'possible' number on second appearance
        //Loop again and see if remaining possible number can slot into each available slot.
        ArrayList<Integer> possibleNumbers = new ArrayList<Integer>();

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (!grid[i][j].isFilled()) {
                    OperationsHelper.exclusiveOrPossibleNumbers(grid[i][j], possibleNumbers);
                }
            }
            if (possibleNumbers.size() == 1) {
                for (int j = 0; j < DIMENSION; j++) {
                    if (grid[i][j].getPossibleNumbers()[possibleNumbers.get(0)]) {
                        grid[i][j].setNumber(possibleNumbers.get(0));
                    }
                }
            }
        }
    }

}
