package com.java.curvicgraphsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.broooapps.graphview.CurveGraphConfig;
import com.broooapps.graphview.CurveGraphView;
import com.broooapps.graphview.models.GraphData;
import com.broooapps.graphview.models.PointMap;

public class MainActivity extends AppCompatActivity {
    CurveGraphView curveGraphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        curveGraphView = findViewById(R.id.cgv);

        curveGraphView.configure(
                new CurveGraphConfig.Builder(this)
                        .setAxisColor(R.color.Blue)   // Set X and Y axis line color stroke.
                        .setIntervalDisplayCount(10)   // Set number of values to be displayed in X ax
//                        .setGuidelineCount(2)    // Set number of background guidelines to be shown.
//                        .setHorizontalGuideline(2)
//                        .setGuidelineColor(R.color.GreenYellow)   // Set color of the visible guidelines.
                        .setNoDataMsg(" No Data ")    // Message when no data is provided to the view.
                        .setxAxisScaleTextColor(R.color.Black)   // Set X axis scale text color.
                        .setyAxisScaleTextColor(R.color.Black)   // Set Y axis scale text color
                        .setAnimationDuration(3000)   // Set animation duration to be used after set data.
                        .build()
        );


        PointMap pointMap = new PointMap();
        pointMap.addPoint(0, 100);
        pointMap.addPoint(1, 500);
        pointMap.addPoint(2, 300);
        pointMap.addPoint(3, 50);
        pointMap.addPoint(4, 200);
        pointMap.addPoint(5, 900);

        GraphData gd = GraphData.builder(this)
                .setPointMap(pointMap)   // PointMap data
                .setGraphStroke(R.color.design_default_color_error)  // Graph line stroke color
                .setGraphGradient(R.color.Aqua, R.color.AntiqueWhite)  // Graph fill gradient color
//                .setStraightLine(true)   // true for straight line; false for curved line graph
//                .setPointRadius(5)  // set point radius
                .setPointColor(R.color.design_default_color_error)  // set point color
                .animateLine(true)   // Trigger animation for the particular graph line!
                .build();

        PointMap p2 = new PointMap();
        p2.addPoint(0, 140);
        p2.addPoint(1, 700);
        p2.addPoint(2, 100);
        p2.addPoint(3, 0);
        p2.addPoint(4, 190);

        GraphData gd2 = GraphData.builder(this)
                .setPointMap(p2)   // PointMap data
                .setGraphStroke(R.color.design_default_color_error)  // Graph line stroke color
                .setGraphGradient(R.color.gradientStartColor, R.color.gradientEndColor)  // Graph fill gradient color
//                .setStraightLine(true)   // true for straight line; false for curved line graph
//                .setPointRadius(5)  // set point radius
                .setPointColor(R.color.design_default_color_error)  // set point color
                .animateLine(true)   // Trigger animation for the particular graph line!
                .build();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                curveGraphView.setData(5, 1000, gd, gd2);
//                curveGraphView.setData(5, 1000, gd);
            }
        }, 250);


    }
}