package com.tech_tec.android.simplecalendar.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Month {
    
    public static final int MAX_DAYS_COUNT = 7 * 6;
    
    private Date mToday;
    private ArrayList<Day> days         = new ArrayList<Day>();
    
    Month() {}
    
    public Month(Date today) {
        setDays(today);
        mToday = today;
    }
    
    public Iterator<Day> getDays() {
        return this.days.iterator();
    }
    public int daysSize() {
        return this.days.size();
    }
    void setDays(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        
        int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < max; i++) {
            Day day = new Day(calendar.getTime());
            this.days.add(day);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
    
    public int getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mToday);
        return calendar.get(Calendar.YEAR);
    }
    public int getMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mToday);
        return calendar.get(Calendar.MONTH) + 1;
    }
}
