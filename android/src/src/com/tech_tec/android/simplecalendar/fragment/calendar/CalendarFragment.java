package com.tech_tec.android.simplecalendar.fragment.calendar;

import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.tech_tec.android.simplecalendar.R;
import com.tech_tec.android.simplecalendar.model.Month;
import com.tech_tec.android.simplecalendar.view.CellAdapter;

public class CalendarFragment extends Fragment {
    
    public static final String ARG_BASIS_TIME_IN_MILLIS = "basis_time_in_millis";
    
    public CalendarFragment() { }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, null);
        
        long timeInMillis = getArguments().getLong(ARG_BASIS_TIME_IN_MILLIS);
        Date date = new Date(timeInMillis);
        Month month = new Month(date);
        
        GridView gridView = (GridView)view.findViewById(R.id.calendar);
        CellAdapter adapter = new CellAdapter(getActivity(), gridView);
        gridView.setAdapter(adapter);
        adapter.setMonth(month);
        
        ActionBarActivity actionBarActivity = ((ActionBarActivity)getActivity());
        actionBarActivity.setTitle(month.getYear() + "/" + month.getMonth());
        
        return view;
    }
    
}
