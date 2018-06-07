package com.example.moamen.ubiss;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    public static int userResult;
    public  static  double myoResult;
    public TextView textView;
    private CanvasView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //canvasView = (CanvasView) findViewById(R.id.canvas);
        textView = (TextView) findViewById(R.id.textView4);
        textView.setText(Integer.toString(userResult));
        Log.println(Log.INFO, "userErrNew", Float.toString(userResult));
        Log.println(Log.INFO, "myoErrNew", Double.toString(myoResult));
    }

    public void saveData(View view) {
        // Save data
        SharedPreferences prefs = getSharedPreferences("PREF", MODE_PRIVATE);
        String drawingRes = prefs.getString("drawing", "");

        if (drawingRes == ""){
            SharedPreferences.Editor editor = getSharedPreferences("PREF", MODE_PRIVATE).edit();
            editor.putString("drawing", Integer.toString(userResult));
            editor.apply();
        }
        else{
            SharedPreferences.Editor editor = getSharedPreferences("PREF", MODE_PRIVATE).edit();
            editor.putString("drawing", drawingRes + "," + Integer.toString(userResult));
            editor.apply();
        }
    }

    public void createGraph(View view) {
        Intent intent = new Intent(this, GraphActivity.class);
        startActivity(intent);
    }
}
