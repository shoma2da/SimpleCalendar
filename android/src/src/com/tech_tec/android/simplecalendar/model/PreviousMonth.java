package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;

public class PreviousMonth {
    
    private Month mMonth;
    
    PreviousMonth(Month month, int count) {
        mMonth = month;
    }
    
    public int getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(mMonth.getYear(), mMonth.getMonth() - 1, 1);
        calendar.add(Calendar.MONTH, -1);
        
        return calendar.get(Calendar.YEAR);
    }
    
    public int getMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(mMonth.getYear(), mMonth.getMonth() - 1, 1);
        calendar.add(Calendar.MONTH, -1);
        
        return calendar.get(Calendar.MONTH) + 1;
    }
    
}
