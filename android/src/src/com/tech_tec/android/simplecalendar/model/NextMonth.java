package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;

public class NextMonth {
    
    private Month mMonth;
    private int mCount;

    NextMonth(Month month, int count) {
        mMonth = month;
        mCount = count;
    }
    
    public int getYear() {
        return getCalendar().get(Calendar.YEAR);
    }
    
    public int getMonth() {
        return getCalendar().get(Calendar.MONTH) + 1;
    }
    
    private Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(mMonth.getYear(), mMonth.getMonth() - 1, 1);
        calendar.add(Calendar.MONTH, 1);
        return calendar;
    }
    
}
