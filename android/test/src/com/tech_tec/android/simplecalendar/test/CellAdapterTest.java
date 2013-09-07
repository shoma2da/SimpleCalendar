package com.tech_tec.android.simplecalendar.test;

import com.tech_tec.android.simplecalendar.view.CellAdapter;

import android.content.Context;
import android.test.AndroidTestCase;
import android.widget.GridView;

public class CellAdapterTest extends AndroidTestCase {
    
    public void test最初から曜日分のデータが入っている() {
        Context context = getContext();
        CellAdapter adapter = new CellAdapter(context, new GridView(context));
        
        assertEquals(CellAdapter.COLUMN_NUMBER, adapter.getCount());
    }
    
}
