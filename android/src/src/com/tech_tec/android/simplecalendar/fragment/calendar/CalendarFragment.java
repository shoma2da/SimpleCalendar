package com.tech_tec.android.simplecalendar.fragment.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.tech_tec.android.simplecalendar.R;
import com.tech_tec.android.simplecalendar.model.Day;
import com.tech_tec.android.simplecalendar.model.DayOfWeek;
import com.tech_tec.android.simplecalendar.model.Month;
import com.tech_tec.android.simplecalendar.model.MonthFactory;
import com.tech_tec.android.simplecalendar.model.NextMonth;
import com.tech_tec.android.simplecalendar.model.NextMonthCountStrategy;
import com.tech_tec.android.simplecalendar.model.PreviousMonth;
import com.tech_tec.android.simplecalendar.view.DayView;

public class CalendarFragment extends Fragment {
    
    public static final String ARG_BASIS_TIME_IN_MILLIS = "basis_time_in_millis";
    
    public CalendarFragment() { }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, null);
        
        //TODO 仮実装→未テスト
        MonthFactory factory = new MonthFactory(new Date(), new NextMonthCountStrategy());
        Month month = factory.createMonth();
        PreviousMonth previousMonth = factory.createPreviousMonth();
        NextMonth nextMonth = factory.createNextMonth();
        
        ArrayList<DayView> dayTexts = new ArrayList<DayView>();
        
        TableLayout daysTable = (TableLayout)view.findViewById(R.id.table_days);
        int weekCount = daysTable.getChildCount();
        for (int i = 0; i < weekCount; i++) {
            TableRow weekLayout = (TableRow)daysTable.getChildAt(i);
            int dayCount = weekLayout.getChildCount();
            
            for (int j = 0; j < dayCount; j++) {
                DayView daysText = (DayView)weekLayout.getChildAt(j);
                dayTexts.add(daysText);
            }
        }
        
        Iterator<DayView> textIterator = dayTexts.iterator();
        
        Iterator<Day> prevIterator = previousMonth.getDays();
        while (prevIterator.hasNext()) {
            DayView textView = textIterator.next();
            Day day = prevIterator.next();
            
            textView.setText("" + day.toInt());
            textView.setPreviousOrNext();
        }
        
        Iterator<Day> iterator = month.getDays();
        while (iterator.hasNext()) {
            DayView textView = textIterator.next();
            Day day = iterator.next();
            
            textView.setText("" + day.toInt());
            if (day.getDayOfWeek() == DayOfWeek.SUNDAY) {
                textView.setSunday();
            } else if (day.getDayOfWeek() == DayOfWeek.SATURDAY) {
                textView.setSaturday();
            }
        }
        
        Iterator<Day> nextIterator = nextMonth.getDays();
        while (nextIterator.hasNext()) {
            DayView textView = textIterator.next();
            Day day = nextIterator.next();
            
            textView.setText("" + day.toInt());
            textView.setPreviousOrNext();
        }
        //------------
        
        return view;
    }
    
}
