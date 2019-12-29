package com.jools625.the_stanley_parable_text_game.death_ending;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.jools625.the_stanley_parable_text_game.AudioPlayer;
import com.jools625.the_stanley_parable_text_game.R;

public class LucidDreaming extends AppCompatActivity {

    int[] audioIDs = {R.raw.dream_1a_11, R.raw.dream_1a_12, R.raw.dream_1a_13, R.raw.dream_1a_14
                    , R.raw.dream_1a_15, R.raw.dream_1a_16 ,R.raw.dream_1a_17 ,R.raw.dream_1a_18
                    , R.raw.dream_1a_19, R.raw.dream_1a_20, R.raw.dream_1a_21 ,R.raw.dream_1a_22
                    , R.raw.dream_1a_23};
    ImageButton nextButton, prevButton;
    Button option1;
    AudioPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucid_dreaming);
        nextButton = findViewById(R.id.buttonNext);
        prevButton = findViewById(R.id.buttonPrev);
        option1 = findViewById(R.id.buttonOption1);

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
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stopAudio();
                Intent nextScreen = new Intent(LucidDreaming.this, CloseEyes.class);
                startActivity(nextScreen);
                finish();
            }
        });

    }
    @Override
    protected void onPause() {
        super.onPause();
        if ((audio != null) && (audio.isPlaying())) {
            audio.pause();
        }
    }
}
