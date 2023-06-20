package com.example.basic_banking_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {
    public static final String Database_name = "accountDB";
    public static final String Table_name = "account";
    public static final  String Key_id = "id" ;
    public static final String Key_name = "name";
    public static final String Key_age = "age";
    public static final String Key_mno = "mob";
    public static final String Key_balance = "balance";


    public dbHelper( Context context) {
        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Table_name +
                "("+ Key_id +"INTEGER PRIMARY KEY ,"+Key_name+" TEXT,"+Key_age+" INTEGER,"+Key_mno+" TEXT,"+Key_balance+" INTEGER"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_name );
        onCreate(db);

    }
    public void  addAccounts(String name1,int age1,String mob1,int balance1)
    {
        SQLiteDatabase  db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Key_name,name1);
        values.put(Key_age,age1);
        values.put(Key_mno,mob1);
        values.put(Key_balance,balance1);
        db.insert(Table_name,null,values);
    }
    public ArrayList<acccountDetail> getContext(int i)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = { String.valueOf(i) };
        Cursor cursor = db.rawQuery("SELECT * FROM "+Table_name+" WHERE "+Key_id+" = ?", selectionArgs);
        ArrayList<acccountDetail> ad = new ArrayList<>();
        acccountDetail detail = new acccountDetail();
        detail.name = cursor.getString(1);
        detail.age = cursor.getInt(2);
        detail.mobno = cursor.getString(3);
        detail.balance = cursor.getInt(4);
        ad.add(detail);

        return  ad;
    }
}
