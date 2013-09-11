package com.tech_tec.android.simplecalendar;

import java.util.Calendar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;

import com.tech_tec.android.simplecalendar.fragment.calendar.CalendarFragment;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final ViewPager pager = (ViewPager)findViewById(R.id.pager_calendar);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            
            @Override
            public int getCount() {
                return 3;
            }
            
            @Override
            public Fragment getItem(int position) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.MONTH, position);
                
                Bundle bundle = new Bundle();
                bundle.putLong(CalendarFragment.ARG_BASIS_TIME_IN_MILLIS, calendar.getTime().getTime());
                
                Fragment fragment = new CalendarFragment();
                fragment.setArguments(bundle);
                return fragment;
            }
        });
        pager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                
            }
            
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
            
            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == ViewPager.SCROLL_STATE_SETTLING) {
                    int page = pager.getCurrentItem();

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.add(Calendar.MONTH, page);
                    getSupportActionBar().setTitle("ページ" + page + " " + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1));
                }
            }
        });
    }
    
}
