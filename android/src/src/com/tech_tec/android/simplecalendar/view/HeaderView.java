package com.tech_tec.android.simplecalendar.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tech_tec.android.simplecalendar.R;

public class HeaderView extends LinearLayout {
    
    public HeaderView(Context context) {
        super(context);
    }
    
    public HeaderView(Context context, int index) {
        super(context);
        
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.layout_header, this);
        
        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(getText(context, index));
    }
    
    String getText(Context context, int index) throws ArrayIndexOutOfBoundsException {
        String[] days = context.getResources().getStringArray(R.array.days);
        return days[index];
    }
    
}
