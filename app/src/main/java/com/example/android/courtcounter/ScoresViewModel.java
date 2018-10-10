package com.example.android.courtcounter;

import android.arch.lifecycle.ViewModel;

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
class ScoresViewModel extends ViewModel {

    // Create Model variables to hold team scores
    int scoreTeamA;
    int scoreTeamB;

    // Free throw counters
    int freeThrowsTeamA = 0;
    int freeThrowsTeamB = 0;

    void updateTeamAScore(int points) {
        scoreTeamA = scoreTeamA + points;
        if (points == 1) {
            freeThrowsTeamA  = freeThrowsTeamA + 1;
        }
    }

    void updateTeamBScore(int points) {
        scoreTeamB = scoreTeamB + points;
        if (points == 1) {
            freeThrowsTeamB  = freeThrowsTeamB + 1;
        }
    }

    void resetScores() {
        scoreTeamA = 0;
        scoreTeamB = 0;
        freeThrowsTeamA = 0;
        freeThrowsTeamB = 0;
    }
}
