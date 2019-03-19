package com.example.qltc.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.qltc.model.User;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }
    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }
    public void open(){
        this.db = openHelper.getWritableDatabase();
    }
    public void close(){
        if(db!=null){
            this.db.close();
        }
    }
    //Write query...
    public User getAllUser(){
        c = db.rawQuery("SELECT * FROM user", new String[]{});
        User user = null;
        while(c.moveToNext()){
            String username = c.getString(1);
            String password = c.getString(2);
            long balance = c.getLong(3);
            user = new User(username,password,balance);
        }
        return user;
    }

}
