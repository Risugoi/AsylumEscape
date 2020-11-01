package com.example.asylumescape;

import android.content.Context;
import android.media.MediaPlayer;

public class MCBGM {
    public static MediaPlayer player;
    public static void SoundPlayer(Context ctx, int raw_id){
        player = MediaPlayer.create(ctx, raw_id);
        player.setLooping(true);
        player.setVolume(75, 75);
        player.start();
    }
}
