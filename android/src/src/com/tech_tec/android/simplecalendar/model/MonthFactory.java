package com.tech_tec.android.simplecalendar.model;

import java.util.Date;

public class MonthFactory {
    
    private Date mBasisDate;
    private Month mMonthCache;
    
    public MonthFactory(Date basisDate) {
        mBasisDate = basisDate;
    }
    
    public Month createMonth() {
        if (mMonthCache == null) {
            mMonthCache = new Month(mBasisDate);
        }
        return mMonthCache;
    }
    
}
