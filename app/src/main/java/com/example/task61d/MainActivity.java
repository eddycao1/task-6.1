package com.example.task61d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sign_up, login;
    EditText email_address, password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sign_up = findViewById(R.id.signup_bt);
        login = findViewById(R.id.login_bt);
        email_address =findViewById(R.id.username);
        password = findViewById(R.id.password);
        int sre_pw = 123321;

        DB = new DBHelper(this);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, insert_signup_data.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email_addressText = email_address.getText().toString();
                String passwordText = password.getText().toString();
                String name = "a";

                Boolean checkInsertData = DB.insertuserdata(name,email_addressText,passwordText);

                if(checkInsertData == false){
                    Toast.makeText(MainActivity.this, "Password or user name incorrect", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(passwordText)==123321)
                {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Home_page.class);
                    startActivity(intent);

                }

            }
        });




    }


}