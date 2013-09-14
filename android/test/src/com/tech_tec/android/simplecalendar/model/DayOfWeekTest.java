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
    
    public void testValueOf() {
        assertEquals(DayOfWeek.SUNDAY, DayOfWeek.valueOf("SUNDAY"));
        assertEquals(DayOfWeek.MONDAY, DayOfWeek.valueOf("MONDAY"));
        assertEquals(DayOfWeek.TUESDAY, DayOfWeek.valueOf("TUESDAY"));
        assertEquals(DayOfWeek.WEDNESDAY, DayOfWeek.valueOf("WEDNESDAY"));
        assertEquals(DayOfWeek.THURSDAY, DayOfWeek.valueOf("THURSDAY"));
        assertEquals(DayOfWeek.FRIDAY, DayOfWeek.valueOf("FRIDAY"));
        assertEquals(DayOfWeek.SATURDAY, DayOfWeek.valueOf("SATURDAY"));
    }
    
    public void testValues() {
        DayOfWeek[] values = DayOfWeek.values();
        assertEquals(7, values.length);
        assertEquals(DayOfWeek.SUNDAY, values[0]);
        assertEquals(DayOfWeek.MONDAY, values[1]);
        assertEquals(DayOfWeek.TUESDAY, values[2]);
        assertEquals(DayOfWeek.WEDNESDAY, values[3]);
        assertEquals(DayOfWeek.THURSDAY, values[4]);
        assertEquals(DayOfWeek.FRIDAY, values[5]);
        assertEquals(DayOfWeek.SATURDAY, values[6]);
    }
    
}
