package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtDataIntent;
    private Button btnStartService;
    private Button btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.btn_start_service);
        btnStopService = findViewById(R.id.btn_stop_service);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStartService();
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStopService();
            }
        });

    }

    private void clickStopService() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    private void clickStartService() {
        Song song = new Song("Big city boy", "Van Dan", R.drawable.music_img, R.raw.music);
        Intent intent = new Intent(this, MyService.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("object_song", song);
        intent.putExtras(bundle);

        startService(intent);
    }
}