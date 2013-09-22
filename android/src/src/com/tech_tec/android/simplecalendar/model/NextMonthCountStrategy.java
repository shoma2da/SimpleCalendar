package com.tech_tec.android.simplecalendar.model;


public class NextMonthCountStrategy {
    
    public NextMonthCountStrategy() {
    }
    
    public int getPreviousMonthCount(Month month) {
        DayOfWeek dayOfWeek = month.getFirstDayOfWeek();
        if (dayOfWeek.ordinal() == 0) {
            return 7;
        }
        return dayOfWeek.ordinal();
    }
    
    public int getNextMonthCount(Month month) {
        int count = month.daysSize();
        int nextCount = getPreviousMonthCount(month);
        return (7 * 6/* 6週間 */) - (count + nextCount);
    }
    
}
