package com.example.moamen.ubiss;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends AppCompatActivity {
    String[] drawingResStr;
    GraphView graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        graph = (GraphView) findViewById(R.id.graph);
        loadData();
        createGraph();
    }

    public void loadData() {
        SharedPreferences prefs = getSharedPreferences("PREF", MODE_PRIVATE);
        String drawingRes = prefs.getString("drawing", "");
        drawingResStr = drawingRes.split(",");
        Log.println(Log.INFO, "RES", drawingRes);
    }

    public void createGraph() {

        int len = drawingResStr.length;
        DataPoint[] data = new DataPoint[len];
        for (int i=0; i<len; ++i) {
            data[i] = new DataPoint(i+1, Integer.parseInt(drawingResStr[i]));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(data);
        graph.addSeries(series);
    }

    public void clearHistory(View view) {
        SharedPreferences prefs = getSharedPreferences("PREF", MODE_PRIVATE);
        prefs.edit().remove("drawing").commit();
    }
}
