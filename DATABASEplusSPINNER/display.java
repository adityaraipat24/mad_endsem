package com.example.endsem_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.endsem_3.DBHelper;

public class display extends AppCompatActivity {
    TextView t1;
    DBHelper mydb;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        t1=findViewById(R.id.display1);
        Intent intent=getIntent();
        mydb=new DBHelper(this);

        Cursor res = mydb.getdata();
        if(res.getCount()==0){
            Toast.makeText(this, "error,no entry", Toast.LENGTH_SHORT).show();
            return;
        }
        String s="";


        while(res.moveToNext()){
            s=s+(res.getString(0)+"  "+res.getString(1)+"  "+res.getString(2)+"\n\n");

        }
        t1.setText(s);







    }
}