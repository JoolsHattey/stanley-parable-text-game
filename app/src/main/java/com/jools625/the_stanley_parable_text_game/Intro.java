package com.jools625.the_stanley_parable_text_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Intro extends AppCompatActivity {

    int[] audioIDs = {R.raw.intro_1_00, R.raw.intro_1_01, R.raw.intro_1_02, R.raw.intro_1_03
                    , R.raw.intro_1_04, R.raw.intro_1_05, R.raw.intro_1_06, R.raw.intro_2_00
                    , R.raw.intro_2_01, R.raw.intro_2_02, R.raw.intro_2_03, R.raw.intro_2_04
                    , R.raw.intro_2_05, R.raw.intro_2_06};
    ImageButton nextButton, prevButton, pausePlayButton;
    Button option1, option2;
    AudioPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        nextButton = findViewById(R.id.buttonNext);
        prevButton = findViewById(R.id.buttonPrev);
        pausePlayButton = findViewById(R.id.buttonPausePlay);
        option1 = findViewById(R.id.buttonOption1);
        option2 = findViewById(R.id.buttonOption2);

        audio = new AudioPlayer(audioIDs, getApplicationContext());
        audio.playAudio();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stopAudio();
                audio.nextTrack();
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stopAudio();
                audio.prevTrack();
            }
        });
        pausePlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.pause();
            }
        });
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stopAudio();
                audio = null;
                Intent nextScreen = new Intent(Intro.this, EmptyOffice.class);
                startActivity(nextScreen);
                finish();
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stopAudio();
                audio = null;
                Intent nextScreen = new Intent(Intro.this, CowardEnding.class);
                startActivity(nextScreen);
                finish();
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        if ((audio!= null) && (audio.isPlaying()))
        {
            audio.pause();
        }
    }

}
