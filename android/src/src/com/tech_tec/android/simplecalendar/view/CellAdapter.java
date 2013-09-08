package com.tech_tec.android.simplecalendar.view;

import java.util.Iterator;

import com.tech_tec.android.simplecalendar.R;
import com.tech_tec.android.simplecalendar.model.Day;
import com.tech_tec.android.simplecalendar.model.Month;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class CellAdapter extends ArrayAdapter<Day> {
    
    public static int COLUMN_NUMBER = 7;
    public static int ROW_NUMBER = 6;
    
    private LayoutInflater mInflater;
    private GridView mGridView;
    
    public CellAdapter(Context context, GridView gridView) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
        mGridView = gridView;
        
        for (int i = 0; i < COLUMN_NUMBER; i++) {
            add(null);
        }
    }
    
    public void setMonth(Month month) {
        addDay(month.getPreviousDays());
        addDay(month.getDays());
        addDay(month.getNextDays());
    }
    void addDay(Iterator<Day> dayIterator) {
        while (dayIterator.hasNext()) {
            add(dayIterator.next());
        }
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position < COLUMN_NUMBER) {
            return new HeaderView(getContext(), position);
        }
        
        View view = mInflater.inflate(R.layout.layout_cell, null);
        
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(
                mGridView.getWidth() / COLUMN_NUMBER,
                mGridView.getHeight() / ROW_NUMBER);
        view.setLayoutParams(params);
        
        TextView textView = (TextView)view.findViewById(R.id.date);
        textView.setText(getItem(position).getDayValue().toInt().toString());
        
        return view;
    }
    
}
