package com.company.sudokuresolver.operations;

import com.company.sudokuresolver.SudokuGrid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RowOperationsTest {

    @Test
    public void testPopulateGivenTwoCanOnlyGoInOnePlace() {
        SudokuGrid sudokuGrid = new SudokuGrid();

        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(0, 2, 3);
        sudokuGrid.putNumber(0, 3, 4);
        sudokuGrid.putNumber(0, 5, 6);
        sudokuGrid.putNumber(0, 6, 7);

        sudokuGrid.putNumber(1, 1, 2);
        sudokuGrid.putNumber(4, 4, 2);
        sudokuGrid.putNumber(8, 7, 2);

        RowOperations.populateIfNumberCanOnlyGoInOnePosition(sudokuGrid.getGrid());

        assertEquals(Integer.valueOf(2), sudokuGrid.getGrid()[0][8].getNumber());
    }

    @Test
    public void testPopulateGivenSixCanOnlyGoInOnePlace() {
        SudokuGrid sudokuGrid = new SudokuGrid();

        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(0, 2, 3);
        sudokuGrid.putNumber(0, 3, 4);

        sudokuGrid.putNumber(1, 1, 6);
        sudokuGrid.putNumber(2, 4, 6);
        sudokuGrid.putNumber(3, 5, 6);
        sudokuGrid.putNumber(4, 6, 6);
        sudokuGrid.putNumber(8, 7, 6);

        RowOperations.populateIfNumberCanOnlyGoInOnePosition(sudokuGrid.getGrid());

        assertEquals(Integer.valueOf(6), sudokuGrid.getGrid()[0][8].getNumber());
    }

    @Test
    public void testEntryNotPopulated() {
        SudokuGrid sudokuGrid = new SudokuGrid();

        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(0, 2, 3);
        sudokuGrid.putNumber(0, 3, 4);

        sudokuGrid.putNumber(1, 1, 6);
        sudokuGrid.putNumber(2, 4, 6);
        sudokuGrid.putNumber(3, 5, 6);
        sudokuGrid.putNumber(4, 6, 6);

        RowOperations.populateIfNumberCanOnlyGoInOnePosition(sudokuGrid.getGrid());

        assertNull(sudokuGrid.getGrid()[0][1].getNumber());
        assertNull(sudokuGrid.getGrid()[0][4].getNumber());
        assertNull(sudokuGrid.getGrid()[0][5].getNumber());
        assertNull(sudokuGrid.getGrid()[0][6].getNumber());
    }
}
