package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;
import java.util.Date;

public class Day {
    
    private Date mDate;

    public Day(Date date) {
        mDate = date;
    }
    
    public DayValue getDayValue() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        return new DayValue(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
