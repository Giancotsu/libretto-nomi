package com.example.librettovoti.model;

import java.time.LocalDate;

public class Voto {

    private String nomeCorso;
    private Integer voto;
    private LocalDate dataEsame;

    public Voto() {
    }

    public Voto(String nomeCorso, Integer voto, LocalDate dataEsame) {
        this.nomeCorso = nomeCorso;
        this.voto = voto;
        this.dataEsame = dataEsame;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }

    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public LocalDate getDataEsame() {
        return dataEsame;
    }

    public void setDataEsame(LocalDate dataEsame) {
        this.dataEsame = dataEsame;
    }

    public boolean isDuplicate(Voto altro){
        return this.nomeCorso.equals(altro.nomeCorso) &&
                this.voto == altro.getVoto();
    }

    public boolean isCollision(Voto altro){
        return this.nomeCorso.equals(altro.nomeCorso) &&
                this.voto != altro.getVoto();
    }

    @Override
    public String toString() {
        return "Voto{" +
                "nomeCorso='" + nomeCorso + '\'' +
                ", voto=" + voto +
                ", dataEsame=" + dataEsame +
                '}';
    }
}
