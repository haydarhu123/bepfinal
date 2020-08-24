package nl.hu.bep.aquarium.beveiliging;

import nl.hu.bep.aquarium.domeinmodel.Eigenaar;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class MijnBeveiligingContext implements SecurityContext {

    private Eigenaar eigenaar;
    private String scheme;

    public MijnBeveiligingContext(Eigenaar eigenaar, String scheme){
        this.eigenaar = eigenaar;
        this.scheme = scheme;
    }
    @Override
    public Principal getUserPrincipal() {
        return this.eigenaar;
    }

    @Override
    public boolean isUserInRole(String s) {
        return this.eigenaar.getRole().equals(s);
    }

    @Override
    public boolean isSecure() {
        return "https".equals(this.scheme);
    }

    @Override
    public String getAuthenticationScheme() {
        return "bearer";
    }

    public Eigenaar getEigenaar() {
        return this.eigenaar;
    }
}
