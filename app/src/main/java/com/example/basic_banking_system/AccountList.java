package com.example.basic_banking_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AccountList extends AppCompatActivity {
    ListView listview;
    ArrayList<String> Name = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_list);
        Intent toDetail = new Intent(AccountList.this,person_detail.class);
        Name.add("kailash sahu");
        Name.add("rakesh sarangi");
        Name.add("satya dalei");
        Name.add("subhra biswal");
        Name.add("dibya routray");
        Name.add("jiban parida");
        Name.add("dibakar das");
        Name.add("sunil das");
        Name.add("biswajit das");
        Name.add("soumya das");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                toDetail.putExtra("position",i);
                startActivity(toDetail);
            }
        });
    }
}