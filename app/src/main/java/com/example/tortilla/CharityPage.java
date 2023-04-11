package com.example.tortilla;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class CharityPage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);


        View view= inflater.inflate(R.layout.charity_page,container,false);

        BarChart chart = view.findViewById(R.id.barchart);

        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new BarEntry(22, 6));
        NoOfEmp.add(new BarEntry(65, 5));
        NoOfEmp.add(new BarEntry(35, 4));
        NoOfEmp.add(new BarEntry(40, 3));
        NoOfEmp.add(new BarEntry(56, 2));
        NoOfEmp.add(new BarEntry(65, 1));
        NoOfEmp.add(new BarEntry(77, 0));

        ArrayList year = new ArrayList();

        year.add("Monday");
        year.add("Tuesday");
        year.add("Wednesday");
        year.add("Thursday");
        year.add("Friday");
        year.add("Saturday");
        year.add("Sunday");

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "Daily Charity Update");
        chart.animateY(1000);
        BarData data = new BarData(year, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);


        return view;
    }
}


