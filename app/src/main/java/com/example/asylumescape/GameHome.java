package com.example.asylumescape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameHome extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        HomeBGM.player.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        HomeBGM.player.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);
        View decorView = getWindow().getDecorView();
        HomeBGM.SoundPlayer(this, R.raw.home_bgm);
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    public void ReflexEscape(View view) {
        Intent intent=new Intent(this, ReflexEscapeHome.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        HomeBGM.player.stop();
        finish();
    }

    public void MirroredCards(View view) {
        Intent intent=new Intent(this, MirroredCardsHome.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        HomeBGM.player.stop();
        finish();
    }

    public void Leaderboard(View view) {
        Intent intent=new Intent(this, Leaderboards.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        HomeBGM.player.stop();
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        HomeBGM.player.pause();
    }
}