package com.jools625.the_stanley_parable_text_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CowardEnding extends AppCompatActivity {

    int[] audioIDs = {R.raw.locked_office_00, R.raw.locked_office_01, R.raw.locked_office_02
                    , R.raw.locked_office_03, R.raw.locked_office_04, R.raw.locked_office_05};
    ImageButton nextButton, prevButton, pausePlayButton;
    Button restartGameButton;
    AudioPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coward_ending);

        nextButton = findViewById(R.id.buttonNext);
        prevButton = findViewById(R.id.buttonPrev);
        restartGameButton = findViewById(R.id.buttonOption1);

        audio = new AudioPlayer(audioIDs, getApplicationContext());
        audio.playAudio();
        pausePlayButton = findViewById(R.id.buttonPausePlay);
        pausePlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((audio!= null) && (audio.isPlaying())) {
                    audio.pause();
                    pausePlayButton.setImageResource(R.drawable.ic_play_arrow_24px);
                } else {
                    audio.pause();
                    pausePlayButton.setImageResource(R.drawable.ic_pause_24px);
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.nextTrack();
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.prevTrack();
            }
        });
        restartGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stopAudio();
                audio = null;
                Intent nextScreen = new Intent(CowardEnding.this, HomeScreen.class);
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
            pausePlayButton.setImageResource(R.drawable.ic_play_arrow_24px);
        }
    }
}
