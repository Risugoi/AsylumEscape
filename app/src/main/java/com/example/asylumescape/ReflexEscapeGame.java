package com.example.asylumescape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.Random;

public class ReflexEscapeGame extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        REBGM.player.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflexescape_game);
        REBGM.SoundPlayer(this, R.raw.re_bgm);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        Random rand=new Random();
        int screen=rand.nextInt(3);
        int time=rand.nextInt(15)+1;
        if(time>0){time-=1;}
        switch(screen){
            case 0:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(ReflexEscapeGame.this, RENotSafe.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    }
                }, time*1000);
                break;
            case 1:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(ReflexEscapeGame.this, RESafe.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    }
                }, time*1000);
                break;
            case 2:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(ReflexEscapeGame.this, RENotSafe2.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    }
                }, time*1000);
            case 3:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(ReflexEscapeGame.this, RENotSafe3.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    }
                }, time*1000);
            case 4:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(ReflexEscapeGame.this, RENotSafe4.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    }
                }, time*1000);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        REBGM.player.pause();
    }
}