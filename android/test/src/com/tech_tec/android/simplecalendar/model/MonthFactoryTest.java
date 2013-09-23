package com.tech_tec.android.simplecalendar.model;

import static org.mockito.Mockito.mock;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class MonthFactoryTest extends TestCase {
    
    public void testMonthの生成() {
        doTestMonthの生成(2013, 9, 30);
        doTestMonthの生成(2013, 10, 31);
    }
    public void doTestMonthの生成(int year, int monthValue, int expectedDateSize) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthValue-1, 1); //月は-1する
        
        MonthFactory factory = new MonthFactory(calendar.getTime(), mock(NextMonthCountStrategy.class));
        Month month = factory.createMonth();
        
        assertEquals(expectedDateSize, month.daysSize());
    }
    
    public void testPreviousMonthの生成() {
        MonthFactory factory = new MonthFactory(new Date(), mock(NextMonthCountStrategy.class));
        PreviousMonth previousMonth = factory.createPreviousMonth();
        
        assertNotNull(previousMonth);
    }
    
    public void testNextMonthの生成() {
        MonthFactory factory = new MonthFactory(new Date(), mock(NextMonthCountStrategy.class));
        NextMonth nextMonth = factory.createNextMonth();
        
        assertNotNull(nextMonth);
    }
    
}
