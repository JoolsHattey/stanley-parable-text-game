package com.jools625.the_stanley_parable_text_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class EmployeeLounge extends AppCompatActivity {

    int[] audioIDs = {};
    ImageButton nextButton, prevButton;
    Button option1;
    AudioPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_lounge);
    }
}
