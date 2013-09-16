package com.tech_tec.android.simplecalendar.model;

import java.util.Calendar;

import junit.framework.TestCase;

public class NextMonthCountStrategyTest extends TestCase {
    
    public void test曜日に応じて前月の日にちカウントを取得できる() {
        doTest曜日に応じて前月の日にちカウントを取得できる(2013, 9, 7); //1日が日曜日
        doTest曜日に応じて前月の日にちカウントを取得できる(2013, 7, 1); //1日が月曜日
        doTest曜日に応じて前月の日にちカウントを取得できる(2013, 1, 2); //1日が火曜日
        doTest曜日に応じて前月の日にちカウントを取得できる(2013, 5, 3);
        doTest曜日に応じて前月の日にちカウントを取得できる(2013, 8, 4);
        doTest曜日に応じて前月の日にちカウントを取得できる(2013, 11, 5);
        doTest曜日に応じて前月の日にちカウントを取得できる(2013, 6, 6);
    }
    public void doTest曜日に応じて前月の日にちカウントを取得できる(int year, int month, int expected) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        
        NextMonthCountStrategy strategy = new NextMonthCountStrategy(new Month(calendar.getTime()));
        assertEquals(expected, strategy.getPreviousMonthCount());
    }
    
}
