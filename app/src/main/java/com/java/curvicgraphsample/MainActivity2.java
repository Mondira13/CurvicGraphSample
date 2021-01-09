package com.java.curvicgraphsample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private LineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mLineChart = findViewById(R.id.linechart);
        setLineChart();
        setLineChartXAxis();
        setLineChartYAxis();
        setLineChartDataSetFunctionality();
        setLineChartAnimation();
    }

    /*
           set LineChart functionality
        */
    private void setLineChart() {
        mLineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        mLineChart.getLegend().setEnabled(false);
        mLineChart.getDescription().setEnabled(false);
        mLineChart.getAxisRight().setEnabled(false);
        mLineChart.setDrawBorders(true);
        mLineChart.setBorderWidth(0.5f);
        mLineChart.setScaleEnabled(false);
        mLineChart.invalidate();   //  it refresh the drawing
    }

    /*
         This is used to set LineChart X-axis functionality
     */
    private void setLineChartXAxis() {
        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(12);
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(11f);
        xAxis.setValueFormatter(new MyXAxisFormatter());
    }

    /*
         This is used to set LineChart Y-axis functionality
     */
    private void setLineChartYAxis() {
        YAxis leftAxis = mLineChart.getAxisLeft();
        leftAxis.setLabelCount(4);
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.setAxisMaxValue(20000);
        leftAxis.setAxisMinValue(0);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawLimitLinesBehindData(true); // limit lines are drawn behind data (and not on top)
    }

    /*
        set animation into line chart
     */
    private void setLineChartAnimation() {
        mLineChart.animateXY(2000, 2000);
    }



    /*
     This is used to set Data into X-axis  (Set here API data for X-axis)
 */
    class MyXAxisFormatter extends ValueFormatter {

        String[] months = {"Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar"};

        @Override
        public String getFormattedValue(float value) {
            return months[(int) value % months.length];
        }

    }


    /*
       set LineChart Data set functionality
   */
    private void setLineChartDataSetFunctionality() {
        final LineDataSet set1;
        ArrayList<Entry> yVals = setYAxisDataValues();
        set1 = new LineDataSet(yVals, "DataSet 1");  // create a dataset and give it a type
        set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set1.setCubicIntensity(0.2f);
        set1.setDrawFilled(true);
        set1.setDrawCircles(false);
        set1.setLineWidth(1f);
        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setFillColor(getResources().getColor(R.color.purple_200));
        set1.setFillAlpha(250);
        set1.setDrawHorizontalHighlightIndicator(false);
        set1.setDrawVerticalHighlightIndicator(false);
        set1.setDrawValues(true);
        set1.setValueTextSize(9f);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1); // add the datasets

        // set data
        LineData data = new LineData((dataSets));
        mLineChart.setData(data);
        mLineChart.invalidate();
    }

    /*
        This is used to set Data into Y-axis  (Set here API data for Y-axis)
    */
    private ArrayList<Entry> setYAxisDataValues() {
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        yVals.add(new Entry(0, 0));
        yVals.add(new Entry(1, 0));
        yVals.add(new Entry(2, 0));
        yVals.add(new Entry(3, 0));
        yVals.add(new Entry(4, 0));
        yVals.add(new Entry(5, 0));
        yVals.add(new Entry(6, 0));
        yVals.add(new Entry(7, 15278));
        yVals.add(new Entry(8, 0));
        yVals.add(new Entry(9, 0));
        yVals.add(new Entry(10, 0));
        yVals.add(new Entry(11, 0));
        return yVals;
    }



}