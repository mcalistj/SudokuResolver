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

    public void removeImpossibleNumber(final int number) {
        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (i == number) {
                possibleNumbers[i] = false;
            }
        }
    }

    public void populateWithNumber(final int number) {
        this.number = number;
        filled = true;

        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (i == number) {
                possibleNumbers[i] = true;
            } else {
                possibleNumbers[i] = false;
            }
        }
    }
}
