package com.tech_tec.android.simplecalendar;

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
        ArrayAdapter<String> adapter = new CellAdapter(this);
        gridView.setAdapter(adapter);
        
        for (int i = 0; i < 31; i++) {
            adapter.add("" + (i + 1));
        }
    }

}
