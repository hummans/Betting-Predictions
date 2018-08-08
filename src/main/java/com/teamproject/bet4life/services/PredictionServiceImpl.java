package com.teamproject.bet4life.services;

import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.repositories.base.PredictionRepository;
import com.teamproject.bet4life.services.base.PredictionService;
import org.springframework.stereotype.Service;

@Service
public class PredictionServiceImpl implements PredictionService {
    private PredictionRepository predictionRepository;

    public PredictionServiceImpl(PredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }

    @Override
    public boolean savePrediction(Prediction prediction) {
        return this.predictionRepository.savePrediction(prediction);
    }
}
