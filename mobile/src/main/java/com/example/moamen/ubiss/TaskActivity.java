package com.example.moamen.ubiss;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class TaskActivity extends AppCompatActivity {
<<<<<<< HEAD
   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
                  super.onCreate(savedInstanceState);
                   setContentView(R.layout.activity_task);
              }
    }
=======
    private CanvasView canvasView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        canvasView = (CanvasView) findViewById(R.id.canvas);
    }


}
>>>>>>> 39e7551da5d0587d89964f4c7c907ce27d7744ee
