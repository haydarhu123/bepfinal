package nl.hu.bep.aquarium.beveiliging;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import nl.hu.bep.aquarium.domeinmodel.AquariumManager;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticatieFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestCtx) {

        boolean isSecure = requestCtx.getSecurityContext().isSecure();
        String scheme = requestCtx.getUriInfo().getRequestUri().getScheme();
        // Users are treated as guests, unless a valid JWT is provided
        MijnBeveiligingContext mbc = new MijnBeveiligingContext(null, scheme);
        String authHeader = requestCtx.getHeaderString(HttpHeaders.AUTHORIZATION);

        System.out.println("lijn 29!!!");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            System.out.println("lijn 31");

            String token = authHeader.substring("Bearer".length()).trim();

            try {
                System.out.println("lijn 36");

                // Validate the token
                JwtParser parser = Jwts.parser().setSigningKey(AuthenticatieResource.key);
                Claims claims = parser.parseClaimsJws(token).getBody();

                String user = claims.getSubject();
                AquariumManager aquariumManager = AquariumManager.getAquariumManager();

                mbc = new MijnBeveiligingContext(
                        aquariumManager.getAlleEigenaren().stream().filter(e -> e.getEmail().equals(user)).findFirst().orElse(null),
                        scheme);


                System.out.println("lijn 44");


            } catch (JwtException | IllegalArgumentException e) {
                System.out.println("Invalid JWT, processing as guest!");
            }
        }

        requestCtx.setSecurityContext(mbc);
    }
}
