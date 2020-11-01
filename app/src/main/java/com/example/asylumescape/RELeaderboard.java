package com.example.asylumescape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class RELeaderboard extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_leaderboard);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        TextView record1=findViewById(R.id.record1);
        TextView record2=findViewById(R.id.record2);
        TextView record3=findViewById(R.id.record3);
        TextView successCount=findViewById(R.id.successcount);
        TextView failCount=findViewById(R.id.failcount);
        TextView totalCount=findViewById(R.id.totalcount);

        db=new DatabaseHelper(this);
        Cursor c=db.getData();
        ArrayList<String> time=new ArrayList<String>();
        while(c.moveToNext()){
            time.add(c.getString(0));
        }

        int total=time.size();
        int fail=0;
        for (int i=0; i<total;i++){
            if (time.get(i).equals("fail")){
                fail++;
            }
        }
        int successful=total-fail;
        if(successful<0){
            successful=0;
        }

        System.out.println(successful);
        System.out.println(fail);
        System.out.println(total);

        String sTotal=String.valueOf(successful);
        String fTotal=String.valueOf(fail);
        String tTotal=String.valueOf(total);

        if(successful==1){
            record1.setText(time.get(0));
        }else if(successful==2){
            record1.setText(time.get(0));
            record2.setText(time.get(1));
        }else if(successful>=3){
            record1.setText(time.get(0));
            record2.setText(time.get(1));
            record3.setText(time.get(2));
        }

        successCount.setText(sTotal);
        failCount.setText(fTotal);
        totalCount.setText(tTotal);
    }

    public void back(View view) {
        Intent intent=new Intent(RELeaderboard.this, Leaderboards.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }
}

