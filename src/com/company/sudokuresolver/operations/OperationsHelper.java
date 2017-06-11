package com.company.sudokuresolver.operations;

import com.company.sudokuresolver.IndividualEntry;

import java.util.ArrayList;

import static com.company.sudokuresolver.Utility.DIMENSION;

public class OperationsHelper {

    public static void exclusiveOrPossibleNumbers(final IndividualEntry entry, final ArrayList<Integer> possible) {
        for (int number = 1; number <= DIMENSION; number++) {
            if (entry.getPossibleNumbers()[number]) {
                if (possible.contains(number)) {
                    possible.remove(Integer.valueOf(number));
                } else {
                    possible.add(number);
                }
            }
        }
    }
}
