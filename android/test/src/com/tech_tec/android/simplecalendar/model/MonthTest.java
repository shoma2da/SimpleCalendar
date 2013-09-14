package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;
import java.util.Date;

import android.test.AndroidTestCase;

public class MonthTest extends AndroidTestCase {
    
    public void test曜日に応じて前月の日にち数を求める() {
        Month month = new Month();
        
        assertEquals(7, month.previousDayCount(Calendar.SUNDAY));
        assertEquals(1, month.previousDayCount(Calendar.MONDAY));
        assertEquals(2, month.previousDayCount(Calendar.TUESDAY));
        assertEquals(3, month.previousDayCount(Calendar.WEDNESDAY));
        assertEquals(4, month.previousDayCount(Calendar.THURSDAY));
        assertEquals(5, month.previousDayCount(Calendar.FRIDAY));
        assertEquals(6, month.previousDayCount(Calendar.SATURDAY));
    }
    
    public void test年数が取得できる() {
        for (int i = 0; i < 200; i++) {
            //1970年から200年分をテスト
            doTest月数が取得できる(1970 + i);
        }
    }
    private void doTest年数が取得できる(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        
        Month month = new Month(calendar.getTime());
        
        assertEquals(year, month.getYear());
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
    
    public void test次月分のデータ個数が正しい() {
        Month month = new Month();
        month.setNextDays(new Date(), 31, 3);
        
        assertEquals(Month.MAX_DAYS_COUNT - 31 - 3, month.nextDaysSize());
    }
    
}
