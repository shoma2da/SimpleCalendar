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
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position < COLUMN_NUMBER) {
            View view = mInflater.inflate(R.layout.layout_header, null);
            TextView textView = (TextView)view.findViewById(R.id.text);
            
            switch (position) {
            case 0:
                textView.setText("月");
                break;
            case 1:
                textView.setText("火");
                break;
            case 2:
                textView.setText("水");
                break;
            case 3:
                textView.setText("木");
                break;
            case 4:
                textView.setText("金");
                break;
            case 5:
                textView.setText("土");
                break;
            case 6:
                textView.setText("日");
                break;
            default:
                break;
            }
            
            return view;
        }
        
        View view = mInflater.inflate(R.layout.layout_cell, null);
        
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(
                mGridView.getWidth() / COLUMN_NUMBER,
                mGridView.getHeight() / ROW_NUMBER);
        view.setLayoutParams(params);
        
        TextView textView = (TextView)view.findViewById(R.id.date);
        textView.setText(getItem(position));
        
        return view;
    }
    
}
