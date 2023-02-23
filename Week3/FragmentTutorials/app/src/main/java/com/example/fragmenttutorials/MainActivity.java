package com.example.fragmenttutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fristFragment = new FristFragment();
        Fragment secondFragment = new SecondFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.flFragment, fristFragment, null)
                .setReorderingAllowed(true)
                .commit();

        Button button1 = findViewById(R.id.btnFragment1);
        Button button2 = findViewById(R.id.btnFragment2);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.flFragment, fristFragment, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.flFragment, secondFragment, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}