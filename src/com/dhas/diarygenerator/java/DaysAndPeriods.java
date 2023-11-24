package com.dhas.diarygenerator.java;

import java.util.Calendar;

public enum DaysAndPeriods {
    MONDAY(new int[] {2, 2, 3}),
    TUESDAY(new int[] {1, 2, 3, 1}),
    WEDNESDAY(new int[] {2, 3, 2}),
    THURSDAY(new int[] {1, 3, 2, 1}),
    FRIDAY(new int[] {3, 2, 2});

    private final int[] periods;

    DaysAndPeriods(int[] periods) {
        this.periods = periods;
    }

    public int[] getPeriods() {
        return periods;
    }

    public static int[] getPeriodsByDate(Calendar date) {
        int numOfDay = date.get(Calendar.DAY_OF_WEEK);
        return DaysAndPeriods.values()[numOfDay - 2].getPeriods();
    }
}

