package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;

import junit.framework.TestCase;

public class DayOfWeekTest extends TestCase {
    
    public void test正しくインタンスを生成できる() {
        assertEquals(DayOfWeek.SUNDAY, DayOfWeek.create(Calendar.SUNDAY));
        assertEquals(DayOfWeek.MONDAY, DayOfWeek.create(Calendar.MONDAY));
        assertEquals(DayOfWeek.TUESDAY, DayOfWeek.create(Calendar.TUESDAY));
        assertEquals(DayOfWeek.WEDNESDAY, DayOfWeek.create(Calendar.WEDNESDAY));
        assertEquals(DayOfWeek.THURSDAY, DayOfWeek.create(Calendar.THURSDAY));
        assertEquals(DayOfWeek.FRIDAY, DayOfWeek.create(Calendar.FRIDAY));
        assertEquals(DayOfWeek.SATURDAY, DayOfWeek.create(Calendar.SATURDAY));
    }
    
    public void test範囲外だったらインスタンスを生成できない() {
        try {
            DayOfWeek.create(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
    
}
