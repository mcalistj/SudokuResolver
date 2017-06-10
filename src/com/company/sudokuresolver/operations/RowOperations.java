package com.company.sudokuresolver.operations;

import com.company.sudokuresolver.IndividualEntry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
                    for (int number = 0; number < DIMENSION; number++) {
                        if (grid[i][j].getPossibleNumbers()[number]) {
                            if (possibleNumbers.contains(number)) {
                                possibleNumbers.remove(Integer.valueOf(number));
                            } else {
                                possibleNumbers.add(number);
                            }
                        }
                    }
                }
            }
            int onlyPossibleNumber;
            if (possibleNumbers.size() == 1) {
                onlyPossibleNumber = possibleNumbers.get(0);
                for (int j = 0; j < DIMENSION; j++) {
                    if(grid[i][j].getPossibleNumbers()[onlyPossibleNumber]){
                        grid[i][j].setNumber(onlyPossibleNumber);
                    }
                }

            }
        }


    }
}
