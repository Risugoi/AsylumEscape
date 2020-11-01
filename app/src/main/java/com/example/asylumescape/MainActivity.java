package com.example.asylumescape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    @Override
    protected void onStart() {
        super.onStart();
        StoryBGM.player.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StoryBGM.SoundPlayer(this, R.raw.story_bgm);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        viewPager2=findViewById(R.id.story);
        List<Story> story=new ArrayList<>();
        story.add(new Story(R.drawable.story1));
        story.add(new Story(R.drawable.story2));
        story.add(new Story(R.drawable.story3));
        story.add(new Story(R.drawable.story4));
        story.add(new Story(R.drawable.story5));
        story.add(new Story(R.drawable.story6));
        story.add(new Story(R.drawable.story7));
        story.add(new Story(R.drawable.story8));
        story.add(new Story(R.drawable.story9));
        story.add(new Story(R.drawable.story10));
        story.add(new Story(R.drawable.story11));
        story.add(new Story(R.drawable.story12));
        story.add(new Story(R.drawable.story13));
        story.add(new Story(R.drawable.disc1));
        story.add(new Story(R.drawable.disc2));

        viewPager2.setAdapter(new SliderAdapter(story, viewPager2));
    }

    public void game(View view) {
        Intent intent=new Intent(MainActivity.this, GameHome.class);
        startActivity(intent);
        finish();
        StoryBGM.player.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
        StoryBGM.player.pause();
    }
}
