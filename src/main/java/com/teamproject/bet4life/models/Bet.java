package com.teamproject.bet4life.models;

import javax.persistence.*;

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "betID")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private betType type;

    @Column(name = "description")
    private String description;

    @Column(name = "outcomeA")
    private String outcomeA;

    @Column(name = "outcomeB")
    private String outcomeB;

    public Bet(){
    }

    public Bet(betType type, String description, String outcomeA, String outcomeB) {
        this.type = type;
        this.description = description;
        this.outcomeA = outcomeA;
        this.outcomeB = outcomeB;
    }

    public betType getType() {
        return type;
    }

    public void setType(betType type) {
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

    @Override
    public String toString() {
        return "Bet{" + "id=" + id + ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", outcomeA='" + outcomeA + '\'' +
                ", outcomeB='" + outcomeB + '\'' + '}';
    }
}
