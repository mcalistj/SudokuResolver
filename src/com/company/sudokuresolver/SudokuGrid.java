package com.company.sudokuresolver;

import com.company.sudokuresolver.operations.ColumnOperations;
import com.company.sudokuresolver.operations.RowOperations;
import com.company.sudokuresolver.operations.SubGridOperations;
import lombok.Data;

import static com.company.sudokuresolver.Utility.DIMENSION;

@Data
public class SudokuGrid {

    private IndividualEntry[][] grid;
    private boolean gridPopulated;

    public SudokuGrid() {
        grid = new IndividualEntry[9][9];
        gridPopulated = false;

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                grid[i][j] = new IndividualEntry();
            }
        }
    }

    public void populateWholeGrid() {
        int iteration = 0;

        /*while (!gridPopulated) {
            if (iteration > 10 * 10) {
                throw new RuntimeException("Game cannot be completed");
            }
            populateRow();
            iteration++;
        }*/

        for (int i = 0; i < 100; i++) {
            populateRow();
        }
    }

    public void putNumber(final int rowIndex, final int columnIndex, final int number) {
        grid[rowIndex][columnIndex].populateWithNumber(number);

        RowOperations.eliminateDueToNumberInRow(grid, rowIndex, columnIndex, number);

        ColumnOperations.eliminatePossibilitiesInColumn(grid, rowIndex, columnIndex, number);

        SubGridOperations.eliminatePossibilitiesInSubGrid(grid, rowIndex, columnIndex, number);
    }

    public void populateEntry() {
        //populateRow()
        //populateColumnEntry()
        //populateSubGridEntry()
    }

    public void populateRow() {
        for (int i = 0; i < DIMENSION; i++) {
            populateEntryByRowIndex(i);
        }
    }

    private void populateEntryByRowIndex(final int rowIndex) {
        for (int columnIndex = 0; columnIndex < DIMENSION; columnIndex++) {
            grid[rowIndex][columnIndex].fillWithOnlyPossiblity();
        }
    }
}
