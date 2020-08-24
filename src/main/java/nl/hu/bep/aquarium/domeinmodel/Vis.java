package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;

public class Vis extends Bewoner implements Serializable {
    private boolean algEtend;
    private boolean vereistSpeciaalVisVoer;

    public Vis(String soortnaam, String kleurnaam, int aantal, boolean groepsDier, boolean algEtend, boolean vereistSpeciaalVisVoer) {
        super(soortnaam, kleurnaam, aantal, groepsDier);
        this.algEtend = algEtend;
        this.vereistSpeciaalVisVoer = vereistSpeciaalVisVoer;
    }

    public boolean isAlgEtend() {
        return algEtend;
    }

    public void setAlgEtend(boolean algEtend) {
        this.algEtend = algEtend;
    }

    public boolean isVereistSpeciaalVisVoer() {
        return vereistSpeciaalVisVoer;
    }

    public void setVereistSpeciaalVisVoer(boolean vereistSpeciaalVisVoer) {
        this.vereistSpeciaalVisVoer = vereistSpeciaalVisVoer;
    }
}
