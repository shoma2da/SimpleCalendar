package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import junit.framework.TestCase;

public class NextMonthTest extends TestCase {
    
    public void test次月を返却する() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 0, 1);
        
        for (int i = 0; i < 12 * 200; i++) {//200年分をテスト
            calendar.add(Calendar.MONTH, i);
            Month month = new Month(calendar.getTime());
            
            NextMonth nextMonth = new NextMonth(month, 0);
            
            Calendar nextCalendar = Calendar.getInstance();
            nextCalendar.setTime(calendar.getTime());
            nextCalendar.add(Calendar.MONTH, 1);
            assertEquals(nextCalendar.get(Calendar.MONTH) + 1, nextMonth.getMonth());
            assertEquals(nextCalendar.get(Calendar.YEAR), nextMonth.getYear());
        }
    }
    

    public void test生成時のカウント分の日付が取得できる() {
        for (int i = 0; i < 10; i++) {
            doTest生成時のカウント分の日付が取得できる(i);
        }
    }
    public void doTest生成時のカウント分の日付が取得できる(int count) {
        Month month = new Month(new Date());
        NextMonth nextMonth = new NextMonth(month, count);
        Iterator<Day> iterator = nextMonth.getDays();
        
        for (int i = 0; i < count; i++) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }
}
