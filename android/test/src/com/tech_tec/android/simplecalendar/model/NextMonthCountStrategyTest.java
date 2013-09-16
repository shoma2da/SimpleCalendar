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
    private void doTest曜日に応じて前月の日にちカウントを取得できる(int year, int month, int expected) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        
        NextMonthCountStrategy strategy = new NextMonthCountStrategy(new Month(calendar.getTime()));
        assertEquals(expected, strategy.getPreviousMonthCount());
    }
    
    public void test前月と今月の日数によって次月のカウントを取得できる() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 0, 1);
        for (int i = 0; i < 200 * 12; i++) { //200年分をテスト
            Month month = new Month(calendar.getTime());
            NextMonthCountStrategy strategy = new NextMonthCountStrategy(month);
            assertEquals(7 * 6, month.daysSize() + strategy.getNextMonthCount() + strategy.getPreviousMonthCount());
            
            calendar.add(Calendar.MONTH, 1);
        }
    }
}
