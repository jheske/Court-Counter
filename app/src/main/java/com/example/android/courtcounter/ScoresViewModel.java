package com.example.android.courtcounter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

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
//https://github.com/googlesamples/android-architecture-components/blob/master/BasicSample/app/src/main/java/com/example/android/persistence/viewmodel/ProductViewModel.java
class ScoresViewModel extends ViewModel {

    // Create Model variables to hold team scores
    private int scoreTeamA;
    private int scoreTeamB;

    /**
     * Create MutableLiveData objects to dispatch Model updated values to Observers
     * MutableLiveData is a subclass of LiveData that allows you to change values using setValue()
     */
    private MutableLiveData<Integer> liveScoreTeamA;
    private MutableLiveData<Integer> liveScoreTeamB;

    ScoresViewModel(Integer extraPoints) {
        updateTeamAPoints(extraPoints);
    }

    /**
     * Instantiate LiveData Objects liveScoreBeamA and liveScoreTeamB
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

    /**
     * Update scoreTeamA and then call liveScoreTeamA.setValue(scoreTeamA)
     * to dispatch the new value to all Observers.
     */
    void updateTeamAPoints(int points) {
        scoreTeamA = scoreTeamA + points;
        getScoreTeamA().setValue(scoreTeamA);
    }

    /**
     * Update scoreTeamA and then call liveScoreTeamB.setValue(scoreTeamB)
     * to dispatch the new value to all Observers.
     */
    void updateTeamBPoints(Integer points) {
        scoreTeamB = scoreTeamB + points;
        liveScoreTeamB.setValue(scoreTeamB);
    }

}
