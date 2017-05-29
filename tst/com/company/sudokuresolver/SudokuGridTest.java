package com.company.sudokuresolver;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SudokuGridTest {

    Map<Integer, Integer> ROW = new HashMap<Integer, Integer>() {{
        put(0, 2);
        put(3, 9);
        put(9, 0);
    }};

    private SudokuGrid grid;

    @Before
    public void setUp() {
        grid = new SudokuGrid();
    }

    @Test
    public void testSquaresFilled() {
        int rowIndex = 1;
        populateRowWithIndex(rowIndex, ROW);

        assertPositionsfilled(rowIndex, ROW);
    }

    @Test
    public void testOtherSquaresNotFilled() {
        int rowIndex = 1;
        populateRowWithIndex(rowIndex, ROW);

        assertPositionsNotfilled(rowIndex, ROW);
    }

    @Test
    public void testPutNumberCheckRow() {
        int rowIndex = 1;
        int columnIndex = 1;
        int number = 0;

        grid.putNumber(rowIndex, columnIndex, number);

        assertPositionsNotInRowCannotHaveNumber(rowIndex, columnIndex, number);
    }

    @Test
    public void checkNumbersNotPossibleInRow() {
        int rowIndex = 1;
        populateRowWithIndex(rowIndex, ROW);

        assertPositionsNotFilledHaveReducedPossibilities(rowIndex, ROW);
    }

    private void assertPositionsNotInRowCannotHaveNumber(final int rowIndex, final int columnIndex, final int number) {

        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (i != columnIndex) {
                assertFalse(String.format("Row %d with column index %d have possibility of number %d", rowIndex,
                        columnIndex, number), grid.getGrid()[rowIndex][i].getPossibleNumbers()[i]);
            } else {
                assertEquals(String.format("Row %d with column index %d should have number %d",
                        rowIndex, columnIndex, number), number, grid.getGrid()[rowIndex][i].getNumber());
            }
        }

    }


    private void assertPositionsfilled(final int rowIndex, final Map<Integer, Integer> positionAndNumber) {
        for (Map.Entry<Integer, Integer> entry : positionAndNumber.entrySet()) {
            assertTrue(String.format("Row %s should be filled", rowIndex),
                    grid.getGrid()[rowIndex][entry.getKey()].isFilled());
        }
    }

    private void assertPositionsNotfilled(final int rowIndex,
                                          final Map<Integer, Integer> positionAndNumber) {
        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (!positionAndNumber.containsKey(i)) {
                assertFalse(String.format("Row %s should not be filled", rowIndex),
                        grid.getGrid()[rowIndex][i].isFilled());
            }
        }
    }

    private void assertPositionsNotFilledHaveReducedPossibilities(final int rowIndex,
                                                                  final Map<Integer, Integer> positionAndNumber) {
        Set<Integer> numbersTaken = getNumbersTaken(rowIndex, positionAndNumber);

        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (!positionAndNumber.containsKey(i)) {
                assertNumbersAreNotPossibleInSquare(grid.getGrid()[rowIndex][i], numbersTaken);
                assertFalse(String.format("Row %s should not be filled", rowIndex),
                        grid.getGrid()[rowIndex][i].isFilled());
            }
        }
    }

    private void assertNumbersAreNotPossibleInSquare(final IndividualEntry square, final Set<Integer> numbersTaken) {

        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (numbersTaken.contains(i)) {
                assertFalse(String.format("Possibility of %d in this square should be true", i), square
                        .getPossibleNumbers()[i]);
            } else {
                assertTrue(String.format("Possibility of %d in this square should be true", i), square
                        .getPossibleNumbers()[i]);
            }
        }
    }

    private Set<Integer> getNumbersTaken(final int rowIndex, final Map<Integer, Integer> positionAndNumber) {

        Set<Integer> numbersTaken = new HashSet<Integer>();

        for (Map.Entry<Integer, Integer> entry : positionAndNumber.entrySet()) {
            numbersTaken.add(grid.getGrid()[rowIndex][entry.getKey()].getNumber());
        }

        return numbersTaken;
    }

    private void populateRowWithIndex(final int rowIndex, final Map<Integer, Integer> positionAndNumber) {

        for (Map.Entry<Integer, Integer> entry : positionAndNumber.entrySet()) {
            grid.getGrid()[rowIndex][entry.getKey()].setNumber(entry.getValue());
        }
    }
}