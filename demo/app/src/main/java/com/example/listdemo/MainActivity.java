package com.example.listdemo;

import androidx.annotation.NonNull;
//import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.tv_test:
                Intent intent= new Intent(MainActivity.this, RecycleViewActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }
//    public String getFromAssets(String fileName){
//        try {
//            InputStreamReader inputReader = new InputStreamReader( getResources().getAssets().open(fileName) );
//            BufferedReader bufReader = new BufferedReader(inputReader);
//            String line="";
//            String Result="";
//            while((line = bufReader.readLine()) != null)
//                Result += line;
//            return Result;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
