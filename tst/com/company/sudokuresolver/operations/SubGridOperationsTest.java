package com.company.sudokuresolver.operations;

import com.company.sudokuresolver.SubGrid;
import com.company.sudokuresolver.SudokuGrid;
import org.junit.Test;

import static com.company.sudokuresolver.Utility.DIMENSION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SubGridOperationsTest {

    @Test
    public void testPopulateGivenSevenCanOnlyGoInOnePlace() {
        SudokuGrid sudokuGrid = new SudokuGrid();
        SubGrid subGrid = new SubGrid(0, 6);

        sudokuGrid.putNumber(0, 1, 7);

        sudokuGrid.putNumber(0, 7, 8);
        sudokuGrid.putNumber(1, 6, 2);
        sudokuGrid.putNumber(1, 8, 9);
        sudokuGrid.putNumber(2, 6, 5);
        sudokuGrid.putNumber(2, 7, 4);

        sudokuGrid.putNumber(6, 7, 7);

        SubGridOperations.populateIfNumberCanOnlyGoInOnePosition(sudokuGrid.getGrid(), subGrid);

        assertEquals(Integer.valueOf(7), sudokuGrid.getGrid()[2][8].getNumber());
    }

    @Test
    public void testPopulateGivenEightCanOnlyGoInOnePlace() {
        SudokuGrid sudokuGrid = new SudokuGrid();
        SubGrid subGrid = new SubGrid(6, 0);

        sudokuGrid.putNumber(6, 0, 4);
        sudokuGrid.putNumber(7, 0, 5);
        sudokuGrid.putNumber(8, 0, 1);
        sudokuGrid.putNumber(8, 1, 6);
        sudokuGrid.putNumber(8, 2, 7);

        sudokuGrid.putNumber(7, 8, 8);
        sudokuGrid.putNumber(5, 2, 8);

        SubGridOperations.populateIfNumberCanOnlyGoInOnePosition(sudokuGrid.getGrid(), subGrid);

        assertEquals(Integer.valueOf(8), sudokuGrid.getGrid()[6][1].getNumber());
    }

    @Test
    public void testEntryNotPopulated() {
        SudokuGrid sudokuGrid = new SudokuGrid();
        final SubGrid subGrid = new SubGrid(6, 0);

        sudokuGrid.putNumber(6, 0, 4);
        sudokuGrid.putNumber(7, 0, 5);
        sudokuGrid.putNumber(8, 0, 1);
        sudokuGrid.putNumber(8, 1, 6);
        sudokuGrid.putNumber(8, 2, 7);

        sudokuGrid.putNumber(7, 8, 8);
        sudokuGrid.putNumber(5, 2, 8);

        SubGridOperations.populateIfNumberCanOnlyGoInOnePosition(sudokuGrid.getGrid(), subGrid);

        assertNull(sudokuGrid.getGrid()[7][1].getNumber());
    }
}
