package com.company.sudokuresolver;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by johmcali on 5/7/17.
 */
public class SudokuGridTest {
    List<Integer> entriesFilled = new ArrayList<>(Arrays.asList(0, 3, 9));
    List<Integer> numbersTaken = new ArrayList<>(Arrays.asList(0, 2, 9));

    Map<Integer, Integer> row = new HashMap<Integer, Integer>(){{
        put(0, 2);
        put(3, 9);
        put(9, 0);
    }};

    private SudokuGrid grid;

    @Before
    public void setUp () {
        grid = new SudokuGrid();
    }

    @Test
    public void testEliminateDueToNumberInRow () {
        int rowIndex = 1;

        populateRowWithIndex(rowIndex, row);


    }


    public void assertNotPossibleInRow (final int rowIndex, final Map<Integer, Integer> positionAndNumbers) {

        for (Map.Entry<Integer, Integer> entry : positionAndNumbers.entrySet())
        {
            grid.getGrid()[rowIndex][entry.getValue()].setNumber(entry.getValue());
        }
    }

    public void populateRowWithIndex (final int rowIndex, final Map<Integer, Integer> positionAndNumbers) {


        for (Map.Entry<Integer, Integer> entry : positionAndNumbers.entrySet())
        {
            grid.getGrid()[rowIndex][entry.getValue()].setNumber(entry.getValue());
        }
    }
}