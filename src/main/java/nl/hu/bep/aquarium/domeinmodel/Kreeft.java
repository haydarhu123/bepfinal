package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;

public class Kreeft extends Bewoner implements Serializable {
    public Kreeft(String soortnaam, String kleurnaam, int aantal, boolean groepsDier) {
        super(soortnaam, kleurnaam, aantal, groepsDier);
    }
}
