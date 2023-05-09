package com.example.endsem_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner city;
    EditText t1,t2;
    RadioButton r1,r2,r3;
    String ra1;
    String ra2;
    String ra3;
    String data;
    String spindata;
    DBHelper mydb;
    public void onRadioButtonClicked(View view){

        if(r1.isChecked()){

            data=ra1;
        }
        else if(r2.isChecked()){

            data=ra2;
        }

        else if(r3.isChecked()){

            data=ra3;
        }
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();




    }


    public void insert(View view){
        boolean inserted=mydb.insert_data(t1.getText().toString(),t2.getText().toString(),data);
        if(inserted){
            Toast.makeText(this, "insertion successfull", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "unsuccessfull", Toast.LENGTH_SHORT).show();
        }

    }

    public void update(View view){
        boolean updated=mydb.update(t1.getText().toString(),t2.getText().toString());
        if(updated==true){
            Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, " not updated", Toast.LENGTH_SHORT).show();
        }

    }

    public void display(View view){
        Intent intent=new Intent(this,display.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb=new DBHelper(this);
        city=findViewById(R.id.spinner);
        r1=findViewById(R.id.java);
        r2=findViewById(R.id.py);
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.pass);

        r3=findViewById(R.id.at);
        ra1=r1.getText().toString();
        ra2=r2.getText().toString();
        ra3=r3.getText().toString();






        ArrayList<String> items= new ArrayList<>();
        items.add("city");
        items.add("banglore");
        items.add("ranchi");
        items.add("mumbai");
        items.add("udupi");

        ArrayAdapter<String> adap=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,items);

        city.setAdapter(adap);

        spindata=city.getSelectedItem().toString();

    }
}