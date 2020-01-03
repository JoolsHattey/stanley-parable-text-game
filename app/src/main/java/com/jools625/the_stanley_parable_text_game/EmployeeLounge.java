package com.jools625.the_stanley_parable_text_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class EmployeeLounge extends AppCompatActivity {

    int[] audioIDs = {R.raw.lounge_1a_00, R.raw.lounge_1a_01, R.raw.lounge_1b_00, R.raw.lounge_1b_01
                    , R.raw.lounge_2_00, R.raw.lounge_3_00, R.raw.lounge_4_00};
    ImageButton nextButton, prevButton, pausePlayButton;
    Button option1;
    AudioPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_lounge);
        nextButton = findViewById(R.id.buttonNext);
        prevButton = findViewById(R.id.buttonPrev);
        option1 = findViewById(R.id.buttonOption1);

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
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stopAudio();
                Intent nextScreen = new Intent(EmployeeLounge.this, ExitEmployeeLounge.class);
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
