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
         * Create observers to receive score and freeThrow changes from ViewModel and update the UI
         */
        final Observer<Integer> teamAScoreObserver = new Observer<Integer>() {
            @Override
            public void onChanged(final Integer score) {
                displayScoreForTeamA(score);
            }
        };

        final Observer<Integer> teamBScoreObserver = new Observer<Integer>() {
            @Override
            public void onChanged(final Integer score) {
                displayScoreForTeamB(score);
            }
        };

        final Observer<Integer> teamAFreeThrowObserver = new Observer<Integer>() {
            @Override
            public void onChanged(final Integer freeThrows) {
                displayFreeThrowsForTeamA(freeThrows);
            }
        };

        final Observer<Integer> teamBFreeThrowObserver = new Observer<Integer>() {
            @Override
            public void onChanged(final Integer freeThrows) {
                displayFreeThrowsForTeamB(freeThrows);
            }
        };

        // Begin observing LiveData.  "this" Activity is the LifecycleOwner, which
        // handles Lifecycle events (configuration changes!) automatically.
        mViewModel.getScoreTeamA().observe(this, teamAScoreObserver);
        mViewModel.getScoreTeamB().observe(this, teamBScoreObserver);
        mViewModel.getFreeThrowsTeamA().observe(this, teamAFreeThrowObserver);
        mViewModel.getFreeThrowsTeamB().observe(this, teamBFreeThrowObserver);
    }

    /**
     * Call ViewModel to increase the score for Team A by 1 point.
     */
    public void freeThrowTeamA(View v) {
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
    public void freeThrowTeamB(View v) {
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
        mViewModel.resetScores();
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayScoreForTeamA(int score) {
        TextView scoreView =  findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFreeThrowsForTeamA(int freeThrows) {
        TextView freeThrowsView =  findViewById(R.id.team_a_free_throws);
        freeThrowsView.setText(String.valueOf(freeThrows));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayScoreForTeamB(int score) {
        TextView scoreView =  findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFreeThrowsForTeamB(int freeThrows) {
        TextView freeThrowsView =  findViewById(R.id.team_b_free_throws);
        freeThrowsView.setText(String.valueOf(freeThrows));
    }
}
