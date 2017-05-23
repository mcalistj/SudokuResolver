package com.company.sudokuresolver;

import lombok.Data;

@Data
public class SudokuGrid {

    private IndividualEntry[][] grid;

    public SudokuGrid() {
        grid = new IndividualEntry[10][10];
    }

    private void eliminateDueToNumberInRow() {

    }

    public void putNumber(final int row, final int column, final int number) {
        grid[row][column].populateWithNumber(number);

        //eliminatePossibilitiesInRow

        //eliminatePossibilitiesInColumn

        //elimniatePossibilitiesInSubSquare
    }

    //@VisibleForTesting
    public IndividualEntry[] setRow(final int index) {
        IndividualEntry[] row = new IndividualEntry[10];

        for (int i = 0; i < Utility.DIMENSION; i++) {
            row[i] = grid[i][index];
        }

        return row;
    }

    //@VisibleForTesting
    public IndividualEntry[] getRow(final int index) {
        IndividualEntry[] row = new IndividualEntry[10];

        for (int i = 0; i < Utility.DIMENSION; i++) {
            row[i] = grid[i][index];
        }

        return row;
    }

}
