package com.github.farias.yuri.leonardo.ifood.restaurant.resource;

import com.github.farias.yuri.leonardo.ifood.restaurant.Restaurant;
import com.github.farias.yuri.leonardo.ifood.restaurant.dto.AddRestaurantDTO;
import com.github.farias.yuri.leonardo.ifood.restaurant.dto.ListRestaurantDTO;
import com.github.farias.yuri.leonardo.ifood.restaurant.dto.UpdateRestaurantDTO;
import com.github.farias.yuri.leonardo.ifood.restaurant.mapper.RestaurantMappper;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlow;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlows;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/restaurants")
@RolesAllowed("owner")
@SecurityScheme(
        securitySchemeName = "ifood-oauth",
        type = SecuritySchemeType.OAUTH2,
        flows = @OAuthFlows(
                password = @OAuthFlow(
                        tokenUrl = "http://localhost:8180/auth/realms/ifood/protocol/openid-connect/token"
                )
        )
)
@SecurityRequirement(name = "ifood-oauth", scopes = {})
public class RestaurantResource implements RestaurantResourceInterface {

    @Inject
    RestaurantMappper mapper;
    @GET
    public List<ListRestaurantDTO> listAll() {
        return mapper.toRestaurantsDTO(Restaurant.listAll());
    }

    // TODO TENTAR FAZER AQUELA PARADINHAS DAS INTERFACES PARA UMA DE MÉTRICAS OUTRA PARA DOCUMENTAÇÃO DO ENDPOINT E QUE AS DUAS SE ESTENDAM

    @Transactional
    @POST
    public Response create(AddRestaurantDTO dto, Response response) {
        var entity = mapper.toRestaurant(dto);

        entity.persist();
        return Response.created(URI.create("restaurants/" + entity.id)).build();
    }

    @Transactional
    @PUT
    public void update(Long id, UpdateRestaurantDTO dto) {
        var restaurant = (Restaurant) Restaurant.findByIdOptional(id).orElseThrow(() -> {throw new NotFoundException();});
        var dtoToEntity = mapper.toRestaurant(dto, restaurant);
        dtoToEntity.persist();
    }

    @DELETE
    public void delete(Long id) {
        if(!Restaurant.deleteById(id)) throw new NotFoundException();
    }
}
