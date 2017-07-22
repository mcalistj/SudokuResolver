package com.company.sudokuresolver;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
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

    public SubGrid(final int subGridIndex) {
        firstRowIndex = IndexMapping.get(subGridIndex).getRowIndex();
        firstColumnIndex = IndexMapping.get(subGridIndex).getColumnIndex();
    }

    private static Map<Integer,ColumnRowIndex> IndexMapping;
    static {
        IndexMapping = new HashMap<Integer, ColumnRowIndex>();
        IndexMapping.put(0, new ColumnRowIndex(0, 0));
        IndexMapping.put(1, new ColumnRowIndex(0, 3));
        IndexMapping.put(2, new ColumnRowIndex(0, 6));
        IndexMapping.put(3, new ColumnRowIndex(3, 0));
        IndexMapping.put(4, new ColumnRowIndex(3, 3));
        IndexMapping.put(5, new ColumnRowIndex(3, 6));
        IndexMapping.put(6, new ColumnRowIndex(6, 0));
        IndexMapping.put(7, new ColumnRowIndex(6, 3));
        IndexMapping.put(8, new ColumnRowIndex(6, 6));
    }


    private int calculateSubGrid(final int index) {
        return (index) / SUB_GRID_DIMENSION;
    }
}
