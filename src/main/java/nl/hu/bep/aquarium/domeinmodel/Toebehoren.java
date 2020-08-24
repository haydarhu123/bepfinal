package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;

public class Toebehoren implements Serializable {
    protected String model;
    protected String serienummer;

    public Toebehoren(String model, String serienummer) {
        this.model = model;
        this.serienummer = serienummer;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerienummer() {
        return serienummer;
    }

    public void setSerienummer(String serienummer) {
        this.serienummer = serienummer;
    }

}
