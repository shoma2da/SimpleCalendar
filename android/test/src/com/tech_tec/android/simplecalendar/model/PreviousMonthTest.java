package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;

import junit.framework.TestCase;

public class PreviousMonthTest extends TestCase {
    
    public void test前月を返却する() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 0, 1);
        
        for (int i = 0; i < 12 * 200; i++) {//200年分をテスト
            calendar.add(Calendar.MONTH, i);
            Month month = new Month(calendar.getTime());
            
            PreviousMonth previousMonth = new PreviousMonth(month, 0);
            
            Calendar previousCalendar = Calendar.getInstance();
            previousCalendar.setTime(calendar.getTime());
            previousCalendar.add(Calendar.MONTH, -1);
            assertEquals(previousCalendar.get(Calendar.MONTH) + 1, previousMonth.getMonth());
            assertEquals(previousCalendar.get(Calendar.YEAR), previousMonth.getYear());
        }
    }
    
}
