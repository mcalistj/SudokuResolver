package com.company.sudokuresolver;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Position {
    private int number;
    private int rowIndex;
    private int columnIndex;

    public Position setNumber(final int number) {
        this.number = number;
        return this;
    }
}
