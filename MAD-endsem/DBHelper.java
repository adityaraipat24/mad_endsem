package com.example.endsem_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static  final String DATABSE_NAME="Student.db";
    public static  final String TABLE_NAME="student_table";
    public static  final String COL1="ID";
    public static  final String COL2="NAME";
    public static  final String COL3="SURNAME";
  //  public static  final String COL4="MARKS";



    public DBHelper( Context context) {
        super(context, DATABSE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }
    public boolean insertData(String name,String surname){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,surname);
     //   contentValues.put(COL4,marks);
        long result= db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }
    public Cursor getAllData(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res=db.rawQuery(" SELECT * FROM " + TABLE_NAME,null);
        return res;


    }
    public boolean updatedata(String id,String name,String surname){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,name);
        contentValues.put(COL3,surname);
       // contentValues.put(COL4,marks);
        db.update(TABLE_NAME,contentValues, "ID = ?",new String[] { id });
        return true;


    }
    public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME, " ID = ?", new String[] {id});

    }


}
