package com.teamproject.bet4life.bindingModels;

import javax.validation.constraints.NotNull;

public class PredictionBindingModel {
    @NotNull
    private String betDescription;

    @NotNull
    private String content;

    public String getBetDescription() {
        return betDescription;
    }

    public void setBetDescription(String betDescription) {
        this.betDescription = betDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
