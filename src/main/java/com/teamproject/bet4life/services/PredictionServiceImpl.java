package com.teamproject.bet4life.services;

import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.repositories.base.PredictionRepository;
import com.teamproject.bet4life.services.base.PredictionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {
    private PredictionRepository predictionRepository;

    public PredictionServiceImpl(PredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }

    @Override
    public List<Prediction> getAll() {
        return this.predictionRepository.getAll();
    }

    @Override
    public boolean savePrediction(Prediction prediction) {
        return this.predictionRepository.savePrediction(prediction);
    }
}
