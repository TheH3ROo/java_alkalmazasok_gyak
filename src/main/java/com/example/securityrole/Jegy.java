package com.example.securityrole;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="jegy")
public class Jegy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer diakid;
    private Date datum;
    private Integer ertek;
    private String tipus;
    private Integer targyid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiakid() {
        return diakid;
    }

    public void setDiakid(Integer diakid) {
        this.diakid = diakid;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getErtek() {
        return ertek;
    }

    public void setErtek(Integer ertek) {
        this.ertek = ertek;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public Integer getTargyid() {
        return targyid;
    }

    public void setTargyid(Integer targyid) {
        this.targyid = targyid;
    }
}