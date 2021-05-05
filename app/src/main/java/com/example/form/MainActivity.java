package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1,b2;
    RadioGroup rg;
    RadioButton r1,r2;
    CheckBox c1,c2,c3;
    Switch switch1;
    LinearLayout line1,line2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        rg=(RadioGroup)findViewById(R.id.rg);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        c1=(CheckBox)findViewById(R.id.c1);
        c2=(CheckBox)findViewById(R.id.c2);
        c3=(CheckBox)findViewById(R.id.c3);
        b1=(Button)findViewById(R.id.btn1);
        b2=(Button)findViewById(R.id.b2);
        switch1=(Switch)findViewById(R.id.switch1);
        line1=(LinearLayout)findViewById(R.id.line1);
        line2=(LinearLayout)findViewById(R.id.line2);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switch1.isChecked())
                {
                    line1.setBackgroundColor(Color.GREEN);
                 line2.setBackgroundColor(Color.GREEN);
                }
                else
                {
                    line1.setBackgroundColor(Color.YELLOW);
                    line2.setBackgroundColor(Color.YELLOW);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String email=e2.getText().toString();
                String pwd=e3.getText().toString();
                String gender="";
                String education="";
                if(r1.isChecked())
                {
                    gender="male";
                }
                else if(r2.isChecked())
                {
                    gender="female";
                }
                if(c1.isChecked())
                {
                    education="UG";
                }
                if(c2.isChecked())
                {
                    education = education+" PG";
                }
                if(c3.isChecked())
                {
                    education=education+" Diploma";
                }
                Intent i=new Intent(getApplicationContext(),showdata.class);
                i.putExtra("name",name);
                i.putExtra("email",email);
                i.putExtra("pwd",pwd);
                i.putExtra("gender",gender);
                i.putExtra("education",education);
                startActivity(i);
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Aboutus.class);
                startActivity(i);
            }
        });

    }
}