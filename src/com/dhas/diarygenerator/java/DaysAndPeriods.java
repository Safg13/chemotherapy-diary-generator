package com.dhas.diarygenerator.java;

import java.util.Calendar;

public enum DaysAndPeriods {
    MONDAY(new int[] {2, 2, 3}),
    TUESDAY(new int[] {1, 2, 3, 1}),
    WEDNESDAY(new int[] {2, 3, 2}),
    THURSDAY(new int[] {1, 3, 2, 1}),
    FRIDAY(new int[] {3, 2, 2});

    DaysAndPeriods(int[] periods) {
        this.periods = periods;
    }

    private final int[] periods;

    public int[] getPeriods() {
        return periods;
    }

    public DaysAndPeriods getPeriodsByDate(Calendar date) {
        switch (date.get(Calendar.DAY_OF_WEEK)) {
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
