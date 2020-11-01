package com.example.asylumescape;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class RESafe extends AppCompatActivity {
    Button click;
    long tMS, startTime, buff, update=0L;
    Handler handler=new Handler();
    int sec, ms, min;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_safe);
        REBGM.player.stop();
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        click=findViewById(R.id.safe);
        startTime= SystemClock.uptimeMillis();
        handler.postDelayed(runnable, 0);
        db=new DatabaseHelper(this);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buff+=tMS;
                handler.removeCallbacks(runnable);
                String time = String.format("%02d", sec) + ":"
                        + String.format("%03d", ms);

                db.insertData(time);
                Intent intent=new Intent(RESafe.this, RESuccessful.class);
                intent.putExtra("time", time);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });

    }

    public Runnable runnable=new Runnable() {
        @Override
        public void run() {
            tMS= SystemClock.uptimeMillis()-startTime;
            update=buff+tMS;
            sec=(int)(update/1000);
            min=sec/60;
            ms=(int)(update%1000);
            handler.postDelayed(this, 0);
        }
    };
}
