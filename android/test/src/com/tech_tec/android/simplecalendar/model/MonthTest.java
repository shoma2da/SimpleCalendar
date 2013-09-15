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
    
}
