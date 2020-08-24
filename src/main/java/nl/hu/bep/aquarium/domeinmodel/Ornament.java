package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;

public class Ornament implements Serializable {
    private String naam;
    private String omschrijving;
    private String kleur;
    private boolean kanOpLuchtpomp;

    public Ornament(String naam, String omschrijving, String kleur, boolean kanOpLuchtpomp) {
        this.naam = naam;
        this.omschrijving = omschrijving;
        this.kleur = kleur;
        this.kanOpLuchtpomp = kanOpLuchtpomp;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public boolean isKanOpLuchtpomp() {
        return kanOpLuchtpomp;
    }

    public void setKanOpLuchtpomp(boolean kanOpLuchtpomp) {
        this.kanOpLuchtpomp = kanOpLuchtpomp;
    }
}
