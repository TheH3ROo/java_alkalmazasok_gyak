package com.example.securityrole;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NaploRepository extends CrudRepository<Naplo, Integer> {
    @Query(value="SELECT diak.id as id, diak.osztaly as osztaly,diak.nev as nev,Cast(Case When diak.fiu=0 Then 'Lány' " +
            "ELSE 'Fiú' END AS VARCHAR(20)) As nem,targy.nev as targynev,jegy.tipus as tipus,jegy.ertek as ertek, " +
            "jegy.datum as datum FROM diak " +
            "inner join jegy on diak.id=jegy.diakid " +
            "inner join targy on jegy.targyid=targy.id", nativeQuery = true)
    List<Naplo> findAllNaploBejegyzes();
}