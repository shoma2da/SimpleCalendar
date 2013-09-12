package com.tech_tec.android.simplecalendar.activity.main;

import java.util.Date;

import android.support.v4.app.FragmentActivity;
import android.test.AndroidTestCase;

import com.tech_tec.android.simplecalendar.fragment.calendar.CalendarFragment;

public class CalendarFragmentPagerAdapterTest extends AndroidTestCase {
    
    private CalendarFragmentPagerAdapter mAdapter;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        FragmentActivity activity = new FragmentActivity();
        mAdapter = new CalendarFragmentPagerAdapter(activity.getSupportFragmentManager(), new Date());
    }
    
    public void test最大サイズがとても大きい() {
        int max = CalendarFragmentPagerAdapter.MAX_PAGE_NUM;
        assertEquals(max, mAdapter.getCount());
    }
    
    public void test真ん中のポジションが今月を表す() {
        int half = CalendarFragmentPagerAdapter.MAX_PAGE_NUM / 2;
        CalendarFragment fragment = (CalendarFragment)mAdapter.getItem(half);
        //TODO 実装途中
        assertTrue(false);
    }
    
}
