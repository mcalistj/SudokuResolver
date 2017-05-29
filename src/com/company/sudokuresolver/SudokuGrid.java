package com.company.sudokuresolver;

import lombok.Data;

@Data
public class SudokuGrid {

    private IndividualEntry[][] grid;

    public SudokuGrid() {
        grid = new IndividualEntry[10][10];

        for (int i = 0; i < Utility.DIMENSION; i++) {
            for (int j = 0; j < Utility.DIMENSION; j++) {
                grid[i][j] = new IndividualEntry();
            }
        }
    }

    public void putNumber(final int rowIndex, final int columnIndex, final int number) {
        grid[rowIndex][columnIndex].populateWithNumber(number);

        eliminateDueToNumberInRow(rowIndex, columnIndex, number);

        eliminatePossibilitiesInColumn(rowIndex, columnIndex, number);

        //eliminatePossibilitiesInSubSquare
    }

    public void populateEntry() {
        //populateRowEntry()
        //populateColumnEntry()
        //populateSubGridEntry()
    }

    public void populateRowEntry() {
        for (int i = 0; i < Utility.DIMENSION; i++) {
            populateEntryByRowIndex(i);
        }
    }

    public void populateEntryByRowIndex(final int rowIndex) {
        for (int columnIndex = 0; columnIndex < Utility.DIMENSION; columnIndex++) {
            grid[rowIndex][columnIndex].autonomouslyPopulateEntry();
        }
    }

    private void eliminateDueToNumberInRow(final int rowIndex, final int columnIndex, final int number) {
        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (i != columnIndex) {
                grid[rowIndex][i].eliminatePossibility(number);
            }
        }
    }

    private void eliminatePossibilitiesInColumn(final int rowIndex, final int columnIndex, final int number) {
        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (i != rowIndex) {
                grid[i][columnIndex].eliminatePossibility(number);
            }
        }
    }

    private void elimniatePossibilitiesInSubSquare() {
        //determineGridIndex

    }

    /*private int[][] determineGridIndex(){
        //
    }*/

}
