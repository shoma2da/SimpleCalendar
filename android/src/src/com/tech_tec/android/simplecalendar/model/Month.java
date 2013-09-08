package com.tech_tec.android.simplecalendar.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Month {
    
    private ArrayList<Day> previousDays = new ArrayList<Day>();
    private ArrayList<Day> days         = new ArrayList<Day>();
    private ArrayList<Day> nextDays     = new ArrayList<Day>();
    
    Month() {}
    
    public Month(Date today) {
        setDays(today);
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
    
    
    void setPreviousDays(Date today) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(today);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
    }
    int previousDayCount(int day) {
        switch (day) {
        case Calendar.SUNDAY:
            return 7;
        case Calendar.MONDAY:
            return 1;
        case Calendar.TUESDAY:
            return 2;
        case Calendar.WEDNESDAY:
            return 3;
        case Calendar.THURSDAY:
            return 4;
        case Calendar.FRIDAY:
            return 5;
        case Calendar.SATURDAY:
            return 6;
        default:
            throw new IllegalArgumentException();
        }
    }

    void setNextDays(Date today) {
        
    }
    
}
