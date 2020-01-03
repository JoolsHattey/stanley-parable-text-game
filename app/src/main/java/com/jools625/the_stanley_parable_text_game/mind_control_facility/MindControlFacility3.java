package com.jools625.the_stanley_parable_text_game.mind_control_facility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.jools625.the_stanley_parable_text_game.AudioPlayer;
import com.jools625.the_stanley_parable_text_game.EmployeeLounge;
import com.jools625.the_stanley_parable_text_game.ExitEmployeeLounge;
import com.jools625.the_stanley_parable_text_game.R;

public class MindControlFacility3 extends AppCompatActivity {

    int[] audioIDs = {R.raw.monitor_3_00, R.raw.monitor_3_01, R.raw.monitor_3_02};
    ImageButton nextButton, prevButton, pausePlayButton;
    Button option1;
    AudioPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_control_facility3);
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
                Intent nextScreen = new Intent(MindControlFacility3.this, MindControlFacility4.class);
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
