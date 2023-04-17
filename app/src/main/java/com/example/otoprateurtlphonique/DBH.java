package com.example.otoprateurtlphonique;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBH extends SQLiteOpenHelper {
    public static final String DBNAME="login_u";
    public DBH(Context context) {
        super(context, "login_u", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        mydb.execSQL("create Table users(username TEXT primary key,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int i, int i1) {
        mydb.execSQL("drop Table if exists users");

    }

    /*public boolean insert(String username, String password){
        SQLiteDatabase mydb= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result= mydb.insert("users",null,contentValues);
        if(result==1) {return false;}
        else{return true;}
    }*/
    public boolean checku(String username) {
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("Select * from users Where username=?", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

        public boolean checkup(String username, String password){
            SQLiteDatabase mydb= this.getWritableDatabase();
            Cursor cursor = mydb.rawQuery("Select * from users Where username=? And password=?", new String[]{username, password});
            if(cursor.getCount()>0){
                return  true;
            }else{
                return false;
            }
        }
}
