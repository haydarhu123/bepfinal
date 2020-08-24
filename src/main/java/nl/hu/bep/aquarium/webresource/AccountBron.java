package nl.hu.bep.aquarium.webresource;

import nl.hu.bep.aquarium.domeinmodel.AquariumManager;
import nl.hu.bep.aquarium.domeinmodel.Eigenaar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/account")
public class AccountBron {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/register")
    public Response Accountaanmaken(@FormParam("email") String email,
                                    @FormParam("wachtwoord") String wachtwoord,
                                    @FormParam("naam") String naam,
                                    @FormParam("achternaam") String achternaam)
    {
        try
        {
            AquariumManager aquaman1 = AquariumManager.getAquariumManager();

            if(email != null
                    && !email.isEmpty()
                    && (email.contains("@"))
                    && !wachtwoord.isEmpty()
                    && (wachtwoord.length() > 5)
                    && !naam.isEmpty()
                    && !achternaam.isEmpty()
            )
            {
                Eigenaar eigenaarBestaat = aquaman1.getAlleEigenaren()
                        .stream()
                        .filter(e -> e.getEmail().equals(email))
                        .findFirst()
                        .orElse(null);

                if(eigenaarBestaat == null)
                {
                    Eigenaar eig1 = new Eigenaar(naam, achternaam, email, wachtwoord, "gebruiker");
                    aquaman1.addEigenaar(eig1);

                    return Response.ok(eig1).build();
                }
                else{
                    return Response.status(Response.Status.CONFLICT).build();
                }
            }
        }

        catch(Exception exception)
        {
            exception.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
