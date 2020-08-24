package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;
import java.util.ArrayList;

public class Aquarium implements Serializable {
    private ArrayList<Bewoner> bewoners = new ArrayList<Bewoner>();
    private ArrayList<Toebehoren>toebehoren = new ArrayList<Toebehoren>();
    private ArrayList<Ornament>ornaments = new ArrayList<Ornament>();

    private String naam;
    private int lengte;
    private int breedte;
    private int hoogte;
    private String bodemsoort;
    private String watersoort;

    public Aquarium(ArrayList<Bewoner> bewoners, ArrayList<Toebehoren> toebehoren, ArrayList<Ornament> ornaments, String naam, int lengte, int breedte, int hoogte, String bodemsoort, String watersoort) {
        this.bewoners = new ArrayList<Bewoner>();
        this.toebehoren = new ArrayList<Toebehoren>();
        this.ornaments = new ArrayList<Ornament>();
        this.naam = naam;
        this.lengte = lengte;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.bodemsoort = bodemsoort;
        this.watersoort = watersoort;
    }

    public ArrayList<Bewoner> getBewoners() {
        return bewoners;
    }

    public void setBewoners(ArrayList<Bewoner> bewoners) {
        this.bewoners = bewoners;
    }

    public ArrayList<Toebehoren> getToebehoren() {
        return toebehoren;
    }

    public void setToebehoren(ArrayList<Toebehoren> toebehoren) {
        this.toebehoren = toebehoren;
    }

    public ArrayList<Ornament> getOrnaments() {
        return ornaments;
    }

    public void setOrnaments(ArrayList<Ornament> ornaments) {
        this.ornaments = ornaments;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public int getBreedte() {
        return breedte;
    }

    public void setBreedte(int breedte) {
        this.breedte = breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public void setHoogte(int hoogte) {
        this.hoogte = hoogte;
    }

    public String getBodemsoort() {
        return bodemsoort;
    }

    public void setBodemsoort(String bodemsoort) {
        this.bodemsoort = bodemsoort;
    }

    public String getWatersoort() {
        return watersoort;
    }

    public void setWatersoort(String watersoort) {
        this.watersoort = watersoort;
    }

    public void addToebehoren(Toebehoren tb) {
        toebehoren.add(tb);
    }

    public void addBewoner(Bewoner bewoner) {
        bewoners.add(bewoner);
    }

    public void addOrnament(Ornament ornament) {
        ornaments.add(ornament);
    }
}
