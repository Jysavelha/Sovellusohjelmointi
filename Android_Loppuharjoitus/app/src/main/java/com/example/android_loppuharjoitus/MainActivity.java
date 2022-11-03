package com.example.android_loppuharjoitus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void ClickHelsinki(View view) {

        Intent intent = new Intent(this, Stockholm.class);
        startActivity(intent);
    }


    public void ClickDubai(View view) {

        Intent intent = new Intent(this, Abu_Dhabi.class);
        startActivity(intent);
    }


    public void ClickNewYork(View view) {

        Intent intent = new Intent(this,New_York.class);
        startActivity(intent);
    }


    public void ClickSydney(View view) {

        Intent intent = new Intent(this, Canberra.class);
        startActivity(intent);
    }
}