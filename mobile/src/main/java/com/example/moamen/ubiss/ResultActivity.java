package com.example.moamen.ubiss;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    public static int userResult;
    public static int myoResult;
    public TextView textView;
    public TextView myoTextView;
    private CanvasView canvasView;
    public static volatile String resultFromMyo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //canvasView = (CanvasView) findViewById(R.id.canvas);
        textView = (TextView) findViewById(R.id.textView4);
        textView.setText(Integer.toString(userResult));
        myoTextView = (TextView) findViewById(R.id.textView5);
        myoTextView.setText(Integer.toString(myoResult));
        Log.println(Log.INFO, "userErrNew", Integer.toString(userResult));
        Log.println(Log.INFO, "myoErrNew", Integer.toString(myoResult));
        resultFromMyo = Integer.toString(myoResult);
        Log.println(Log.INFO, "myoErrNew-string", resultFromMyo);

    }

    public void saveData(View view) {
        final Intent intent = new Intent(this, GraphActivity.class);

        // Save data
        SharedPreferences prefs = getSharedPreferences("PREF", MODE_PRIVATE);
        String drawingRes = prefs.getString("drawing", "");
        String myoRes = prefs.getString("myo", "");

        if (drawingRes == ""){
            SharedPreferences.Editor editor = getSharedPreferences("PREF", MODE_PRIVATE).edit();
            editor.putString("myo", resultFromMyo);
            editor.apply();
            editor.putString("drawing", Integer.toString(userResult));
            editor.apply();

        }
        else{
            SharedPreferences.Editor editor = getSharedPreferences("PREF", MODE_PRIVATE).edit();
            editor.putString("drawing", drawingRes + "," + Integer.toString(userResult));
            editor.apply();
            Log.println(Log.INFO, "myoAdd", resultFromMyo);
            editor.putString("myo", myoRes + "," + resultFromMyo);
            editor.apply();
        }

//        // Save Myo data
//        SharedPreferences myoPrefs = getSharedPreferences("MyoPREF", MODE_PRIVATE);
//        String myoRes = myoPrefs.getString("myo", "");
//
//        if (myoRes == ""){
//            SharedPreferences.Editor editor = getSharedPreferences("MyoPREF", MODE_PRIVATE).edit();
//            editor.putString("myo", Integer.toString(myoResult));
//            editor.apply();
//        }
//        else{
//            SharedPreferences.Editor editor = getSharedPreferences("MyoPREF", MODE_PRIVATE).edit();
//            editor.putString("myo", myoRes + "," + Integer.toString(myoResult));
//            editor.apply();
//        }
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setTitle("Successfully saved data, Want to see your history?")
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                startActivity(intent);
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();

    }

    public void createGraph(View view) {
        Intent intent = new Intent(this, GraphActivity.class);
        startActivity(intent);
    }
}
