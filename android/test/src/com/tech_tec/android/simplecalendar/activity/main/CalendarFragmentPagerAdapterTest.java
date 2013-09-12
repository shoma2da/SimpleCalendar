package com.tech_tec.android.simplecalendar.activity.main;

import android.support.v4.app.FragmentActivity;
import android.test.AndroidTestCase;

public class CalendarFragmentPagerAdapterTest extends AndroidTestCase {
    
    public void test最大サイズがとても大きい() {
        int max = CalendarFragmentPagerAdapter.MAX_PAGE_NUM;
        
        FragmentActivity activity = new FragmentActivity();
        CalendarFragmentPagerAdapter adapter = new CalendarFragmentPagerAdapter(activity.getSupportFragmentManager());
        
        assertEquals(max, adapter.getCount());
    }
    
}
