package com.teamproject.bet4life.models;

import javax.persistence.*;

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "betID")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "outcomeA")
    private String outcomeA;

    @Column(name = "outcomeB")
    private String outcomeB;

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

    public Bet() {
    }

    public Bet(String description, String outcomeA, String outcomeB) {
        this.description = description;
        this.outcomeA = outcomeA;
        this.outcomeB = outcomeB;
    }
}
