package com.teamproject.bet4life.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users_bets")
public class UserBet {
    private int id;
    private User user;
    private Bet bet;
    private UserBetPrediction outcome;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Id
    @GeneratedValue
    @Column(name = "user_bet_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "betID")
    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "outcome")
    public UserBetPrediction getOutcome() {
        return outcome;
    }

    public void setOutcome(UserBetPrediction outcome) {
        this.outcome = outcome;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
