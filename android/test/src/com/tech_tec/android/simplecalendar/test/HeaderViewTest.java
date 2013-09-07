package com.tech_tec.android.simplecalendar.test;

import com.tech_tec.android.simplecalendar.R;
import com.tech_tec.android.simplecalendar.view.HeaderView;

import android.test.AndroidTestCase;
import android.widget.TextView;

public class HeaderViewTest extends AndroidTestCase {
    
    public void test表示文字列が正しいか() {
        doTest表示文字列が正しいか(0, "日");
        doTest表示文字列が正しいか(1, "月");
        doTest表示文字列が正しいか(2, "火");
        doTest表示文字列が正しいか(3, "水");
        doTest表示文字列が正しいか(4, "木");
        doTest表示文字列が正しいか(5, "金");
        doTest表示文字列が正しいか(6, "土");
    }
    private void doTest表示文字列が正しいか(int index, String expected) {
        HeaderView headerView = new HeaderView(getContext(), index);
        TextView textView = (TextView)headerView.findViewById(R.id.text);
        assertEquals(expected, textView.getText().toString());
    }
    
}
