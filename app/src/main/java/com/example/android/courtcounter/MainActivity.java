/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {

    // Tracks the score for Team A
    int scoreTeamA = 0;

    // Tracks the score for Team B
    int scoreTeamB = 0;

    // 1, 2, and three point counters
    int onePointCountTeamA = 0;
    int twoPointCountTeamA = 0;
    int threePointCountTeamA = 0;
    int onePointCountTeamB = 0;
    int twoPointCountTeamB = 0;
    int threePointCountTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        onePointCountTeamA = onePointCountTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        twoPointCountTeamA = twoPointCountTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        threePointCountTeamA = threePointCountTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        onePointCountTeamB = onePointCountTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        twoPointCountTeamB = twoPointCountTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        threePointCountTeamB = threePointCountTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        onePointCountTeamA = 0;
        twoPointCountTeamA = 0;
        threePointCountTeamA = 0;
        onePointCountTeamB = 0;
        twoPointCountTeamB = 0;
        threePointCountTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView =  findViewById(R.id.team_a_score);
        TextView onePointView =  findViewById(R.id.team_a_one_point);
        TextView twoPointView =  findViewById(R.id.team_a_two_point);
        TextView threePointView = findViewById(R.id.team_a_three_point);
        threePointView.setText("+3 Points " + String.valueOf(onePointCountTeamA) + ")");
        twoPointView.setText("+2 Points " + String.valueOf(twoPointCountTeamA) + ")");
        onePointView.setText("Free Throw " + String.valueOf(threePointCountTeamA) + ")");
        scoreView.setText("SCORE " + String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView =  findViewById(R.id.team_b_score);
        TextView onePointView =  findViewById(R.id.team_b_one_point);
        TextView twoPointView = findViewById(R.id.team_b_two_point);
        TextView threePointView = findViewById(R.id.team_b_three_point);
        threePointView.setText("+3 Points (" + String.valueOf(onePointCountTeamB) + ")");
        twoPointView.setText("+2 Points (" + String.valueOf(twoPointCountTeamB) + ")");
        onePointView.setText("Free Throw (" + String.valueOf(threePointCountTeamB) + ")");
        scoreView.setText("SCORE " + String.valueOf(score));
    }
}
