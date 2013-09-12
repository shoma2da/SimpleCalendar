package com.tech_tec.android.simplecalendar.activity.main;

import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tech_tec.android.simplecalendar.fragment.calendar.CalendarFragment;

public class CalendarFragmentPagerAdapter extends FragmentPagerAdapter {
    
    static final int MAX_PAGE_NUM = 10000;
    
    private Date mBasisDate;
    
    public CalendarFragmentPagerAdapter(FragmentManager fm, Date basisDate) {
        super(fm);
        mBasisDate = basisDate;
    }

    @Override
    public Fragment getItem(int position) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.MONTH, position);
        
        return createCalendarFragment(calendar.getTime());
    }
    
    CalendarFragment createCalendarFragment(Date basisDate) {
        Bundle bundle = new Bundle();
        bundle.putLong(CalendarFragment.ARG_BASIS_TIME_IN_MILLIS, basisDate.getTime());
        
        CalendarFragment fragment = new CalendarFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return MAX_PAGE_NUM;
    }

}
