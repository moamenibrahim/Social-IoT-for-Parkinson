package com.example.moamen.ubiss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    public static float userResult;
    public TextView textView;
    private CanvasView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //canvasView = (CanvasView) findViewById(R.id.canvas);
        textView = (TextView) findViewById(R.id.textView4);
        textView.setText(Float.toString(userResult));
        Log.println(Log.INFO, "userErrNew", Float.toString(userResult));
    }
}
