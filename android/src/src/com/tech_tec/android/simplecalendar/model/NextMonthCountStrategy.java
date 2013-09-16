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
        return 0;
    }
    
}
