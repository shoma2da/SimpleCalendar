package com.tech_tec.android.simplecalendar.test;

import android.content.Context;
import android.test.AndroidTestCase;
import android.view.View;
import android.widget.GridView;

import com.tech_tec.android.simplecalendar.view.CellAdapter;
import com.tech_tec.android.simplecalendar.view.HeaderView;

public class CellAdapterTest extends AndroidTestCase {
    
    public void test最初から曜日分のデータが入っている() {
        Context context = getContext();
        CellAdapter adapter = new CellAdapter(context, new GridView(context));
        
        assertEquals(CellAdapter.COLUMN_NUMBER, adapter.getCount());
    }
    
    public void testはじめの規定個数は曜日が取得できる() {
        Context context = getContext();
        CellAdapter adapter = new CellAdapter(context, new GridView(context));
        
        for (int i = 0; i < CellAdapter.COLUMN_NUMBER; i++) {
            View view = adapter.getView(i, null, null);
            assertEquals(HeaderView.class, view.getClass());
        }
    }
}
