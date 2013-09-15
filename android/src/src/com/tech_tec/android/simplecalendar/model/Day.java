package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;
import java.util.Date;

public class Day {
    
    private Date mDate;

    public Day(Date date) {
        mDate = date;
    }
    
    public Integer toInt() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
    
    public DayOfWeek getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        return DayOfWeek.create(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
