package com.tech_tec.android.simplecalendar.activity.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CalendarFragmentPagerAdapter extends FragmentPagerAdapter {
    
    static final int MAX_PAGE_NUM = 10000;
    
    public CalendarFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return MAX_PAGE_NUM;
    }

}
