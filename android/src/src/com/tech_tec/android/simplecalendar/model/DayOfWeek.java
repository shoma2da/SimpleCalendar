package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;

public enum DayOfWeek {
    
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    
    public static DayOfWeek create(int dayOfWeek) {
        switch (dayOfWeek) {
        case Calendar.SUNDAY:
            return SUNDAY;
        case Calendar.MONDAY:
            return MONDAY;
        case Calendar.TUESDAY:
            return TUESDAY;
        case Calendar.WEDNESDAY:
            return WEDNESDAY;
        case Calendar.THURSDAY:
            return THURSDAY;
        case Calendar.FRIDAY:
            return FRIDAY;
        case Calendar.SATURDAY:
            return SATURDAY;
        default:
            throw new IllegalArgumentException();
        }
    }
}
