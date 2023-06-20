package com.example.basic_banking_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button  accounts,history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accounts = findViewById(R.id.accounts);
        history = findViewById(R.id.history);
        dbHelper dbHelper = new dbHelper(this);
        dbHelper.addAccounts("kailash sahu",22,"+918465324832",10000);
        dbHelper.addAccounts("Rakesh sarangi",22,"+918465324832",10000);
        dbHelper.addAccounts("Satya dalei",23,"+918465324832",10000);
        dbHelper.addAccounts("Subhra biswal",25,"+918465324832",10000);
        dbHelper.addAccounts("dibya routray",21,"+918465324832",10000);
        dbHelper.addAccounts("Jiban parida",26,"+918465324832",10000);
        dbHelper.addAccounts("Dibakar das",23,"+918465324832",10000);
        dbHelper.addAccounts("Sunil das",24,"+918465324832",10000);
        dbHelper.addAccounts("Biswajit das",24,"+918465324832",10000);
        dbHelper.addAccounts("Soumya das",25,"+918465324832",10000);
        Intent toAccountList = new Intent(MainActivity.this,AccountList.class);

        accounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toAccountList);
            }
        });
    }
}