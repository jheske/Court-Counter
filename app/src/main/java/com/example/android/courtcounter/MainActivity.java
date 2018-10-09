/*
 * Copyright (C) 2018 The Android Open Source Project
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

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {

    // ViewModel containing team scores
    ScoresViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Retrieve data from teamScoresViewModel
        mViewModel = ViewModelProviders.of(this).get(ScoresViewModel.class);
        displayForTeamA(mViewModel.scoreTeamA);
        displayForTeamB(mViewModel.scoreTeamB);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        //Remove local reference
        //scoreTeamA = scoreTeamA + 1;

        mViewModel.scoreTeamA = mViewModel.scoreTeamA + 1;
        mViewModel.onePointCountTeamA = mViewModel.onePointCountTeamA + 1;
        displayForTeamA(mViewModel.scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        mViewModel.scoreTeamA = mViewModel.scoreTeamA + 2;
        mViewModel.twoPointCountTeamA = mViewModel.twoPointCountTeamA + 1;
        displayForTeamA(mViewModel.scoreTeamA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        mViewModel.scoreTeamA = mViewModel.scoreTeamA + 3;
        displayForTeamA(mViewModel.scoreTeamA);

        mViewModel.threePointCountTeamA = mViewModel.threePointCountTeamA + 1;
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        mViewModel.scoreTeamB = mViewModel.scoreTeamB + 1;
        mViewModel.onePointCountTeamB = mViewModel.onePointCountTeamB + 1;
        displayForTeamB(mViewModel.scoreTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        mViewModel.scoreTeamB = mViewModel.scoreTeamB + 2;
        mViewModel.twoPointCountTeamB = mViewModel.twoPointCountTeamB + 1;
        displayForTeamB(mViewModel.scoreTeamB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        mViewModel.scoreTeamB = mViewModel.scoreTeamB + 3;
        mViewModel.threePointCountTeamB = mViewModel.threePointCountTeamB + 1;
        displayForTeamB(mViewModel.scoreTeamB);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        mViewModel.scoreTeamA = 0;
        mViewModel.scoreTeamB = 0;
        mViewModel.onePointCountTeamA = 0;
        mViewModel.twoPointCountTeamA = 0;
        mViewModel.threePointCountTeamA = 0;
        mViewModel.onePointCountTeamB = 0;
        mViewModel.twoPointCountTeamB = 0;
        mViewModel.threePointCountTeamB = 0;        
        displayForTeamA(mViewModel.scoreTeamA);
        displayForTeamB(mViewModel.scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
