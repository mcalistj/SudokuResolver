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
