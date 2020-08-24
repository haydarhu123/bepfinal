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

@Path("/Aquarium")
public class AquariumBron {

    @Path("/EigenAquariaBekijken")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response bekijkEigenAquaria(@Context ContainerRequestContext context) {
        MijnBeveiligingContext mbc = (MijnBeveiligingContext) context.getSecurityContext();
        Eigenaar eig = mbc.getEigenaar();
        System.out.println(mbc.getEigenaar().getEmail());
        return Response.ok(eig.getEigenAquaria()).build();
    }

    @Path("bekijkBewoners/{aquariumNaam}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"gebruiker", "beheerder"})
    public Response bekijkBewoners(@Context ContainerRequestContext context, @PathParam("aquariumNaam") String aquariumNaam) {
        MijnBeveiligingContext mbc = (MijnBeveiligingContext) context.getSecurityContext();
        Eigenaar eig = mbc.getEigenaar();

        Aquarium aqua = eig.getEigenAquaria().stream().findFirst().orElse(null);


        return Response.ok(aqua.getBewoners()).build();
    }


    @Path("getRole")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRole(@Context ContainerRequestContext context)
    {
        MijnBeveiligingContext mbc = (MijnBeveiligingContext) context.getSecurityContext();
        Eigenaar eig = mbc.getEigenaar();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(eig.getRole());
        return Response.ok(arrayList).build();
    }



}