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

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {

    // ViewModel containing team scores and LiveData objects
    // for dispatching updates
    ScoresViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create extra points
        int extraPoints = 10;
        // Create a factory for instantiating ViewModel with the extraPoints argument
        ScoresViewModelFactory scoresViewModelFactory = new ScoresViewModelFactory(extraPoints);
        // Use the factory to create a ViewModel with arguments
        mViewModel = ViewModelProviders.of(this, scoresViewModelFactory).get(ScoresViewModel.class);
        /*
         * Create observer to receive score changes from ViewModel and update the UI
         */
        final Observer<Integer> teamAScoreObserver = new Observer<Integer>() {
            @Override
            public void onChanged(final Integer newScore) {
                // Update the UI with teamA score data
                displayForTeamA(newScore);
            }
        };

        final Observer<Integer> teamBScoreObserver = new Observer<Integer>() {
            @Override
            public void onChanged(final Integer score) {
                // Update the UI with teamA score data
                displayForTeamB(score);
            }
        };

        /*
         * Create observers to wait for ViewModel to dispatch changes.
         * Pass in this Activity as the LifecycleOwner and the observer.
         */
        mViewModel.getScoreTeamA().observe(this, teamAScoreObserver);
        mViewModel.getScoreTeamB().observe(this, teamBScoreObserver);

    }

    /**
     * Call ViewModel to increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        mViewModel.updateTeamAPoints(1);
    }

    /**
     * Call ViewModel to increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        mViewModel.updateTeamAPoints(2);
    }

    /**
     * Call ViewModel to increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        mViewModel.updateTeamAPoints(3);
    }

    /**
     * Call ViewModel to increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        mViewModel.updateTeamBPoints(1);
    }

    /**
     * Call ViewModel to increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        mViewModel.updateTeamBPoints(2);
    }

    /**
     * Call ViewModel to increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        mViewModel.updateTeamBPoints(3);
    }

    /**
     * Call ViewModel to reset the score for both teams back to 0.
     */
    public void resetScore(View v) {
        mViewModel.updateTeamAPoints(0);
        mViewModel.updateTeamBPoints(0);
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
