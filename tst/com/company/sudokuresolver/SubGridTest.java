package com.company.sudokuresolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubGridTest {

    @Test
    public void testRangesInSubGridFirstSubGridFirstEntry() {
        int rowIndex = 0;
        int columnIndex = 0;

        SubGrid subGrid = new SubGrid(rowIndex, columnIndex);

        assertEquals(0, subGrid.getFirstRowIndex());
        assertEquals(0, subGrid.getFirstColumnIndex());
    }

    @Test
    public void testRangesInSubGridFirstSubGridLastEntry() {
        int rowIndex = 2;
        int columnIndex = 8;

        SubGrid subGrid = new SubGrid(rowIndex, columnIndex);

        assertEquals(0, subGrid.getFirstRowIndex());
        assertEquals(6, subGrid.getFirstColumnIndex());
    }

    @Test
    public void testRangesInSubGridFirstSubGridFourthSubGridFirstEntry() {
        int rowIndex = 3;
        int columnIndex = 0;

        SubGrid subGrid = new SubGrid(rowIndex, columnIndex);

        assertEquals(3, subGrid.getFirstRowIndex());
        assertEquals(0, subGrid.getFirstColumnIndex());
    }

    @Test
    public void testGetSubGridGivenSubGridIndex(){
        SubGrid subGrid = new SubGrid(0);

        assertEquals(0, subGrid.getFirstColumnIndex());
        assertEquals(0, subGrid.getFirstRowIndex());

    }

    @Test
    public void testGetSubGridGivenSubGridIndex5thIndex(){
        SubGrid subGrid = new SubGrid(5);

        assertEquals(6, subGrid.getFirstColumnIndex());
        assertEquals(3, subGrid.getFirstRowIndex());

    }

    @Test
    public void testGetSubGridGivenSubGridIndex8thIndex(){
        SubGrid subGrid = new SubGrid(8);

        assertEquals(6, subGrid.getFirstColumnIndex());
        assertEquals(6, subGrid.getFirstRowIndex());

    }

}