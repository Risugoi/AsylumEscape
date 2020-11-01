package com.example.asylumescape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MirroredCardsGame extends AppCompatActivity{
    private CountDownTimer countDownTimer;
    private long time=600000;
    private boolean run;

    @Override
    protected void onStart() {
        super.onStart();
        MCBGM.player.start();
    }

    ImageView curView = null;
    private int countPair = 0;
    final int[] drawable = new int[] {
            R.drawable.card1,
            R.drawable.card2,
            R.drawable.card3,
            R.drawable.card4,
            R.drawable.card5,
            R.drawable.card6,
            R.drawable.card7,
            R.drawable.card8,
            R.drawable.card9,
            R.drawable.cardmon
    };
    int[] pos = {0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9};
    int currentPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirroredcards_game);

        MCBGM.SoundPlayer(this, R.raw.mc_bgm);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        ImageAdapter imageAdapter = new ImageAdapter(this);
        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentPos < 0 ) {
                    currentPos = position;
                    curView = (ImageView) view;
                    ((ImageView) view).setImageResource(drawable[pos[position]]);
                }
                else {
                    if (currentPos == position) {
                        ((ImageView) view).setImageResource(R.drawable.cardflipped);
                    } else if (pos[currentPos] != pos[position]) {
                        curView.setImageResource(R.drawable.cardflipped);
                        Toast.makeText(MirroredCardsGame.this, "Not Match!", Toast.LENGTH_LONG).show();
                    } else {
                        ((ImageView) view).setImageResource(drawable[pos[position]]);
                        countPair++;
                        if (countPair == 10) {
                            Toast.makeText(MirroredCardsGame.this, "You Win!", Toast.LENGTH_LONG).show();
                        }
                    }
                    currentPos = -1;
                }
            }
        });

        timerStatus();
    }


    public void back(View view) {
        Intent intent=new Intent(MirroredCardsGame.this, GameHome.class);
        timerStatus();
        startActivity(intent);
        MCBGM.player.stop();
        overridePendingTransition(0,0);
        finish();
    }

    public void timerStatus(){
        if(run){
            stopTimer();
        }
        else{
            startTimer();
        }
    }

    public void startTimer(){
        countDownTimer=new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time=millisUntilFinished;
                update();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        run=true;
    }
    public void stopTimer(){
        countDownTimer.cancel();
        run=false;
    }

    public void update(){
        TextView textView=findViewById(R.id.time);
        int min=(int) time/60000;
        int sec=(int) time%60000/1000;

        String time = String.format("%02d", min) + ":"
                + String.format("%02d", sec);
        textView.setText(time);
    }
}




