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
        displayForTeamA();
        displayForTeamB();
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void freeThrowTeamA(View v) {
        mViewModel.updateTeamAScore(1);
        displayForTeamA();
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        mViewModel.updateTeamAScore(2);
        displayForTeamA();
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        mViewModel.updateTeamAScore(3);
        displayForTeamA();
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void freeThrowTeamB(View v) {
        mViewModel.updateTeamBScore(1);
        displayForTeamB();
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        mViewModel.updateTeamAScore(2);
        displayForTeamB();
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        mViewModel.updateTeamAScore(3);
        displayForTeamB();
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        mViewModel.resetScores();
        displayForTeamA();
        displayForTeamB();
    }

    /**
     * Get and display values from ScoresViewModel
     */
    public void displayForTeamA() {
        TextView scoreView =  findViewById(R.id.team_a_score);
        TextView freeThrowsView =  findViewById(R.id.team_a_free_throws);
        scoreView.setText(String.valueOf(mViewModel.scoreTeamA));
        freeThrowsView.setText("Free Throws (" + String.valueOf(mViewModel.freeThrowsTeamA) + ")");
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB() {
        TextView scoreView =  findViewById(R.id.team_b_score);
        TextView freeThrowsView =  findViewById(R.id.team_b_free_throws);
        scoreView.setText(String.valueOf(mViewModel.scoreTeamB));
        freeThrowsView.setText("Free Throws (" + String.valueOf(mViewModel.freeThrowsTeamB) + ")");
    }
}
