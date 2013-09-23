package com.tech_tec.android.simplecalendar.model;

import java.util.Date;

public class MonthFactory {
    
    private Date mBasisDate;
    private Month mMonthCache;
    private NextMonthCountStrategy mStrategy;
    
    public MonthFactory(Date basisDate, NextMonthCountStrategy strategy) {
        mBasisDate = basisDate;
        mStrategy = strategy;
    }
    
    public Month createMonth() {
        if (mMonthCache == null) {
            mMonthCache = new Month(mBasisDate);
        }
        return mMonthCache;
    }
    
    public PreviousMonth createPreviousMonth() {
        return new PreviousMonth(mMonthCache, mStrategy.getPreviousMonthCount(mMonthCache));
    }
    
    public NextMonth createNextMonth() {
        return new NextMonth(mMonthCache, mStrategy.getNextMonthCount(mMonthCache));
    }
    
}
