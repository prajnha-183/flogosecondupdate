package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
        Button b1,b2;
        EditText ed1,ed2;

        TextView tx1;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            b1 = (Button)findViewById(R.id.buttn);
            ed1 = (EditText)findViewById(R.id.username_edit_text);
            ed2 = (EditText)findViewById(R.id.password_edit_text);

            b2 = (Button)findViewById(R.id.button2);
            tx1 = (TextView)findViewById(R.id.textView4);
            tx1.setVisibility(View.GONE);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ed1.getText().toString().equals("user@flogo.in") &&
                            ed2.getText().toString().equals("Flogo123")){
                        Toast.makeText(getApplicationContext(),
                                "Redirecting...",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, LogActivity.class);
                        startActivity(i);
                    }
                    else  if(ed1.getText().toString().equals("") &&
                            ed2.getText().toString().equals(""))

                    {
                        Toast.makeText(getApplicationContext(), "Please Enter Username and Password", Toast.LENGTH_SHORT).show();
                        tx1.setVisibility(View.VISIBLE);
                        tx1.setBackgroundColor(Color.BLACK);
                    }else if(ed1.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(), "Please Enter Username",Toast.LENGTH_SHORT).show();tx1.setVisibility(View.VISIBLE);
                        tx1.setBackgroundColor(Color.BLACK);
                    }else if( ed2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter Password",Toast.LENGTH_SHORT).show();tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.BLACK);
                } else
                    {
                        Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();tx1.setVisibility(View.VISIBLE);
                        tx1.setBackgroundColor(Color.BLACK);



                    }
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
