package com.tech_tec.android.simplecalendar.view;

import com.tech_tec.android.simplecalendar.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CellAdapter extends ArrayAdapter<String> {
    
    private LayoutInflater mInflater;
    
    public CellAdapter(Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.layout_cell, null);
        
        TextView textView = (TextView)view.findViewById(R.id.date);
        textView.setText(getItem(position));
        
        return view;
    }
    
}
