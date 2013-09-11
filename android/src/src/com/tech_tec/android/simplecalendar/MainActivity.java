package com.tech_tec.android.simplecalendar;

import com.tech_tec.android.simplecalendar.fragment.calendar.CalendarFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ViewPager pager = (ViewPager)findViewById(R.id.pager_calendar);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            
            @Override
            public int getCount() {
                return 3;
            }
            
            @Override
            public Fragment getItem(int arg0) {
                return new CalendarFragment();
            }
        });
    }
    
}
