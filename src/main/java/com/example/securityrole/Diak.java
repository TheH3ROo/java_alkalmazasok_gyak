package com.example.securityrole;

import javax.persistence.*;
@Entity
@Table(name="diak")
public class Diak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nev;
    private String osztaly;
    private Boolean fiu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getOsztaly() {
        return osztaly;
    }

    public void setOsztaly(String osztaly) {
        this.osztaly = osztaly;
    }

    public Boolean getFiu() {
        return fiu;
    }

    public void setFiu(Boolean fiu) {
        this.fiu = fiu;
    }
}