package com.company.sudokuresolver;

import lombok.Data;

import java.util.stream.IntStream;

@Data
public class IndividualEntry {

    private int number;
    private boolean[] possibleNumbers = new boolean[10];
    private boolean filled;

    public IndividualEntry() {
        IntStream.range(0, Utility.DIMENSION).forEach(
                number -> {
                    possibleNumbers[number] = true;
                }
        );

        filled = false;
    }

    public void eliminatePossibility(final int number) {
        possibleNumbers[number] = false;
    }

    public boolean autonomouslyPopulateEntry() {
        if (filled) {
            return true;
        }

        Integer possibility = null;
        int numberOfPossibilities = 0;

        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (possibleNumbers[i]) {
                possibility = i;
                numberOfPossibilities++;
            }
        }

        if (possibility != null && numberOfPossibilities == 1) {
            number = possibility;
            filled = true;
            return true;
        }

        return false;
    }

    public void populateWithNumber(final int number) {
        this.number = number;
        filled = true;

        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (i != number) {
                possibleNumbers[i] = false;
            } else {
                possibleNumbers[i] = true;
            }
        }
    }
}
