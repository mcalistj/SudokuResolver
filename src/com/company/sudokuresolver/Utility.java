package com.company.sudokuresolver;

public class Utility {

    public static int DIMENSION = 9;
    public static int SUB_GRID_DIMENSION = 3;

    public static void printGrid(final IndividualEntry[][] grid) {
        for (int rowIndex = 0; rowIndex < DIMENSION; rowIndex++) {

            printHorizontalPartition(rowIndex);

            for (int columnIndex = 0; columnIndex < DIMENSION; columnIndex++) {
                printVerticalPartition(columnIndex);

                if (grid[rowIndex][columnIndex].getNumber() != null) {
                    System.out.print(grid[rowIndex][columnIndex].getNumber());
                } else {
                    System.out.print("~");
                }
            }

            System.out.print("|\n");
        }

    }

    private static void printHorizontalPartition(final int rowIndex) {
        if (rowIndex % 3 == 0) {
            for (int i = 0; i < DIMENSION; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private static void printVerticalPartition(final int columnIndex) {
        if (columnIndex % 3 == 0) {
            System.out.print("|");
        }
    }
}
