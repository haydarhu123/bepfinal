package nl.hu.bep.aquarium.webresource;

import nl.hu.bep.aquarium.beveiliging.MijnBeveiligingContext;
import nl.hu.bep.aquarium.domeinmodel.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/aquatoevoegen")
public class AquariumToevoegenBron {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/bewonerToevoegen/{aquariumNaam}")
    //aquariumtoevoegen
    public Response BewonerToevoegen(@Context ContainerRequestContext context,
                                     @FormParam("soortnaam") String soortnaam,
                                     @FormParam("kleurnaam") String kleurnaam,
                                     // @FormParam("groepsDier") String groepsDier,
                                     @FormParam("aantal") String aantal,
                                     @PathParam("aquariumNaam") String aquariumNaam) {
        boolean isGroepsDier = false;
        //if (groepsDier != null) {
        //   if (groepsDier.contains("aan")) {
        //      isGroepsDier = true;
        //   }
        //  }
        MijnBeveiligingContext mbc = (MijnBeveiligingContext) context.getSecurityContext();
        Eigenaar eig = mbc.getEigenaar();

        Bewoner toevoegen = new Bewoner(soortnaam, kleurnaam, Integer.parseInt(aantal), isGroepsDier);

        for (Aquarium aqua : eig.getEigenAquaria()) {
            aqua.addBewoner(toevoegen);

        }
        return Response.ok().build();
    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/aquariumToevoegen")
    @RolesAllowed({"gebruiker", "beheerder"})
    public Response aquariumToevoegen(@Context ContainerRequestContext context,
                                      @FormParam("naam") String naam,
                                      @FormParam("lengte") String lengte,
                                      @FormParam("breedte") String breedte,
                                      @FormParam("hoogte") String hoogte,
                                      @FormParam("watersoort") String watersoort,
                                      @FormParam("bodemsoort") String bodemsoort
    ) {

        // System.out.println(aqua);
        System.out.println(lengte);
        System.out.println(breedte);
        System.out.println(hoogte);
        System.out.println(watersoort);
        System.out.println(bodemsoort);


        MijnBeveiligingContext mbc = (MijnBeveiligingContext) context.getSecurityContext();
        Eigenaar eig = mbc.getEigenaar();

        System.out.println( "is eigenaar ingelogd:" + eig.getEmail());

        AquariumManager aquariumManager = AquariumManager.getAquariumManager();


        Aquarium aqua = new Aquarium(new ArrayList<Bewoner>(), new ArrayList<Toebehoren>(), new ArrayList<Ornament>(),
                naam, Integer.parseInt(lengte), Integer.parseInt(breedte), Integer.parseInt(hoogte), bodemsoort, watersoort);

        Eigenaar eig2 = aquariumManager.getAlleEigenaren()
                .stream()
                .filter(e -> e.getEmail().equals(eig.getEmail()))
                .findFirst()
                .orElse(null);

        System.out.println( eig2.getEmail() + "is eigenaar gevonden");
        eig2.getEigenAquaria().add(aqua);


        return Response.ok().build();
    }

}

