package com.dhas.diarygenerator.java;

import java.util.Calendar;

public class SchemePeriods {
    static final int[] MONDAY = {2, 2, 3};
    static final int[] TUESDAY = {1, 2, 3, 1};
    static final int[] WEDNESDAY = {2, 3, 2};
    static final int[] THURSDAY = {1, 3, 2, 1};
    static final int[] FRIDAY = {3, 2, 2};

    public static int[] getPeriodByDate(Calendar inputtedCal) {

        switch (inputtedCal.get(Calendar.DAY_OF_WEEK)) {
            case (Calendar.MONDAY) -> {
                return MONDAY;
            }
            case (Calendar.TUESDAY) -> {
                return TUESDAY;
            }
            case (Calendar.WEDNESDAY) -> {
                return WEDNESDAY;
            }
            case (Calendar.THURSDAY) -> {
                return THURSDAY;
            }
            case (Calendar.FRIDAY) -> {
                return FRIDAY;
            }
            default -> {
                return null;
            }
        }
    }
}
