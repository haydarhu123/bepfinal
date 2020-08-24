package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;

public class Bewoner implements Serializable {
    protected String soortnaam;
    protected String kleurnaam;
    protected int aantal;
    protected boolean groepsDier;

    public Bewoner(String soortnaam, String kleurnaam, int aantal, boolean groepsDier) {
        this.soortnaam = soortnaam;
        this.kleurnaam = kleurnaam;
        this.aantal = aantal;
        this.groepsDier = groepsDier;
    }
    public String getSoortnaam() {
        return soortnaam;
    }

    public void setSoortnaam(String soortnaam) {
        this.soortnaam = soortnaam;
    }

    public String getKleurnaam() {
        return kleurnaam;
    }

    public void setKleurnaam(String kleurnaam) {
        this.kleurnaam = kleurnaam;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public boolean isGroepsDier() {
        return groepsDier;
    }

    public void setGroepsDier(boolean groepsDier) {
        this.groepsDier = groepsDier;
    }


}
