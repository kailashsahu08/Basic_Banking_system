package com.example.basic_banking_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class person_detail extends AppCompatActivity {
    TextView name,age,mobno,balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        mobno = findViewById(R.id.mobno);
        balance = findViewById(R.id.balance);
        Intent fromlist = getIntent();
        int position = fromlist.getIntExtra("position",1);
        position++;
        dbHelper dbHelper = new dbHelper(this);
        ArrayList<acccountDetail> accountdetail = dbHelper.getContext(position);
        name.setText(accountdetail.get(0).name);
        age.setText(accountdetail.get(0).age);
        mobno.setText(accountdetail.get(0).mobno);
        balance.setText(accountdetail.get(0).balance);
    }
}