package com.company.sudokuresolver;

import lombok.Getter;

import java.util.stream.IntStream;

import static com.company.sudokuresolver.Utility.SUB_GRID_DIMENSION;

@Getter
public class SubGrid {

    private int firstRowIndex;
    private int firstColumnIndex;

    public SubGrid(final int rowIndex, final int columnIndex) {
        firstRowIndex = calculateSubGrid(rowIndex) * SUB_GRID_DIMENSION;
        firstColumnIndex = calculateSubGrid(columnIndex) * SUB_GRID_DIMENSION;
    }

    private int calculateSubGrid(final int index) {
        return (index) / SUB_GRID_DIMENSION;
    }
}
