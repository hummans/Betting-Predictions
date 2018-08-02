package com.teamproject.bet4life.repositories.base;

import com.teamproject.bet4life.models.Prediction;

import java.util.List;

public interface PredictionRepository {
    List<Prediction> getAll();
    List<Prediction> getLatest3Predictions();
}
