package com.example.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

    private List<Voto> voti;

    public Libretto(){
        this.voti = new ArrayList<>();
    }

    /**
     *  Aggiungi un nuovo voto al libretto
     *  (per ora non fa nessun controllo)
     * @param voto è il voto da aggiungere
     * @return true
     */
    public boolean add(Voto voto){
        return this.voti.add(voto);
    }

    public void stampaVoti(){
        voti.forEach(voto -> {
            System.out.println(voto);
        });
    }
}
