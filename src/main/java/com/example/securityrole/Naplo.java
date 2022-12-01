package com.example.securityrole;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="naplo")
public class Naplo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String osztaly;
    private String nev;
    private String nem;
    private String targynev;
    private String tipus;
    private Integer ertek;
    private Date datum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOsztaly() {
        return osztaly;
    }

    public void setOsztaly(String osztaly) {
        this.osztaly = osztaly;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public String getTargynev() {
        return targynev;
    }

    public void setTargynev(String targynev) {
        this.targynev = targynev;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public Integer getErtek() {
        return ertek;
    }

    public void setErtek(Integer ertek) {
        this.ertek = ertek;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}