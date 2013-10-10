package com.tech_tec.android.simplecalendar.activity.main;

import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tech_tec.android.simplecalendar.fragment.calendar.CalendarFragment;

class CalendarFragmentPagerAdapter extends FragmentPagerAdapter {
    
    private Date mBaseDate = new Date();

    public CalendarFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(CalendarFragment.ARG_BASIS_DATE, getDate(position));
        
        CalendarFragment fragment = new CalendarFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 12;
    }
    
    @Override
    public CharSequence getPageTitle(int position) {
        Date date = getDate(position);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1);
    }
    
    private Date getDate(int position) {
        int midIndex = getCount() / 2;
        int monthIndex = position - midIndex;
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mBaseDate);
        calendar.add(Calendar.MONTH, monthIndex);
        return calendar.getTime();
    }

}
