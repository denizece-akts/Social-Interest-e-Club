package com.example.webapp.club;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "clubs")
public class Club {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    private String club_admin;
    private String clubname;
    private String permissions;

    private double rate;
    private Integer rateCount;


    public Club(){

    }
    public Club(String club_admin, String clubname, String permissions){
        super();
        this.club_admin = club_admin;
        this.clubname = clubname;
        this.permissions = permissions;
        this.rate = 0.0;
        this.rateCount = 0;
    }

    public void addRate(double rate) {
        rateCount++;
        double newRate = (this.rate + rate) / rateCount;
        this.rate = newRate;
    }

    public double getRate() {
        return rate;
    }


    @Id
    public long getId() {
        return id;
    }
}
