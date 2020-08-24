package nl.hu.bep.setup;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("nl.hu.bep.aquarium.webresource", "nl.hu.bep.aquarium.beveiliging");
        register(JacksonFeature.class);
        register(RolesAllowedDynamicFeature.class);
    }
}