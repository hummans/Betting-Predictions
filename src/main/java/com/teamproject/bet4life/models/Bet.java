package com.teamproject.bet4life.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "betID")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private BetType type;

    @Column(name = "description")
    private String description;

    @Column(name = "outcomeA")
    private String outcomeA;

    @Column(name = "outcomeB")
    private String outcomeB;

    @OneToMany(mappedBy = "bet")
    private Set<UserBet> userBets = new HashSet<UserBet>();

    @OneToMany(mappedBy = "bet")
    private List<Prediction> predictions;

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    public Bet(){
    }

    public Bet(BetType type, String description, String outcomeA, String outcomeB) {
        this.type = type;
        this.description = description;
        this.outcomeA = outcomeA;
        this.outcomeB = outcomeB;
    }

    public BetType getType() {
        return type;
    }

    public void setType(BetType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOutcomeA() {
        return outcomeA;
    }

    public void setOutcomeA(String outcomeA) {
        this.outcomeA = outcomeA;
    }

    public String getOutcomeB() {
        return outcomeB;
    }

    public void setOutcomeB(String outcomeB) {
        this.outcomeB = outcomeB;
    }


    public Set<UserBet> getUserBets() {
        return userBets;
    }

    public void setUserBets(Set<UserBet> userBets) {
        this.userBets = userBets;
    }

    @Override
    public String toString() {
        return "Bet{" + "id=" + id + ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", outcomeA='" + outcomeA + '\'' +
                ", outcomeB='" + outcomeB + '\'' + '}';
    }
}
