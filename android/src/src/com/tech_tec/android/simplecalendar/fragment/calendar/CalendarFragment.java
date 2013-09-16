package com.tech_tec.android.simplecalendar.fragment.calendar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tech_tec.android.simplecalendar.R;

public class CalendarFragment extends Fragment {
    
    public static final String ARG_BASIS_TIME_IN_MILLIS = "basis_time_in_millis";
    
    public CalendarFragment() { }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, null);
        return view;
    }
    
}
