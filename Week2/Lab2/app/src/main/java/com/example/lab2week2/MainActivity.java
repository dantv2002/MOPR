package com.example.lab2week2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addFunction(View view) {
        // Do something in response to button click
        int sum = 0;
        EditText edtIpA = (EditText)findViewById(R.id.editTextTextInputA);
        EditText edtIpB = (EditText)findViewById(R.id.editTextTextInputB);
        TextView tvSum = (TextView)findViewById(R.id.textViewAaddB);
        String ipA = edtIpA.getText().toString();
        String ipB = edtIpB.getText().toString();
        try{
            sum = Integer.parseInt(ipA) + Integer.parseInt(ipB);
            tvSum.setText(""+sum);
        } catch (NumberFormatException e){
            Log.e("Event Handling Error", "please fill all input");
            return;
        } catch (Exception ex){
            return;
        }
        Log.i("Event Handling", "A + B = " + sum);
    }

}