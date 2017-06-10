package com.company.sudokuresolver;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static com.company.sudokuresolver.Utility.DIMENSION;

@Setter
@Getter
public class IndividualEntry {

    private Integer number;
    private boolean[] possibleNumbers = new boolean[10];
    private boolean filled;

    public IndividualEntry() {
        possibleNumbers[0] = false;
        IntStream.rangeClosed(1, Utility.DIMENSION).forEach(
                number -> {
                    possibleNumbers[number] = true;
                }
        );

        filled = false;
    }

    public void eliminatePossibility(final int number) {
        possibleNumbers[number] = false;
    }

    public boolean fillWithOnlyPossiblity() {
        Integer possibility = null;
        int numberOfPossibilities = 0;

        for (int i = 1; i <= Utility.DIMENSION; i++) {
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

        for (int i = 1; i <= Utility.DIMENSION; i++) {
            if (i != number) {
                possibleNumbers[i] = false;
            } else {
                possibleNumbers[i] = true;
            }
        }
    }

    private Set<Integer> possibleNumbers(){
        Set<Integer> possible = new HashSet<Integer>();
        for(int i = 0; i< DIMENSION; i++) {
            if (possibleNumbers[i]) {
                possible.add(i);
            }
        }
        return possible;
    }
}
