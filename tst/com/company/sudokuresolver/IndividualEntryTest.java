package com.company.sudokuresolver;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class IndividualEntryTest {

    private IndividualEntry entry;

    @Before
    public void setUp () {
        entry = new IndividualEntry();
    }

    @Test
    public void testPopulateSquare () {
        int expectedNumber = 1;

        entry.populateWithNumber(expectedNumber);

        assertIndividualEntry(expectedNumber, entry);
    }

    @Test
    public void removeImmpossibleNumber () {
        int immpossibleNumber = 1;

        entry.EliminateDueToNumberInRow(immpossibleNumber);

        assertFalse(entry.getPossibleNumbers()[immpossibleNumber]);
    }

    public void assertIndividualEntry (final int expectedNumber, final IndividualEntry entry) {
        assertEquals(expectedNumber, entry.getNumber());

        for (int i = 0; i < Utility.DIMENSION; i++) {
            if (i == expectedNumber) {
                assertTrue(String.format("%d was meant to be true", i), entry.getPossibleNumbers()[i]);
            } else {
                assertFalse(String.format("%d was meant to be false", i),entry.getPossibleNumbers()[i]);
            }
        }
    }
}