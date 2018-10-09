package com.example.android.courtcounter;

import android.arch.lifecycle.MutableLiveData;
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

    private int scoreTeamA;
    private int scoreTeamB;
    private int freeThrowsTeamA;
    private int freeThrowsTeamB;

    /**
     * Create MutableLiveData objects to dispatch updated values to Observers
     * MutableLiveData is a subclass of LiveData that allows you to change values using setValue()
     */
    private MutableLiveData<Integer> liveScoreTeamA;
    private MutableLiveData<Integer> liveScoreTeamB;
    private MutableLiveData<Integer> liveFreeThrowsTeamA;
    private MutableLiveData<Integer> liveFreeThrowsTeamB;

    /**
     * Instantiate LiveData Objects for scores and freeThrows
     * Their values will be dispatched to all Observers whenever they are changed using setValue().
     */
    MutableLiveData<Integer> getScoreTeamA() {
        if (liveScoreTeamA == null)
            liveScoreTeamA = new MutableLiveData<>();
        return liveScoreTeamA;
    }

    MutableLiveData<Integer> getScoreTeamB() {
        if (liveScoreTeamB == null)
            liveScoreTeamB = new MutableLiveData<>();
        return liveScoreTeamB;
    }

    MutableLiveData<Integer> getFreeThrowsTeamA() {
        if (liveFreeThrowsTeamA == null)
            liveFreeThrowsTeamA = new MutableLiveData<>();
        return liveFreeThrowsTeamA;
    }

    MutableLiveData<Integer> getFreeThrowsTeamB() {
        if (liveFreeThrowsTeamB == null)
            liveFreeThrowsTeamB = new MutableLiveData<>();
        return liveFreeThrowsTeamB;
    }

    /**
     * Update scoreTeamA and then call liveScoreTeamA.setValue(scoreTeamA)
     * to dispatch the new value to all Observers.
     */
    void updateTeamAPoints(int points) {
        scoreTeamA = scoreTeamA + points;
        liveScoreTeamA.setValue(scoreTeamA);
        if (points == 1) {
            freeThrowsTeamA = freeThrowsTeamA + 1;
            getFreeThrowsTeamA().setValue(freeThrowsTeamA);
        }
    }

    /**
     * Update scoreTeamA and then call liveScoreTeamB.setValue(scoreTeamB)
     * to dispatch the new value to all Observers.
     */
    void updateTeamBPoints(Integer points) {
        scoreTeamB = scoreTeamB + points;
        liveScoreTeamB.setValue(scoreTeamB);
        if (points == 1) {
            freeThrowsTeamB = freeThrowsTeamB + 1;
            getFreeThrowsTeamB().setValue(freeThrowsTeamB);
        }
    }

    void resetScores() {
        // Update model
        scoreTeamA = 0;
        scoreTeamB = 0;
        freeThrowsTeamA = 0;
        freeThrowsTeamB = 0;
        // Dispatch values to observers.
        getScoreTeamA().setValue(scoreTeamA);
        getScoreTeamB().setValue(scoreTeamB);
        getFreeThrowsTeamA().setValue(freeThrowsTeamA);
        getFreeThrowsTeamB().setValue(freeThrowsTeamB);
    }
}
