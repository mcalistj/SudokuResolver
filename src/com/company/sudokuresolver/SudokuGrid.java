package com.company.sudokuresolver;

import lombok.Data;

@Data
public class SudokuGrid {

    private IndividualEntry[][] grid;

    public SudokuGrid() {
        grid = new IndividualEntry[10][10];
    }

    public void putNumber(final int rowIndex, final int columnIndex, final int number) {
        grid[rowIndex][columnIndex].populateWithNumber(number);

        eliminateDueToNumberInRow(rowIndex, columnIndex, number);

        //eliminatePossibilitiesInColumn

        //elimniatePossibilitiesInSubSquare
    }

    private void eliminateDueToNumberInRow(final int rowIndex, final int columneNumber, final int number) {
        IndividualEntry[] row = grid[rowIndex];

        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (i != columneNumber) {
                row[i].eliminatePossibility(number);
            }
        }

    }

    private void eliminatePossibilitiesInColumn() {

    }

    private void elimniatePossibilitiesInSubSquare() {

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
