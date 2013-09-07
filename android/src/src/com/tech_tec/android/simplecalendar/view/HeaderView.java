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
    
    String getText(Context context, int index) {
        switch (index) {
            case 0:
                return "日";
            case 1:
                return "月";
            case 2:
                return "火";
            case 3:
                return "水";
            case 4:
                return "木";
            case 5:
                return "金";
            case 6:
                return "土";
            default:
                throw new IllegalArgumentException("曜日の対象外indexを渡している");
        }
    }
    
}
