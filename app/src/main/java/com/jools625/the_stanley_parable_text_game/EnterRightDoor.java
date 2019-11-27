package com.jools625.the_stanley_parable_text_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class EnterRightDoor extends AppCompatActivity {

    int[] audioIDs = {R.raw.two_doors_right_00};
    ImageButton nextButton, prevButton;
    Button option1, option2;
    AudioPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_right_door);

        nextButton = findViewById(R.id.buttonNext);
        prevButton = findViewById(R.id.buttonPrev);
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
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stopAudio();
                //Intent nextScreen = new Intent(LeftRightDoor.this, CowardEnding.class);
                //startActivity(nextScreen);
            }
        });
    }
}
