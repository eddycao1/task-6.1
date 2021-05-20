package com.example.task61d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toast;

public class addnew_page extends AppCompatActivity {

    ImageView cam,i;
    private static final int REQUEST_CODE = 43;
    Button  save;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnew_page);
        i = findViewById(R.id.imagexd);
        save =findViewById(R.id.save_bt);
        calendarView =findViewById(R.id.c1);

        cam = findViewById(R.id.cam);
        cam.setImageResource(R.drawable.camera);
        calendarView.setDate(21/05/21);

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(addnew_page.this, "Permission already granted",Toast.LENGTH_SHORT).show();
                        String path = Environment.getExternalStorageDirectory() + "/Pictures/";
                        //Uri uri = Uri.parse(path);
                        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                        intent.setType("image/*");
                        intent.addCategory((Intent.CATEGORY_OPENABLE));
                        startActivityForResult(intent,REQUEST_CODE);


                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                               // cam.setImageResource(R.drawable.pizza);
                                cam.setImageResource(R.drawable.pizza);
                            }
                        },1000);

                       // intent.setDataAndType(uri,"*/*");
                       // startActivity(intent);

                    }else {
                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                    }
                } else {

                    Toast.makeText(addnew_page.this, "Permission granted",Toast.LENGTH_SHORT).show();
                }
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(addnew_page.this,ffs.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode== Activity.RESULT_OK){
            if(data != null){
                Uri uri = data.getData();
                Toast.makeText(addnew_page.this, "Uri: " +uri ,Toast.LENGTH_SHORT).show();
                Toast.makeText(addnew_page.this, "Path: " +uri.getPath() ,Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void verifyPermisions() {
        String[] permisstion = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), permisstion[0]) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this.getApplicationContext(), permisstion[1]) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this.getApplicationContext(), permisstion[2]) == PackageManager.PERMISSION_GRANTED) {


        } else {
            //ActivityCompat.requestPermissions((addnew_page.this,permisstion,1));
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(addnew_page.this, "Permission granted",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(addnew_page.this, "Permission denied",Toast.LENGTH_SHORT).show();
            }
        }
    }
}