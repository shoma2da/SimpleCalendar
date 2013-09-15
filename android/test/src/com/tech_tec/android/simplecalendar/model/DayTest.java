package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;

import android.test.AndroidTestCase;

public class DayTest extends AndroidTestCase {
    
    public void test渡した日付が正しく取得できるか() {
        doTest渡した日付が正しく取得できるか(1988, 3, 15);
        doTest渡した日付が正しく取得できるか(1987, 7, 13);
        doTest渡した日付が正しく取得できるか(2013, 9, 8);
    }
    private void doTest渡した日付が正しく取得できるか(Integer year, Integer month, Integer dayValue) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayValue);
        Day day = new Day(calendar.getTime());
        assertEquals(dayValue, day.toInt());
    }
    
    public void test曜日を取得できる() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2013, 9 - 1, 1); //月曜日
        assertEquals(DayOfWeek.SUNDAY, new Day(calendar.getTime()).getDayOfWeek());
        calendar.add(Calendar.DATE, 1);
        assertEquals(DayOfWeek.MONDAY, new Day(calendar.getTime()).getDayOfWeek());
        calendar.add(Calendar.DATE, 1);
        assertEquals(DayOfWeek.TUESDAY, new Day(calendar.getTime()).getDayOfWeek());
        calendar.add(Calendar.DATE, 1);
        assertEquals(DayOfWeek.WEDNESDAY, new Day(calendar.getTime()).getDayOfWeek());
        calendar.add(Calendar.DATE, 1);
        assertEquals(DayOfWeek.THURSDAY, new Day(calendar.getTime()).getDayOfWeek());
        calendar.add(Calendar.DATE, 1);
        assertEquals(DayOfWeek.FRIDAY, new Day(calendar.getTime()).getDayOfWeek());
        calendar.add(Calendar.DATE, 1);
        assertEquals(DayOfWeek.SATURDAY, new Day(calendar.getTime()).getDayOfWeek());
    }
    
}
