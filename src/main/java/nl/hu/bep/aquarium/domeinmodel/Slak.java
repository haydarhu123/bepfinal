package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;

public class Slak extends Bewoner implements Serializable {
    private boolean slakkenEtend;

    public Slak(String soortnaam, String kleurnaam, int aantal, boolean groepsDier, boolean slakkenEtend) {
        super(soortnaam, kleurnaam, aantal, groepsDier);
        this.slakkenEtend = slakkenEtend;
    }

    public boolean isSlakkenEtend() {
        return slakkenEtend;
    }

    public void setSlakkenEtend(boolean slakkenEtend) {
        this.slakkenEtend = slakkenEtend;
    }
}
