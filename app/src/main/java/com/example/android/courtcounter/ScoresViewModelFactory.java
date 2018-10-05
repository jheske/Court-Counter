package com.example.android.courtcounter;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
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
public class ScoresViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    // The argument we want to pass to ScoresViewModel
    private final Integer extraPoints;

    ScoresViewModelFactory(int extraPoints) {
        this.extraPoints = extraPoints;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    // Factory method to create an instance of ViewModel or one of its subclasses
    // Under the hood this calls ScoresViewModel.newInstance(), which calls a ScoresViewModel constructor.
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ScoresViewModel(extraPoints);
    }
}
