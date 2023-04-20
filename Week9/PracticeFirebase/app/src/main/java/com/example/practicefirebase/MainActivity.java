package com.example.practicefirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText txtName, txtAge, txtPhone, txtHeight;
    Button btnSave;
    DatabaseReference reff;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datainsert);

        txtName = findViewById(R.id.txtname);
        txtAge = findViewById(R.id.txtage);
        txtPhone = findViewById(R.id.txtphone);
        txtHeight = findViewById(R.id.txtheight);
        btnSave = findViewById(R.id.btnsave);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                member.setName(txtName.getText().toString().trim());
                member.setAge(Integer.parseInt(txtAge.getText().toString().trim()));
                member.setPhone(Long.parseLong(txtPhone.getText().toString().trim()));
                member.setHeight(Float.parseFloat(txtHeight.getText().toString().trim()));

                reff.push().setValue(member);
                Toast.makeText(MainActivity.this,"insert data successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}