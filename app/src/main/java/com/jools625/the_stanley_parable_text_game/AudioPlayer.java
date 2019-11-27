package com.jools625.the_stanley_parable_text_game;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private int[] audioFiles;
    private int audioIndex = 0;
    private Context context;
    private MediaPlayer mPlayer;

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
                if(audioIndex < audioFiles.length-1) {
                    audioIndex++;
                    playAudio();
                }
            }
        });
    }

    public void nextTrack() {
        mPlayer.stop();
        if(audioIndex < audioFiles.length-1) {
            audioIndex++;
            playAudio();
        }
    }

    public void prevTrack() {
        mPlayer.stop();
        if(audioIndex > 0) {
            audioIndex--;
            playAudio();
        } else if(audioIndex == 0) {
            playAudio();
        }
    }

}
