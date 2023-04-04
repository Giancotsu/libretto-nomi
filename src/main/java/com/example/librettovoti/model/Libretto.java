package com.example.librettovoti.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        if(!conflitto(voto) && !duplicato(voto)){
            return this.voti.add(voto);
        }else{
            throw new IllegalArgumentException("L'esame " + voto.getNomeCorso() + " risiede già nel libretto.");
        }
    }

    public List<Voto> stampaVoti(){
        voti.forEach(voto -> {
            System.out.println(voto);
        });
        return this.voti;
    }

    public void stampaVoti(int v){
        voti.forEach(voto -> {
            if(voto.getVoto()==v) {
                System.out.println(voto);
            }
        });
    }

    public void stampaVoti(String nomeCorsoDaCercare){
        voti.forEach(voto -> {
            if(voto.getNomeCorso().equals(nomeCorsoDaCercare)) {
                System.out.println(voto);
            }
        });
    }

    public boolean duplicato(Voto nuovo) {
        for(Voto v: this.voti) {
            if(v.isDuplicate(nuovo))
            {
                return true ;
            }
        }
        return false;
    }

    public boolean conflitto(Voto nuovo){
        for(Voto v: this.voti){
            if(v.isCollision(nuovo)){
                return true;
            }
        }
        return false;
    }

    /*
    public Libretto librettoMigliorato(){
        Libretto lib = new Libretto();
        Voto votoMoment;
        for(Voto v: this.voti) {
            if(v.getVoto()<18){
                votoMoment = new Voto(v.getNomeCorso(), v.getVoto(), v.getDataEsame());
                lib.add(votoMoment);
            }
            if(v.getVoto()>=18 && v.getVoto()<24){
                votoMoment = new Voto(v.getNomeCorso(), v.getVoto()+1, v.getDataEsame());
                lib.add(votoMoment);
            }
            if(v.getVoto()>=24 && v.getVoto()<29){
                votoMoment = new Voto(v.getNomeCorso(), v.getVoto()+2, v.getDataEsame());
                lib.add(votoMoment);
            }
            if(v.getVoto()>28){
                votoMoment = new Voto(v.getNomeCorso(), 30, v.getDataEsame());
                lib.add(votoMoment);
            }
        }
        return lib;
    }
     */

    public Libretto librettoMigliorato() {
        Libretto migliore = new Libretto() ;
        migliore.voti = new ArrayList<>() ;
        for(Voto v: this.voti) {
            migliore.voti.add(v.clone()) ;
//			migliore.voti.add(new Voto(v)) ;
        }
        for(Voto v : migliore.voti ) {

            if(v.getVoto()>28){
                v.setVoto(30);
            }

            if(v.getVoto()>=24 && v.getVoto()<=28){
                v.setVoto(v.getVoto()+2);
            }

            if(v.getVoto()>=18 && v.getVoto()<24){
                v.setVoto(v.getVoto()+1);
            }
        }
        return migliore ;
    }

    public void cancellaVotiInferiori(int punti) {
        List<Voto> daCancellare = new ArrayList<Voto>();
        for(Voto v: this.voti) {
            if(v.getVoto()<punti) {
                daCancellare.add(v) ;
            }
        }
        /*
        for(Voto v1: daCancellare) {
            this.voti.remove(v1) ;
        }
         */

        this.voti.removeAll(daCancellare) ;
    }

    public Libretto librettoOrdinatoNome(){

        Libretto ordinato = new Libretto();
        ordinato.voti = new ArrayList<>(this.voti);

        Collections.sort(ordinato.voti, new ComparatorByName());

        return ordinato;
    }

    public Libretto librettoOrdinatoVotoDec(){

        Libretto ordinato = new Libretto();
        ordinato.voti = new ArrayList<>(this.voti);

        ordinato.voti.sort(new Comparator<Voto>() {
            @Override
            public int compare(Voto o1, Voto o2) {
                return o2.getVoto()-o1.getVoto();
            }
        });

        return ordinato;
    }
}

































