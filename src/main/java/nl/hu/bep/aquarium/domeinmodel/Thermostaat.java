package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;

public class Thermostaat extends Toebehoren implements Serializable {
    private int minTemp;
    private int maxTemp;
    private int huidigeTempingesteld;

    public Thermostaat(String model, String serienummer, int minTemp, int maxTemp, int huidigeTempingesteld) {
        super(model, serienummer);
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.huidigeTempingesteld = huidigeTempingesteld;
    }


    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getHuidigeTempingesteld() {
        return huidigeTempingesteld;
    }

    public void setHuidigeTempingesteld(int huidigeTempingesteld) {
        this.huidigeTempingesteld = huidigeTempingesteld;
    }
}
