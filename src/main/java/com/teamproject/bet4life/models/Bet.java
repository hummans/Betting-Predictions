package com.teamproject.bet4life.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "betID")
    private int id;


    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @OneToMany(mappedBy = "bet", fetch = FetchType.EAGER)
    private List<Prediction> predictions;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    public Bet() {
        this.predictions = new ArrayList<>();
    }

    public Bet(String description) {
        this.description = description;

        this.date = new Date();
        this.predictions = new ArrayList<>();
    }
}
