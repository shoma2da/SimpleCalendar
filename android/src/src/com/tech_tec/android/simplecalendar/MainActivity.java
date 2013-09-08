package com.tech_tec.android.simplecalendar;

import java.util.Calendar;

import com.tech_tec.android.simplecalendar.model.Day;
import com.tech_tec.android.simplecalendar.view.CellAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        GridView gridView = (GridView)findViewById(R.id.calendar);
        CellAdapter adapter = new CellAdapter(this, gridView);
        gridView.setAdapter(adapter);
        
        Calendar calendar = Calendar.getInstance();
        int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        for (int i = 0; i < max; i++) {
            Day day = new Day(calendar.getTime());
            adapter.add(day);

            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
    }

}
