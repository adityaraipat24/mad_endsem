package com.example.endsem_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText et;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent inte=getIntent();
        bt=(Button) findViewById(R.id.button6);
        et=(EditText)findViewById(R.id.edit2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,MainActivity3.class);
                String st=et.getText().toString();
                //SEND THE VARIABLES::
                i.putExtra("Name",st);
                startActivity(i);



            }
        });
    }
}