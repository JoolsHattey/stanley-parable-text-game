package com.jools625.the_stanley_parable_text_game;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private int[] audioFiles;
    private int audioIndex = 0;
    Context context;
    MediaPlayer mPlayer;

    public AudioPlayer(int[] audioIDs, Context activity) {
        audioFiles = audioIDs;
        context = activity;
    }

    public void playAudio() {
        mPlayer = MediaPlayer.create(context, audioFiles[audioIndex]);
        mPlayer.start();


        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                audioIndex++;
                playAudio();
            }
        });
    }

    public void nextTrack() {
        mPlayer.stop();
        audioIndex++;
        playAudio();
    }

}
