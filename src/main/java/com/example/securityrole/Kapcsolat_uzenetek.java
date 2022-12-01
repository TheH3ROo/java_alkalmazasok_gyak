package com.example.securityrole;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="uzenetek")
public class Kapcsolat_uzenetek {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String bekuldo;
        private String cim;
        private String uzenet;
        private Date datum;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getBekuldo() {
                return bekuldo;
        }

        public void setBekuldo(String bekuldo) {
                this.bekuldo = bekuldo;
        }

        public String getCim() {
                return cim;
        }

        public void setCim(String cim) {
                this.cim = cim;
        }

        public String getUzenet() {
                return uzenet;
        }

        public void setUzenet(String uzenet) {
                this.uzenet = uzenet;
        }

        public Date getDatum() {
                return datum;
        }

        public void setDatum(Date datum) {
                this.datum = datum;
        }
}