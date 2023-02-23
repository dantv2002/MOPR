package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button firstFragmentBtn, secondFragmentBtn;
    TextView fragmentText;
    private ItemViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragmentBtn = findViewById(R.id.fragment1btn);
        secondFragmentBtn = findViewById(R.id.fragment2btn);

        Fragment fristFragment = new fragment1();
        Fragment secondFragment = new fragment2();

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentText = findViewById(R.id.fragmentText);

        viewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        viewModel.getSelectedItem().observe(this, item -> {
            fragmentText.setText(item);
        });

        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, fristFragment, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });

        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, secondFragment, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}