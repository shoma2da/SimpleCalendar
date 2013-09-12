package com.tech_tec.android.simplecalendar.activity.main;

import android.support.v4.app.FragmentActivity;
import android.test.AndroidTestCase;

public class CalendarFragmentPagerAdapterTest extends AndroidTestCase {
    
    private CalendarFragmentPagerAdapter mAdapter;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        FragmentActivity activity = new FragmentActivity();
        mAdapter = new CalendarFragmentPagerAdapter(activity.getSupportFragmentManager());
    }
    
    public void test最大サイズがとても大きい() {
        int max = CalendarFragmentPagerAdapter.MAX_PAGE_NUM;
        assertEquals(max, mAdapter.getCount());
    }
    
}
