package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;

import android.test.AndroidTestCase;

public class DayTest extends AndroidTestCase {
    
    public void test渡した日付が正しく取得できるか() {
        doTest渡した日付が正しく取得できるか(1988, 3, 15);
        doTest渡した日付が正しく取得できるか(1987, 7, 13);
        doTest渡した日付が正しく取得できるか(2013, 9, 8);
    }
    public void doTest渡した日付が正しく取得できるか(int year, int month, int dayValue) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayValue);
        Day day = new Day(calendar.getTime());
        assertEquals(dayValue, day.getDayValue().toInt());
    }
    
}
