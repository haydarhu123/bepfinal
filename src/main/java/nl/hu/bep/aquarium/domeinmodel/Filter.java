package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;

public class Filter extends Toebehoren implements Serializable {
    private boolean isExtern;

    public Filter(String model, String serienummer, boolean isExtern, int aantalLiter) {
        super(model, serienummer);
        this.isExtern = isExtern;
        this.aantalLiter = aantalLiter;
    }

    public boolean isExtern() {
        return isExtern;
    }

    public void setExtern(boolean extern) {
        isExtern = extern;
    }

    public int getAantalLiter() {
        return aantalLiter;
    }

    public void setAantalLiter(int aantalLiter) {
        this.aantalLiter = aantalLiter;
    }

    private int aantalLiter;
}
