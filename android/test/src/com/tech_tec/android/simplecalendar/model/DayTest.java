package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;

import android.test.AndroidTestCase;

public class DayTest extends AndroidTestCase {
    
    public void test渡した日付が正しく取得できるか() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1988, 3, 15);
        
        Day day = new Day(calendar.getTime());
        
        assertEquals(15, day.getDayValue().toInt());
    }
    
}
