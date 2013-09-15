package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

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
    
    public void test生成時のカウント分の日付が取得できる() {
        for (int i = 0; i < 10; i++) {
            doTest生成時のカウント分の日付が取得できる(i);
        }
    }
    public void doTest生成時のカウント分の日付が取得できる(int count) {
        Month month = new Month(new Date());
        PreviousMonth previousMonth = new PreviousMonth(month, count);
        Iterator<Day> iterator = previousMonth.getDays();
        
        for (int i = 0; i < count; i++) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }
    
}
