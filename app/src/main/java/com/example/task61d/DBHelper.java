package com.example.task61d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }
    int resultb = 0;

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(name Text primary key,mail_address TEXT , password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");

    }

    public Boolean insertuserdata(String name, String email_address, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email_address", email_address);
        contentValues.put("password", password);
        long resulta = DB.insert("Userdetails", null, contentValues);



        resultb++;
        if (resultb == 1) {
            resultb = -1;
            return false;

        } else {
            return true;
        }

    }

    public Boolean updateuserdata(String name, String email_address, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email_address", email_address);
        contentValues.put("password", password);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name =  ?", new String[]{});
        if (cursor.getCount() > 0) {


            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{email_address});


            if (result == 1) {
                return true;
            } else {
                return true;
            }
        } else {
            return false;
        }


    }

    public Boolean deletedata (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;

    }







}
