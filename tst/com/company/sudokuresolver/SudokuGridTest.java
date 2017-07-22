package com.company.sudokuresolver;

import org.junit.Before;
import org.junit.Test;

import static com.company.sudokuresolver.Utility.SUB_GRID_DIMENSION;
import static com.company.sudokuresolver.Utility.printGrid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class SudokuGridTest {

    private SudokuGrid sudokuGrid;

    @Before
    public void setUp() {
        sudokuGrid = new SudokuGrid();
    }

    @Test
    public void testPutNumberInRow() {
        int rowIndex = 1;
        int columnIndex = 1;
        int number = 5;

        sudokuGrid.putNumber(rowIndex, columnIndex, number);

        assertPositionsInRowCannotHaveNumber(rowIndex, columnIndex, number);
    }

    @Test
    public void testPutTwoNumbersInRow() {
        int rowIndex = 1;
        int firstColumnIndex = 1;
        int firstNumber = 5;
        int secondColumnIndex = 5;
        int secondNumber = 3;

        sudokuGrid.putNumber(rowIndex, firstColumnIndex, firstNumber);
        sudokuGrid.putNumber(rowIndex, secondColumnIndex, secondNumber);

        assertPositionsInRowCannotHaveNumber(rowIndex, firstColumnIndex, firstNumber);
        assertPositionsInRowCannotHaveNumber(rowIndex, secondColumnIndex, secondNumber);
    }

    @Test
    public void testPutNumberInColumn() {
        int rowIndex = 1;
        int columnIndex = 1;
        int number = 6;

        sudokuGrid.putNumber(rowIndex, columnIndex, number);

        assertPositionsInColumnCannotHaveNumber(rowIndex, columnIndex, number);
    }

    @Test
    public void testPutTwoNumbersInColumn() {
        int columnIndex = 1;
        int firstRowIndex = 1;
        int firstNumber = 7;
        int secondRowIndex = 5;
        int secondNumber = 3;

        sudokuGrid.putNumber(firstRowIndex, columnIndex, firstNumber);
        sudokuGrid.putNumber(secondRowIndex, columnIndex, secondNumber);

        assertPositionsInColumnCannotHaveNumber(firstRowIndex, columnIndex, firstNumber);
        assertPositionsInColumnCannotHaveNumber(secondRowIndex, columnIndex, secondNumber);
    }

    @Test
    public void testPopulateEntryWithRowWithOneEmptyField() {
        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(0, 1, 2);
        sudokuGrid.putNumber(0, 2, 3);
        sudokuGrid.putNumber(0, 3, 4);
        sudokuGrid.putNumber(0, 4, 5);
        sudokuGrid.putNumber(0, 5, 6);
        sudokuGrid.putNumber(0, 6, 7);
        sudokuGrid.putNumber(0, 7, 8);

        sudokuGrid.populateRow();

        assertEquals(Integer.valueOf(9), sudokuGrid.getGrid()[0][8].getNumber());
    }

    @Test
    public void testPopulateEntryWithRowAlmostFullAndOneInColumn() {
        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(0, 1, 2);
        sudokuGrid.putNumber(0, 2, 3);
        sudokuGrid.putNumber(0, 3, 4);
        sudokuGrid.putNumber(0, 4, 5);
        sudokuGrid.putNumber(0, 6, 6);
        sudokuGrid.putNumber(0, 7, 7);
        sudokuGrid.putNumber(1, 8, 8);

        sudokuGrid.populateRow();
        sudokuGrid.populateRow();

        assertEquals(Integer.valueOf(8), sudokuGrid.getGrid()[0][5].getNumber());
        assertEquals(Integer.valueOf(9), sudokuGrid.getGrid()[0][8].getNumber());
    }

    @Test
    public void testPopulateEntryWhenNoApplicableEntry() {
        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(0, 1, 2);
        sudokuGrid.putNumber(0, 2, 3);
        sudokuGrid.putNumber(0, 3, 4);
        sudokuGrid.putNumber(0, 4, 5);
        sudokuGrid.putNumber(0, 5, 6);
        sudokuGrid.putNumber(0, 6, 7);

        sudokuGrid.populateRow();

        assertNull(sudokuGrid.getGrid()[0][7].getNumber());
        assertNull(sudokuGrid.getGrid()[0][8].getNumber());
    }

    @Test
    public void testPopulateColumn() {
        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(1, 0, 2);
        sudokuGrid.putNumber(2, 0, 3);
        sudokuGrid.putNumber(3, 0, 4);
        sudokuGrid.putNumber(4, 0, 5);
        sudokuGrid.putNumber(5, 0, 6);
        sudokuGrid.putNumber(6, 0, 7);
        sudokuGrid.putNumber(7, 0, 8);

        sudokuGrid.populateRow();

        assertEquals(Integer.valueOf(9), sudokuGrid.getGrid()[8][0].getNumber());
    }

    @Test
    public void testPutNumberInSubGrid() {
        int rowIndex = 1;
        int columnIndex = 1;

        int number = 0;

        sudokuGrid.putNumber(rowIndex, columnIndex, number);

        assertPositionsInSubGridCannotHaveNumber(rowIndex, columnIndex, number);
    }


    @Test
    public void testPutTwoNumbersInSubGrid() {
        int columnIndex = 1;
        int firstRowIndex = 1;
        int firstNumber = 6;
        int secondRowIndex = 5;
        int secondNumber = 3;

        sudokuGrid.putNumber(firstRowIndex, columnIndex, firstNumber);
        sudokuGrid.putNumber(secondRowIndex, columnIndex, secondNumber);

        assertPositionsInColumnCannotHaveNumber(firstRowIndex, columnIndex, firstNumber);
        assertPositionsInColumnCannotHaveNumber(secondRowIndex, columnIndex, secondNumber);
    }

    @Test
    public void testPopulateNumberInSubGrid() {
        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(1, 0, 2);
        sudokuGrid.putNumber(2, 0, 3);
        sudokuGrid.putNumber(0, 1, 4);
        sudokuGrid.putNumber(1, 1, 5);
        sudokuGrid.putNumber(2, 1, 6);
        sudokuGrid.putNumber(0, 2, 7);
        sudokuGrid.putNumber(1, 2, 8);

        sudokuGrid.populateRow();

        assertEquals(Integer.valueOf(9), sudokuGrid.getGrid()[2][2].getNumber());
    }

    @Test
    public void testPopulateNumberInSubGridAndRow() {
        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(1, 0, 2);
        sudokuGrid.putNumber(2, 0, 3);
        sudokuGrid.putNumber(0, 1, 4);
        sudokuGrid.putNumber(1, 1, 5);
        sudokuGrid.putNumber(2, 1, 6);
        sudokuGrid.putNumber(0, 3, 7);
        sudokuGrid.putNumber(0, 4, 8);

        sudokuGrid.populateRow();

        assertEquals(Integer.valueOf(9), sudokuGrid.getGrid()[0][2].getNumber());
    }

    @Test
    public void populateWholeGrid() {
        sudokuGrid.putNumber(0, 4, 7);
        sudokuGrid.putNumber(0, 5, 9);
        sudokuGrid.putNumber(0, 7, 8);

        sudokuGrid.putNumber(1, 1, 3);
        sudokuGrid.putNumber(1, 2, 6);
        sudokuGrid.putNumber(1, 3, 5);
        sudokuGrid.putNumber(1, 5, 2);
        sudokuGrid.putNumber(1, 6, 9);

        sudokuGrid.putNumber(2, 1, 7);
        sudokuGrid.putNumber(2, 4, 6);
        sudokuGrid.putNumber(2, 7, 5);
        sudokuGrid.putNumber(2, 8, 1);


        sudokuGrid.putNumber(3, 0, 5);
        sudokuGrid.putNumber(3, 3, 3);
        sudokuGrid.putNumber(3, 4, 2);
        sudokuGrid.putNumber(3, 5, 6);

        sudokuGrid.putNumber(4, 0, 7);
        sudokuGrid.putNumber(4, 3, 1);
        sudokuGrid.putNumber(4, 8, 6);


        sudokuGrid.putNumber(5, 1, 4);
        sudokuGrid.putNumber(5, 2, 2);
        sudokuGrid.putNumber(5, 4, 5);
        sudokuGrid.putNumber(5, 7, 3);

        sudokuGrid.putNumber(6, 0, 2);
        sudokuGrid.putNumber(6, 1, 5);
        sudokuGrid.putNumber(6, 2, 7);
        sudokuGrid.putNumber(6, 5, 8);
        sudokuGrid.putNumber(6, 8, 9);

        sudokuGrid.putNumber(7, 0, 4);
        sudokuGrid.putNumber(7, 1, 6);
        sudokuGrid.putNumber(7, 2, 8);
        sudokuGrid.putNumber(7, 4, 9);
        sudokuGrid.putNumber(7, 6, 3);
        sudokuGrid.putNumber(7, 7, 7);


        sudokuGrid.putNumber(8, 1, 1);
        sudokuGrid.putNumber(8, 5, 5);
        sudokuGrid.putNumber(8, 8, 2);

        printGrid(sudokuGrid.getGrid());

        sudokuGrid.populateWholeGrid();

        printGrid(sudokuGrid.getGrid());
    }

    private void assertPositionsInRowCannotHaveNumber(final int rowIndex, final int columnIndex, final Integer number) {

        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (i != columnIndex) {
                assertFalse(String.format("Row %d with column index %d cannot have possibility of number %d", rowIndex,
                        i, number), sudokuGrid.getGrid()[rowIndex][i].getPossibleNumbers()[number]);
            } else {
                assertEquals(String.format("Row %d with column index %d should have number %d",
                        rowIndex, i, number), number, sudokuGrid.getGrid()[rowIndex][i].getNumber());
            }
        }

    }

    private void assertPositionsInColumnCannotHaveNumber(final int rowIndex, final int columnIndex, final Integer
            number) {

        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (i != rowIndex) {
                assertFalse(String.format("Row %d with column index %d cannot have possibility of number %d", i,
                        columnIndex, number), sudokuGrid.getGrid()[i][columnIndex].getPossibleNumbers()[number]);
            } else {
                assertEquals(String.format("Row %d with column index %d should have number %d",
                        i, columnIndex, number), number, sudokuGrid.getGrid()[i][columnIndex].getNumber());
            }
        }
    }

    private void assertPositionsInSubGridCannotHaveNumber(final int rowIndexOfNumber, final int columnIndexOfNumber,
                                                          final Integer
            number) {
        SubGrid subGrid = new SubGrid(rowIndexOfNumber, columnIndexOfNumber);

        for (int rowIndex = subGrid.getFirstRowIndex(); rowIndex < subGrid.getFirstRowIndex() + SUB_GRID_DIMENSION; rowIndex++) {
            for (int columnIndex = subGrid.getFirstColumnIndex(); columnIndex < subGrid.getFirstColumnIndex() +
                    SUB_GRID_DIMENSION; columnIndex++) {
                if(rowIndex == rowIndexOfNumber && columnIndex == columnIndexOfNumber) {
                    assertEquals(String.format("Row %d with column index %d should have number %d",
                            rowIndex, columnIndex, number), number, sudokuGrid.getGrid()[rowIndexOfNumber][columnIndexOfNumber].getNumber());
                } else {
                    assertFalse(String.format("Row %d with column index %d cannot have possibility of number %d", rowIndex,
                            columnIndex, number), sudokuGrid.getGrid()[rowIndexOfNumber][columnIndexOfNumber].getPossibleNumbers()
                            [number]);
                }
            }
        }
    }

}