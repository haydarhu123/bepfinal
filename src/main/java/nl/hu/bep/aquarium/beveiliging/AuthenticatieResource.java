package nl.hu.bep.aquarium.beveiliging;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.hu.bep.aquarium.domeinmodel.AquariumManager;
import nl.hu.bep.aquarium.domeinmodel.Eigenaar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap;
import java.util.Calendar;

@Path("/authentication")
public class AuthenticatieResource {
    final static public Key key = MacProvider.generateKey();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("email") String email,
                                     @FormParam("wachtwoord") String wachtwoord) {
        try {
            AquariumManager aquaman1 = AquariumManager.getAquariumManager();
            Eigenaar eig1 = aquaman1.getAlleEigenaren().stream().filter(e -> e.getEmail().equals(email)).findFirst().orElse(null);

            if(eig1 != null)
            {
                System.out.println("Regel 30");

                System.out.println(email);
                System.out.println(wachtwoord);

                if(eig1.getWachtwoord().equals(wachtwoord))
                {
                    System.out.println("Regel 33");
                    String token = createToken(eig1.getEmail(), eig1.getRole());
                    AbstractMap.SimpleEntry<String, String> JWT = new AbstractMap.SimpleEntry<String, String>("JWT", token);
                    System.out.println("Regel 36");
                    return Response.ok(JWT).build();
                }
            }
            System.out.println("Regel 40");
            return Response.status(Response.Status.UNAUTHORIZED).build();

        } catch (JwtException | IllegalArgumentException e)
        {
            System.out.println("Regel 45");
            return Response.status(Response.Status.UNAUTHORIZED).build(); }
    }

    private String createToken(String email, String role) throws JwtException {
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE, 30);
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expiration.getTime())
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }
}
