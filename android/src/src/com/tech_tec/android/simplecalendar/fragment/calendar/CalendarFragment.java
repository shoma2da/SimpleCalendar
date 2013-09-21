package com.tech_tec.android.simplecalendar.fragment.calendar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.tech_tec.android.simplecalendar.R;

public class CalendarFragment extends Fragment {
    
    public static final String ARG_BASIS_TIME_IN_MILLIS = "basis_time_in_millis";
    
    public CalendarFragment() { }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, null);
        
        //TODO 仮実装→未テスト
        TableLayout daysTable = (TableLayout)view.findViewById(R.id.table_days);
        int weekCount = daysTable.getChildCount();
        for (int i = 0; i < weekCount; i++) {
            TableRow weekLayout = (TableRow)daysTable.getChildAt(i);
            int dayCount = weekLayout.getChildCount();
            
            for (int j = 0; j < dayCount; j++) {
                TextView daysText = (TextView)weekLayout.getChildAt(j);
                daysText.setText("" + (i * 7 + j + 1));
            }
        }
        //------------
        
        return view;
    }
    
}
