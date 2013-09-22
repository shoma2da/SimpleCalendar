package com.tech_tec.android.simplecalendar.fragment.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.w3c.dom.Text;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.tech_tec.android.simplecalendar.R;
import com.tech_tec.android.simplecalendar.model.Day;
import com.tech_tec.android.simplecalendar.model.Month;
import com.tech_tec.android.simplecalendar.model.MonthFactory;
import com.tech_tec.android.simplecalendar.model.NextMonth;
import com.tech_tec.android.simplecalendar.model.NextMonthCountStrategy;
import com.tech_tec.android.simplecalendar.model.PreviousMonth;

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
        
        ArrayList<TextView> dayTexts = new ArrayList<TextView>();
        
        TableLayout daysTable = (TableLayout)view.findViewById(R.id.table_days);
        int weekCount = daysTable.getChildCount();
        for (int i = 0; i < weekCount; i++) {
            TableRow weekLayout = (TableRow)daysTable.getChildAt(i);
            int dayCount = weekLayout.getChildCount();
            
            for (int j = 0; j < dayCount; j++) {
                TextView daysText = (TextView)weekLayout.getChildAt(j);
                dayTexts.add(daysText);
            }
        }
        
        Iterator<TextView> textIterator = dayTexts.iterator();
        
        Iterator<Day> prevIterator = previousMonth.getDays();
        while (prevIterator.hasNext()) {
            TextView textView = textIterator.next();
            textView.setText("" + prevIterator.next().toInt());
            Log.d("simple", "prev");
        }
        
        Iterator<Day> iterator = month.getDays();
        while (iterator.hasNext()) {
            TextView textView = textIterator.next();
            textView.setText("" + iterator.next().toInt());
            Log.d("simple", "this");
        }
        
        Iterator<Day> nextIterator = nextMonth.getDays();
        while (nextIterator.hasNext()) {
            TextView textView = textIterator.next();
            textView.setText("" + nextIterator.next().toInt());
            Log.d("simple", "next");
        }
        //------------
        
        return view;
    }
    
}
