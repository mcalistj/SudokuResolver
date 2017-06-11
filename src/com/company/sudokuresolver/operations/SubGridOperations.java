package com.company.sudokuresolver.operations;

import com.company.sudokuresolver.IndividualEntry;
import com.company.sudokuresolver.SubGrid;

import java.util.ArrayList;

import static com.company.sudokuresolver.Utility.SUB_GRID_DIMENSION;

public class SubGridOperations {

    public static void eliminatePossibilitiesInSubGrid(final IndividualEntry[][] grid, final int rowIndexOfNumber,
                                                       final int columnIndexOfNumber, final int number) {
        SubGrid subGrid = new SubGrid(rowIndexOfNumber, columnIndexOfNumber);

        for (int rowIndex = subGrid.getFirstRowIndex(); rowIndex < subGrid.getFirstRowIndex() + SUB_GRID_DIMENSION; rowIndex++) {
            for (int columnIndex = subGrid.getFirstColumnIndex(); columnIndex < subGrid.getFirstColumnIndex() + SUB_GRID_DIMENSION; columnIndex++) {
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

    public static void populateIfNumberCanOnlyGoInOnePosition(final IndividualEntry[][] grid, final SubGrid subGrid) {
        ArrayList<Integer> possibleNumbers = new ArrayList<Integer>();
        ArrayList<Integer> possibleNumbersAlreadyAppeared = new ArrayList<Integer>();


        for (int rowIndex = subGrid.getFirstRowIndex(); rowIndex < subGrid.getFirstRowIndex() + SUB_GRID_DIMENSION; rowIndex++) {
            for (int columnIndex = subGrid.getFirstColumnIndex(); columnIndex < subGrid.getFirstColumnIndex() + SUB_GRID_DIMENSION; columnIndex++) {
                if (!grid[rowIndex][columnIndex].isFilled()) {
                    OperationsHelper.exclusiveOrPossibleNumbers(grid[rowIndex][columnIndex], possibleNumbers);
                }
            }
        }
        if (possibleNumbers.size() == 1) {
            for (int rowIndex = subGrid.getFirstRowIndex(); rowIndex < subGrid.getFirstRowIndex() + SUB_GRID_DIMENSION; rowIndex++) {
                for (int columnIndex = subGrid.getFirstColumnIndex(); columnIndex < subGrid.getFirstColumnIndex() + SUB_GRID_DIMENSION; columnIndex++) {
                    if (grid[rowIndex][columnIndex].getPossibleNumbers()[possibleNumbers.get(0)]) {
                        grid[rowIndex][columnIndex].setNumber(possibleNumbers.get(0));
                    }
                }
            }
        }
    }
}
