package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("onCreate", "From onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart", "From onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume", "From onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop", "From onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onRestart", "From onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy", "From onDestroy");
    }
}