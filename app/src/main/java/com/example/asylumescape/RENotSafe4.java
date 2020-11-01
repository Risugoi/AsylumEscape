package com.example.asylumescape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class RENotSafe4 extends AppCompatActivity {
    DatabaseHelper db;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_notsafe4);
        screamAppear();
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        final Button button = findViewById(R.id.notSafe);
        final Handler handler=new Handler();
        db=new DatabaseHelper(this);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(RENotSafe4.this, ReflexEscapeGame.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        },1000);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fail="fail";
                db.insertData(fail);
                handler.removeCallbacksAndMessages(null);
                Intent intent=new Intent(RENotSafe4.this, RENotSuccessful.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
                REBGM.player.stop();
                screamDeath();
            }
        });
    }

    public void screamAppear(){
        mp = MediaPlayer.create(this, R.raw.scream_appear);
        mp.setVolume(20, 20);
        mp.start();
    }

    public void screamDeath(){
        mp = MediaPlayer.create(this, R.raw.scream_death);
        mp.setVolume(20, 20);
        mp.start();
    }
}

