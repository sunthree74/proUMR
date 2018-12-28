package tk.sunthree.upahku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Chart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        setTitle("UMR Apps");

        BarChart chart = (BarChart) findViewById(R.id.barchart);

        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new BarEntry(2008, 945f));
        NoOfEmp.add(new BarEntry(2009, 1040f));
        NoOfEmp.add(new BarEntry(2010, 1133f));
        NoOfEmp.add(new BarEntry(2011, 1240f));
        NoOfEmp.add(new BarEntry(2012, 1369f));
        NoOfEmp.add(new BarEntry(2013, 1487f));
        NoOfEmp.add(new BarEntry(2014, 1501f));

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "UMR Per Tahun");
        chart.animateXY(2000, 2000);
        BarData data = new BarData(bardataset);

        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.invalidate(); // refresh
        data.setBarWidth(0.9f); // set custom bar width

    }
}
