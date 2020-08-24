package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;
import java.time.LocalTime;

public class Verlichting extends Toebehoren implements Serializable {
    private boolean isLed;
    private LocalTime tijdAan;
    private LocalTime tijdUit;

    public Verlichting(String model, String serienummer, boolean isLed, LocalTime tijdAan, LocalTime tijdUit) {
        super(model, serienummer);
        this.isLed = isLed;
        this.tijdAan = tijdAan;
        this.tijdUit = tijdUit;
    }

    public boolean isLed() {
        return isLed;
    }

    public void setLed(boolean led) {
        isLed = led;
    }

    public LocalTime getTijdAan() {
        return tijdAan;
    }

    public void setTijdAan(LocalTime tijdAan) {
        this.tijdAan = tijdAan;
    }

    public LocalTime getTijdUit() {
        return tijdUit;
    }

    public void setTijdUit(LocalTime tijdUit) {
        this.tijdUit = tijdUit;
    }
}
