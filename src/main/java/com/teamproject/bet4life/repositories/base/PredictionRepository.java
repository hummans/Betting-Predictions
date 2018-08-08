package com.teamproject.bet4life.repositories.base;

import com.teamproject.bet4life.models.Prediction;

public interface PredictionRepository {
    boolean savePrediction(Prediction prediction);
}
