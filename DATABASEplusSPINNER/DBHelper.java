package com.example.endsem_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String  DATABASE="form.db";
    private static final String  TABLE="form";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " +TABLE+"(password varchar(20) primary key ,username varchar(20),radiobtn varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean insert_data(String uname,String pass,String rdb){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",uname);
        contentValues.put("password",pass);
        contentValues.put("radiobtn",rdb);

        long result= db.insert(TABLE,null,contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }



    }
    public boolean update(String name1,String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("username",name1);
        contentValues.put("password",pass);
        db.update(TABLE,contentValues,"username=?",new String[]{name1});
        return true;


    }


    public Cursor getdata(){

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+TABLE,null);
        return res;

    }


}
