package com.jools625.the_stanley_parable_text_game;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

public class Intro extends AppCompatActivity {

    int[] audioIDs = {R.raw.intro_1_00, R.raw.intro_1_01, R.raw.intro_1_02, R.raw.intro_1_03
                    , R.raw.intro_1_04};
    int audioIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        AudioPlayer audio = new AudioPlayer(audioIDs, getApplicationContext());
        audio.playAudio();
    }


}
