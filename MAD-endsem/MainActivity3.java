package com.example.endsem_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    TextView display;
    Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        check=(Button)findViewById(R.id.button7);
        display=(TextView)findViewById(R.id.textView3);
        Intent intent=getIntent();
        String intake=intent.getStringExtra("Name");
        display.setText(intake);
        int var =Integer.parseInt(intake);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(var<=10){
                    Toast.makeText(MainActivity3.this, "GOOD WATER INTAKE", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity3.this, "THE FUCK BRO", Toast.LENGTH_SHORT).show();

            }
        });


    }
}