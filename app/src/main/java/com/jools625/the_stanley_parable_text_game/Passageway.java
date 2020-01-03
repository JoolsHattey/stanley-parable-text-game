package com.jools625.the_stanley_parable_text_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Passageway extends AppCompatActivity {

    int[] audioIDs = {};
    ImageButton nextButton, prevButton, pausePlayButton;
    Button option1;
    AudioPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passageway);
        nextButton = findViewById(R.id.buttonNext);
        prevButton = findViewById(R.id.buttonPrev);
        pausePlayButton = findViewById(R.id.buttonPausePlay);

        nextButton.setClickable(false);
        nextButton.setAlpha(.5f);
        pausePlayButton.setClickable(false);
        pausePlayButton.setAlpha(.5f);
        prevButton.setClickable(false);
        prevButton.setAlpha(.5f);

        option1 = findViewById(R.id.buttonOption1);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(Passageway.this, Elevator.class);
                startActivity(nextScreen);
                finish();
            }
        });
    }
}
