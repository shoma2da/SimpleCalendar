package com.tech_tec.android.simplecalendar.view;

import com.tech_tec.android.simplecalendar.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class CellAdapter extends ArrayAdapter<String> {
    
    public static int ROW_NUMBER = 6;
    
    private LayoutInflater mInflater;
    private GridView mGridView;
    
    public CellAdapter(Context context, GridView gridView) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
        mGridView = gridView;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.layout_cell, null);
        
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                mGridView.getHeight() / ROW_NUMBER);
        view.setLayoutParams(params);
        
        TextView textView = (TextView)view.findViewById(R.id.date);
        textView.setText(getItem(position));
        
        return view;
    }
    
}
