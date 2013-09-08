package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;

import android.test.AndroidTestCase;
import android.util.Log;

public class MonthTest extends AndroidTestCase {
    
    public void test曜日に応じて前月の日にちを求める() {
        Month month = new Month();
        
        assertEquals(7, month.previousDayCount(Calendar.SUNDAY));
        assertEquals(1, month.previousDayCount(Calendar.MONDAY));
        assertEquals(2, month.previousDayCount(Calendar.TUESDAY));
        assertEquals(3, month.previousDayCount(Calendar.WEDNESDAY));
        assertEquals(4, month.previousDayCount(Calendar.THURSDAY));
        assertEquals(5, month.previousDayCount(Calendar.FRIDAY));
        assertEquals(6, month.previousDayCount(Calendar.SATURDAY));
    }
    
    public void testその月の日数分のデータが入る() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 0, 1);
        
        //1970年から2100年までをテスト(130年✕12ヶ月)
        for (int i = 0; i < (130 * 12); i++) {
            int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            Month month = new Month();
            month.setDays(calendar.getTime());
            
            assertEquals(max, month.daysSize());
            calendar.add(Calendar.MONTH, 1);
        }
    }
    
}
