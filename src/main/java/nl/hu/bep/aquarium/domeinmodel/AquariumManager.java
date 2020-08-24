package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;
import java.util.ArrayList;

public class AquariumManager implements Serializable {

    private ArrayList<Eigenaar> alleEigenaren = new ArrayList<Eigenaar>();
    private ArrayList<Aquarium> alleAquaria = new ArrayList<Aquarium>();
    private ArrayList<Bewoner> alleBewoners = new ArrayList<Bewoner>();
    private ArrayList<Toebehoren> alleToebehoren = new ArrayList<Toebehoren>();

    private String installatieNaam;

    private static AquariumManager my_aquariumManager = new AquariumManager();
    public static AquariumManager getAquariumManager() {
        return my_aquariumManager;
    }
    public static void setAquariumManager(AquariumManager aquariumManager) {
        my_aquariumManager = aquariumManager;
    }

    public AquariumManager()
    {

    }

    public AquariumManager(ArrayList<Eigenaar> alleEigenaren, ArrayList<Aquarium> alleAquaria, ArrayList<Bewoner> alleBewoners, ArrayList<Toebehoren> alleToebehoren, String installatieNaam) {
        this.alleEigenaren = alleEigenaren;
        this.alleAquaria = alleAquaria;
        this.alleBewoners = alleBewoners;
        this.alleToebehoren = alleToebehoren;
        this.installatieNaam = installatieNaam;
    }

    public boolean addEigenaar(Eigenaar eigenaar)
    {
        try
        {
            if(alleEigenaren.contains(eigenaar) == false)
            {
                alleEigenaren.add(eigenaar);
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception exception)
        {
            return false;
        }

    }
    public boolean addBewoner(Bewoner bewoner)
    {
        try
        {
            if(alleBewoners.contains(bewoner) == false)
            {
                alleBewoners.add(bewoner);
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception exception)
        {
            return false;
        }

    }

    public ArrayList<Eigenaar> getAlleEigenaren() {
        return alleEigenaren;
    }

    public void setAlleEigenaren(ArrayList<Eigenaar> alleEigenaren) {
        this.alleEigenaren = alleEigenaren;
    }

    public ArrayList<Aquarium> getAlleAquaria() {
        return alleAquaria;
    }

    public void setAlleAquaria(ArrayList<Aquarium> alleAquaria) {
        this.alleAquaria = alleAquaria;
    }

    public ArrayList<Bewoner> getAlleBewoners() {
        return alleBewoners;
    }

    public void setAlleBewoners(ArrayList<Bewoner> alleBewoners) {
        this.alleBewoners = alleBewoners;
    }

    public ArrayList<Toebehoren> getAlleToebehoren() {
        return alleToebehoren;
    }

    public void setAlleToebehoren(ArrayList<Toebehoren> alleToebehoren) {
        this.alleToebehoren = alleToebehoren;
    }

    public String getInstallatieNaam() {
        return installatieNaam;
    }

    public void setInstallatieNaam(String installatieNaam) {
        this.installatieNaam = installatieNaam;
    }

    public void addAquarium(Aquarium aquarium) {
        alleAquaria.add(aquarium);
    }

    public void addToebehoren(Toebehoren toebehoren) {
        alleToebehoren.add(toebehoren);
    }

    public void deleteAquarium(Aquarium aquarium) {
        alleAquaria.remove(aquarium);
    }

    public void deleteEigenaar(Eigenaar eigenaar) {
        alleEigenaren.remove(eigenaar);
    }


}
