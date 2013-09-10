package com.tech_tec.android.simplecalendar;

import java.util.Date;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

import com.tech_tec.android.simplecalendar.model.Month;
import com.tech_tec.android.simplecalendar.view.CellAdapter;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        GridView gridView = (GridView)findViewById(R.id.calendar);
        CellAdapter adapter = new CellAdapter(this, gridView);
        gridView.setAdapter(adapter);
        adapter.setMonth(new Month(new Date()));
    }
    
}
