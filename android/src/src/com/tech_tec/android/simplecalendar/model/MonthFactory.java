package com.tech_tec.android.simplecalendar.model;

import java.util.Date;

public class MonthFactory {
    
    private Date mBasisDate;
    
    public MonthFactory(Date basisDate) {
        mBasisDate = basisDate;
    }
    
    public Month createMonth() {
        return new Month(mBasisDate);
    }
    
}
