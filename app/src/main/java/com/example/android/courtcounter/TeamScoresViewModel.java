package com.example.android.courtcounter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by jill on {DATE}
 */
public class TeamScoresViewModel extends ViewModel {

    // Create Model variables to hold team scores
    int scoreTeamA;
    int scoreTeamB;

    /**
     * Create MutableLiveData objects to dispatch Model updated values to Observers
     * MutableLiveData is a subclass of LiveData that allows you to change values using setValue()
     */
    private MutableLiveData<Integer> liveScoreTeamA;
    private MutableLiveData<Integer> liveScoreTeamB;

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
