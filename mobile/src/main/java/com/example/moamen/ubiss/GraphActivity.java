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
    String[] drawingResStr, myoResStr;
    GraphView graph,graphMyo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        graph = (GraphView) findViewById(R.id.graph);
        graphMyo = (GraphView) findViewById(R.id.myograph);

        loadData();
        createGraph();
    }

    public void loadData() {
        SharedPreferences prefs = getSharedPreferences("PREF", MODE_PRIVATE);
        String drawingRes = prefs.getString("drawing", "");
        drawingResStr = drawingRes.split(",");
        Log.println(Log.INFO, "RES", drawingRes);

        String myoRes = prefs.getString("myo", "");
        myoResStr = myoRes.split(",");
        Log.println(Log.INFO, "RES-draw-myo", myoRes);

//        SharedPreferences myoPrefs = getSharedPreferences("MyoPREF", MODE_PRIVATE);
//        String myoRes = myoPrefs.getString("myo", "");
//        myoResStr = myoRes.split(",");
//        Log.println(Log.INFO, "RES-myo", myoRes);
    }

    public void createGraph() {
        // drawing data
        int len = drawingResStr.length;
        DataPoint[] data = new DataPoint[len];
        for (int i=0; i<len; ++i) {
            data[i] = new DataPoint(i+1, Integer.parseInt(drawingResStr[i]));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(data);
        graph.addSeries(series);

        // myo data
        int lenMyo = myoResStr.length;
        DataPoint[] dataMyo = new DataPoint[lenMyo];
        for (int i=0; i<lenMyo; ++i) {
            dataMyo[i] = new DataPoint(i+1, Integer.parseInt(myoResStr[i]));
        }
        LineGraphSeries<DataPoint> seriesMyo = new LineGraphSeries<>(dataMyo);
        graphMyo.addSeries(seriesMyo);
    }

    public void clearHistory(View view) {
        SharedPreferences prefs = getSharedPreferences("PREF", MODE_PRIVATE);
        prefs.edit().remove("drawing").commit();

        SharedPreferences myoPrefs = getSharedPreferences("myoPREF", MODE_PRIVATE);
        myoPrefs.edit().remove("myo").commit();
    }
}
