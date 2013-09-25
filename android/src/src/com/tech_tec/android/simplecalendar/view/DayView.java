package com.tech_tec.android.simplecalendar.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

public class DayView extends TextView {
    
    DayView(Context context) {
        super(context);
    }
    
    public DayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public void setSunday() {
        setTextColor(Color.RED);
    }
    
    public void setSaturday() {
        setTextColor(Color.BLUE);
    }
    
    public void setPreviousOrNext() {
        setBackgroundColor(Color.GRAY);
    }

}
