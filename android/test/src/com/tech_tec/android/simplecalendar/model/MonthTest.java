package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;
import java.util.Iterator;

import android.test.AndroidTestCase;

public class MonthTest extends AndroidTestCase {
    
    public void test年数が取得できる() {
        for (int i = 0; i < 200; i++) {
            int year = 1970 + i; //1970年から200年分をテスト
            
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            Month month = new Month(calendar.getTime());
            
            assertEquals(year, month.getYear());
        }
    }

    public void test月数が取得できる() {
        for (int i = 0; i < 12; i++) {
            int monthValue = 0 + i; //1月から12月をテスト ※JavaAPIでは0〜11
            
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, monthValue);
            Month month = new Month(calendar.getTime());
            
            assertEquals(monthValue + 1, month.getMonth());
        }
    }
    
    public void testその月の日数分のデータが入る() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 0, 1);
        
        //1970年から2100年までをテスト(130年✕12ヶ月)
        for (int i = 0; i < (130 * 12); i++) {
            int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            Month month = new Month(calendar.getTime());
            
            assertEquals(max, month.daysSize());
            calendar.add(Calendar.MONTH, 1);
            
            //Iteratorもテスト
            Iterator<Day> daysIterator = month.getDays();
            for (int j = 0; j < max; j++) {
                daysIterator.next();
            }
            assertFalse(daysIterator.hasNext());
        }
    }
    
    public void test日にちを順に取得できる() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2013, 9 - 1, 1);
        
        Month month = new Month(calendar.getTime());
        Iterator<Day> iterator = month.getDays();
        for (int i = 0; i < 30; i++) { //2013年9月は30日まで
            Day day = iterator.next();
            assertEquals(Integer.valueOf(i + 1), Integer.valueOf(day.toInt()));
        }
    }
    
    public void test初日の曜日が取得できる() {
        doTest初日の曜日が取得できる(2013, 9, DayOfWeek.SUNDAY);
        doTest初日の曜日が取得できる(2013, 7, DayOfWeek.MONDAY);
        doTest初日の曜日が取得できる(2013, 1, DayOfWeek.TUESDAY);
        doTest初日の曜日が取得できる(2013, 5, DayOfWeek.WEDNESDAY);
        doTest初日の曜日が取得できる(2013, 8, DayOfWeek.THURSDAY);
        doTest初日の曜日が取得できる(2013,11, DayOfWeek.FRIDAY);
        doTest初日の曜日が取得できる(2013, 6, DayOfWeek.SATURDAY);
    }
    private void doTest初日の曜日が取得できる(int year, int month, DayOfWeek expected) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        Month monthObj = new Month(calendar.getTime());
        assertEquals(expected, monthObj.getFirstDayOfWeek());
    }
    
}
