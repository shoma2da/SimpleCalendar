package com.tech_tec.android.simplecalendar.test;

import com.tech_tec.android.simplecalendar.R;
import com.tech_tec.android.simplecalendar.view.HeaderView;

import android.test.AndroidTestCase;
import android.widget.TextView;

public class HeaderViewTest extends AndroidTestCase {
    
    public void test表示文字列が正しいか() {
        String[] days = getContext().getResources().getStringArray(R.array.days);
        doTest表示文字列が正しいか(0, days[0]);
        doTest表示文字列が正しいか(1, days[1]);
        doTest表示文字列が正しいか(2, days[2]);
        doTest表示文字列が正しいか(3, days[3]);
        doTest表示文字列が正しいか(4, days[4]);
        doTest表示文字列が正しいか(5, days[5]);
        doTest表示文字列が正しいか(6, days[6]);
    }
    private void doTest表示文字列が正しいか(int index, String expected) {
        HeaderView headerView = new HeaderView(getContext(), index);
        TextView textView = (TextView)headerView.findViewById(R.id.text);
        assertEquals(expected, textView.getText().toString());
    }
    
    public void test範囲外のindexでは例外が飛ぶ() {
        doTest範囲外のindexでは例外が飛ぶ(-1);
        doTest範囲外のindexでは例外が飛ぶ(7);
    }
    private void doTest範囲外のindexでは例外が飛ぶ(int index) {
        try {
            new HeaderView(getContext(), index);
            fail("例外が飛ぶはず");
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
    
}
