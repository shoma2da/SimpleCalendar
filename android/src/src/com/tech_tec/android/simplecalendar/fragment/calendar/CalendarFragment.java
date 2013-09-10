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
    
    public CalendarFragment() { }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, null);
        
        Month month = new Month(new Date());
        
        GridView gridView = (GridView)view.findViewById(R.id.calendar);
        CellAdapter adapter = new CellAdapter(getActivity(), gridView);
        gridView.setAdapter(adapter);
        adapter.setMonth(month);
        
        ActionBarActivity actionBarActivity = ((ActionBarActivity)getActivity());
        actionBarActivity.setTitle(month.getYear() + "/" + month.getMonth());
        
        return view;
    }
    
}
