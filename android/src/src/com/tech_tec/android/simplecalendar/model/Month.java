package com.tech_tec.android.simplecalendar.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Month {
    
    public static final int MAX_DAYS_COUNT = 7 * 6;
    
    private Date mToday;
    private ArrayList<Day> previousDays = new ArrayList<Day>();
    private ArrayList<Day> days         = new ArrayList<Day>();
    private ArrayList<Day> nextDays     = new ArrayList<Day>();
    
    Month() {}
    
    public Month(Date today) {
        setPreviousDays(today);
        setDays(today);
        setNextDays(today, this.previsousDaysSize(), this.daysSize());
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
    
    public Iterator<Day> getPreviousDays() {
        return this.previousDays.iterator();
    }
    public int previsousDaysSize() {
        return this.previousDays.size();
    }
    void setPreviousDays(Date today) {
        //月のはじめの日に移動
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
        
        //前月分のデータを追加
        int count = this.previousDayCount(firstDay);
        for (int i = 0; i < count; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            this.previousDays.add(new Day(calendar.getTime()));
        }
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

    public Iterator<Day> getNextDays() {
        return this.nextDays.iterator();
    }
    public int nextDaysSize() {
        return this.nextDays.size();
    }
    void setNextDays(Date today, int previousDaysCount, int daysCount) {
        //最終日に移動
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, max);

        //必要な日にち分をデータ追加
        int count = MAX_DAYS_COUNT - previousDaysCount - daysCount;
        for (int i = 0; i < count; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            this.nextDays.add(new Day(calendar.getTime()));
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
