package com.xan.mvpapp;
//ondate 19/05/2019
//nim: 10116035
//nama:prabowo adi perwira
//kelas:AKB-1(IF-1)
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
            finish();

    }
}
