package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;

public class Garnaal extends Bewoner implements Serializable {
    public Garnaal(String soortnaam, String kleurnaam, int aantal, boolean groepsDier) {
        super(soortnaam, kleurnaam, aantal, groepsDier);
    }
}
