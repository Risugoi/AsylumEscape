package com.example.asylumescape;

import android.content.Context;
import android.media.MediaPlayer;

public class StoryBGM {
    public static MediaPlayer player;

    public static void SoundPlayer(Context ctx, int raw_id) {
        player = MediaPlayer.create(ctx, raw_id);
        player.setLooping(true);
        player.setVolume(100, 100);
        player.start();
    }
}
