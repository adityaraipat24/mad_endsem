package com.example.endsem_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//###-->>create a database username and password   in next activity ask for water intake and take it to 3rd activity and check if it is //proper amount

public class MainActivity extends AppCompatActivity {

    DBHelper DBHelper;
    EditText editname,editsurname,editTextID;
    Button btnADD;
    Button btnView;
    Button btnUpdate;
    Button btnDelete;
    Button sub;
    int alpha=0;
    int digits=0;
    int remain=0;
    AlertDialog.Builder build;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper =new DBHelper(this);
        editname=(EditText) findViewById(R.id.editTextTextPersonName);
        editsurname=(EditText) findViewById(R.id.editTextTextPersonName2);
       // editmarks=(EditText) findViewById(R.id.editTextTextPersonName3);
        build=new AlertDialog.Builder(this);
        editTextID=(EditText)findViewById(R.id.editTextTextPersonName4);
        btnADD=(Button) findViewById(R.id.button);
        btnView=(Button) findViewById(R.id.button2);
        btnUpdate=(Button) findViewById(R.id.button3);
        btnDelete=(Button) findViewById(R.id.button4);
        sub=(Button)findViewById(R.id.button5);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass=editsurname.getText().toString();
                for(int i=0;i<pass.length();i++){
                    int asc=(int)(pass.charAt(i));
                    if((asc>=65 && asc<=90)||(asc>=97&& asc<=122)){
                        alpha++;
                    }
                    else if(asc>=48&&asc<=57)
                        digits++;
                    else
                        remain++;
                }
                if(digits==1 && remain==1&& alpha==2){

                    build.setTitle("ALERT!!");
                    build.setMessage("DO YOU WANT TO GO TO THE NEXT PAGE");
                    build.setCancelable(true);
                    build.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i=new Intent(MainActivity.this,MainActivity2.class);
                            startActivity(i);
                            finish();
                        }
                    });
                    build.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    build.show();


                }
                else{
                    Toast.makeText(MainActivity.this, "SELECTED ANOTHER PASS", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
    public  void DeleteData(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows =DBHelper.deleteData(editTextID.getText().toString());
                if(deletedRows>0)
                    Toast.makeText(MainActivity.this,"DATA Deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"DATA NOT Deleted",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void UpdateData(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated =DBHelper.updatedata(editTextID.getText().toString(),editname.getText().toString(),editsurname.getText().toString());
                if(isUpdated==true)
                    Toast.makeText(MainActivity.this,"DATA UPDATED",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"DATA NOT UPDATED",Toast.LENGTH_SHORT).show();



            }
        });
    }
    public void AddData(){
        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted= DBHelper.insertData(editname.getText().toString(),editsurname.getText().toString());
                if(isinserted==true)
                    Toast.makeText(MainActivity.this,"DATA INSERTED",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"DATA NOT INSERTED",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public  void viewAll(){
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);

            }
        });
    }

    public  void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }


}
