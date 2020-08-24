package nl.hu.bep.aquarium.domeinmodel;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;

public class Eigenaar implements Serializable, Principal {
    private ArrayList<Aquarium> eigenAquaria;

    private String voornaam;
    private String achternaam;

    private String email;
    private String wachtwoord;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;

    public Eigenaar(ArrayList<Aquarium> eigenAquaria, String voornaam, String achternaam, String email, String wachtwoord, String role) {
        this.eigenAquaria = eigenAquaria;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public Eigenaar(String voornaam, String achternaam, String email, String wachtwoord, String role){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.role = role;
        this.eigenAquaria = new ArrayList<Aquarium>();

    }

    public ArrayList<Aquarium> getEigenAquaria() {
        return eigenAquaria;
    }

    public void setEigenAquaria(ArrayList<Aquarium> eigenAquaria) {
        this.eigenAquaria = eigenAquaria;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    @Override
    public String getName() {
        return voornaam;
    }
}
