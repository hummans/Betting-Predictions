package com.teamproject.bet4life.services;

import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.repositories.base.PredictionRepository;
import com.teamproject.bet4life.services.base.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {
    private PredictionRepository predictionRepository;

    @Autowired
    public PredictionServiceImpl(PredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }

    @Override
    public List<Prediction> getAll() {
        return predictionRepository.getAll();
    }

    @Override
    public List<Prediction> getLatest3Predictions() {
        return predictionRepository.getLatest3Predictions();
    }


}
