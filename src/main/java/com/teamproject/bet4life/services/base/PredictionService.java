package com.teamproject.bet4life.services.base;

import com.teamproject.bet4life.models.Prediction;

import java.util.List;

public interface PredictionService {
    List<Prediction> getAll();
    boolean savePrediction(Prediction prediction);
}
