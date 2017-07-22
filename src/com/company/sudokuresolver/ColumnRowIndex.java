package com.company.sudokuresolver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Data
public class ColumnRowIndex {
    private int rowIndex;
    private int columnIndex;
}
