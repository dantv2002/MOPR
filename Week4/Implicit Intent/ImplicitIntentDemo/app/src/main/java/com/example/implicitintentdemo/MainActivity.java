package com.example.implicitintentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchWebPagebuttonClicked(View v){
        Log.i("Btn", "Clicked");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fhqx.hcmute.edu.vn/"));
        startActivity(intent);
    }
}