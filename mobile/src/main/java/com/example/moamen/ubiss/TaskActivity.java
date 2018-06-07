package com.example.moamen.ubiss;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


public class TaskActivity extends AppCompatActivity {

    private CanvasView canvasView;
    View view;
    final int[] loc = new int[2];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        canvasView = (CanvasView) findViewById(R.id.canvas);
        view = (View) findViewById(R.id.view);
        CanvasView.userError = 0f;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        view.getLocationOnScreen(loc);
        Log.println(Log.INFO, "ourX", Integer.toString(loc[0]));

        CanvasView.ourX = loc[0];
        CanvasView.ourY = view.getBottom();

    }

}
