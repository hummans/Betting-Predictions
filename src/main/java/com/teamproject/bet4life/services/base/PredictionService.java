package com.teamproject.bet4life.services.base;

import com.teamproject.bet4life.models.Prediction;

import java.util.List;

public interface PredictionService {
    List<Prediction> getAll();
    List<Prediction> getLatest5();
    boolean savePrediction(Prediction prediction);
}
