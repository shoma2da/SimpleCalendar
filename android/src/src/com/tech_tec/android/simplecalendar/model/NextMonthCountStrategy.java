package com.tech_tec.android.simplecalendar.model;


public class NextMonthCountStrategy {
    
    private Month mMonth;
    
    public NextMonthCountStrategy(Month month) {
        mMonth = month;
    }
    
    public int getPreviousMonthCount() {
        DayOfWeek dayOfWeek = mMonth.getFirstDayOfWeek();
        if (dayOfWeek.ordinal() == 0) {
            return 7;
        }
        return dayOfWeek.ordinal();
    }
    
    public int getNextMonthCount() {
        int count = mMonth.daysSize();
        int nextCount = getPreviousMonthCount();
        return (7 * 6/* 6週間 */) - (count + nextCount);
    }
    
}
