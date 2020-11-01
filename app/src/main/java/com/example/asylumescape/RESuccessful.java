package com.example.asylumescape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RESuccessful extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_successful);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        TextView textView=findViewById(R.id.time);

        Bundle extras=getIntent().getExtras();
        String time= null;
        if (extras != null) {
            time = extras.getString("time");
        }
        textView.setText(time);
    }

    public void RETryAgain(View view) {
        Intent intent=new Intent(RESuccessful.this, ReflexEscapeHome.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }

    public void Home(View view) {
        Intent intent=new Intent(RESuccessful.this, GameHome.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }
}