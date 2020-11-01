package com.example.asylumescape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ReflexEscapeHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflexescape_home);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }


    public void REGame_start(View view) {
        Intent intent=new Intent(this, ReflexEscapeGame.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }

    public void back(View view) {
        Intent intent=new Intent(ReflexEscapeHome.this, GameHome.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }
}