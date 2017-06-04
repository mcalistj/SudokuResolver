package com.company.sudokuresolver;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        int number = 0;

        sudokuGrid.putNumber(rowIndex, columnIndex, number);

        assertPositionsInRowCannotHaveNumber(rowIndex, columnIndex, number);
    }

    @Test
    public void testPutTwoNumbersInRow() {
        int rowIndex = 1;
        int firstColumnIndex = 1;
        int firstNumber = 0;
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
        int number = 0;

        sudokuGrid.putNumber(rowIndex, columnIndex, number);

        assertPositionsInColumnCannotHaveNumber(rowIndex, columnIndex, number);
    }

    @Test
    public void testPutTwoNumbersInColumn() {
        int columnIndex = 1;
        int firstRowIndex = 1;
        int firstNumber = 0;
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

        sudokuGrid.populateRowEntry();

        assertEquals(Integer.valueOf(9), sudokuGrid.getGrid()[0][8].getNumber());
    }

    @Test
    public void testPopulateEntryWithRowAlmostFullAndOneInColumn() {
        sudokuGrid.putNumber(0, 0, 1);
        sudokuGrid.putNumber(0, 1, 2);
        sudokuGrid.putNumber(0, 2, 3);
        sudokuGrid.putNumber(0, 3, 4);
        sudokuGrid.putNumber(0, 4, 5);
        sudokuGrid.putNumber(0, 5, 6);
        sudokuGrid.putNumber(0, 6, 7);
        sudokuGrid.putNumber(1, 8, 8);

        sudokuGrid.populateRowEntry();

        assertEquals(Integer.valueOf(9), sudokuGrid.getGrid()[0][8].getNumber());
    }

    /*@Test
    public void testPutNumberInSubGrid() {
        int gridIndex = 1;
        int columnIndex = 1;
        int number = 0;

        sudokuGrid.putNumber(rowIndex, columnIndex, number);

        assertPositionsInColumnCannotHaveNumber(rowIndex, columnIndex, number);
    }

    @Test
    public void testPutTwoNumbersInSubGrid() {
        int columnIndex = 1;
        int firstRowIndex = 1;
        int firstNumber = 0;
        int secondRowIndex = 5;
        int secondNumber = 3;

        sudokuGrid.putNumber(firstRowIndex, columnIndex, firstNumber);
        sudokuGrid.putNumber(secondRowIndex, columnIndex, secondNumber);

        assertPositionsInColumnCannotHaveNumber(firstRowIndex, columnIndex, firstNumber);
        assertPositionsInColumnCannotHaveNumber(secondRowIndex, columnIndex, secondNumber);
    }*/

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

}