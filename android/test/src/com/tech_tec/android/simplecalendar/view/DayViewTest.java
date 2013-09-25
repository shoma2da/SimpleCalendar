package com.tech_tec.android.simplecalendar.view;

import android.test.AndroidTestCase;

public class DayViewTest extends AndroidTestCase {
    
    public void testオブジェクトの生成() {
        DayView dayView = new DayView(getContext());
        assertNotNull(dayView);
    }
    
}
