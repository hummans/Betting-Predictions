package com.teamproject.bet4life.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="predictions")
public class Prediction {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="predictionID")
    private int id;

    @Column(name="content")
    private String content;

    @Temporal(TemporalType.DATE)
    private Date datePublished;

    @ManyToOne
    @JoinColumn(name="userID")
    private User user;

    @ManyToOne
    @JoinColumn(name="betID")
    private Bet bet;

    public Prediction() {
    }

    public Prediction(String content, Date datePublished, User user, Bet bet) {
        this.content = content;
        this.datePublished = datePublished;
        this.user = user;
        this.bet = bet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
}
