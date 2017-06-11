package com.company.sudokuresolver.operations;

import com.company.sudokuresolver.SudokuGrid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ColumnOperationsTest {

    @Test
    public void testPopulateGivenTwoCanOnlyGoInOnePlace() {
        SudokuGrid sudokuGrid = new SudokuGrid();

        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(2, 0, 3);
        sudokuGrid.putNumber(3, 0, 4);
        sudokuGrid.putNumber(5, 0, 6);
        sudokuGrid.putNumber(6, 0, 7);

        sudokuGrid.putNumber(1, 1, 2);
        sudokuGrid.putNumber(4, 4, 2);
        sudokuGrid.putNumber(7, 8, 2);

        ColumnOperations.populateIfNumberCanOnlyGoInOnePosition(sudokuGrid.getGrid());

        assertEquals(Integer.valueOf(2), sudokuGrid.getGrid()[8][0].getNumber());
    }

    @Test
    public void testPopulateGivenSixCanOnlyGoInOnePlace() {
        SudokuGrid sudokuGrid = new SudokuGrid();

        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(2, 0, 3);
        sudokuGrid.putNumber(3, 0, 4);

        sudokuGrid.putNumber(1, 1, 6);
        sudokuGrid.putNumber(4, 2, 6);
        sudokuGrid.putNumber(5, 3, 6);
        sudokuGrid.putNumber(6, 4, 6);
        sudokuGrid.putNumber(7, 8, 6);

        ColumnOperations.populateIfNumberCanOnlyGoInOnePosition(sudokuGrid.getGrid());

        assertEquals(Integer.valueOf(6), sudokuGrid.getGrid()[8][0].getNumber());
    }

    @Test
    public void testEntryNotPopulated() {
        SudokuGrid sudokuGrid = new SudokuGrid();

        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(2, 0, 3);
        sudokuGrid.putNumber(3, 0, 4);

        sudokuGrid.putNumber(1, 1, 6);
        sudokuGrid.putNumber(4, 2, 6);
        sudokuGrid.putNumber(5, 3, 6);
        sudokuGrid.putNumber(6, 4, 6);

        ColumnOperations.populateIfNumberCanOnlyGoInOnePosition(sudokuGrid.getGrid());

        assertNull(sudokuGrid.getGrid()[1][0].getNumber());
        assertNull(sudokuGrid.getGrid()[4][0].getNumber());
        assertNull(sudokuGrid.getGrid()[5][0].getNumber());
        assertNull(sudokuGrid.getGrid()[6][0].getNumber());
    }
}
