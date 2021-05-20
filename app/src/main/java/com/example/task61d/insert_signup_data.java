package com.example.task61d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insert_signup_data extends AppCompatActivity {

    EditText name, email_address, phone_number,address,passwpord,confirm_password;
    Button save;
    DBHelper DB;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        name = findViewById(R.id.fullname);
        email_address = findViewById(R.id.email);
        phone_number = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        passwpord = findViewById(R.id.password_one);
        confirm_password = findViewById(R.id.password_two);

        save = findViewById(R.id.save_bt);

        DB= new DBHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();
                String email_addressText = email_address.getText().toString();
                String passwordText = passwpord.getText().toString();
                String confirm_passwordText = confirm_password.getText().toString();

                Boolean checkInsertData = DB.insertuserdata(nameText,email_addressText,passwordText);

                 if(Integer.parseInt(confirm_passwordText) != Integer.parseInt(passwordText)){
                     Toast.makeText(insert_signup_data.this, "Password and confirm password should be the same", Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     if (checkInsertData == true) {
                         Toast.makeText(insert_signup_data.this , "Sign up successful", Toast.LENGTH_SHORT).show();
                     }
                     else
                     {
                         Toast.makeText(insert_signup_data.this, "this email address already sign up, please login", Toast.LENGTH_SHORT).show();
                     }


                 }


            }
        });


    }



}