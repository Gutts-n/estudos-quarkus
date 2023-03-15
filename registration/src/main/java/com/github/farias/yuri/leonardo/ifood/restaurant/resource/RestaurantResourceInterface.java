package com.github.farias.yuri.leonardo.ifood.restaurant.resource;

import com.github.farias.yuri.leonardo.ifood.infra.constraint.handler.ConstraintViolationResponse;
import com.github.farias.yuri.leonardo.ifood.restaurant.dto.AddRestaurantDTO;
import com.github.farias.yuri.leonardo.ifood.restaurant.dto.ListRestaurantDTO;
import com.github.farias.yuri.leonardo.ifood.restaurant.dto.UpdateRestaurantDTO;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RestaurantResourceInterface {
    @GET
    @Tag(name = "Restaurant")
    List<ListRestaurantDTO> listAll();

    @POST
    @Tag(name = "Restaurant")
    @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf = ConstraintViolationResponse.class)))
    @APIResponse(responseCode = "201", description = "When the restaurant's created")
    Response create(@Valid @RequestBody AddRestaurantDTO dto, Response response);

    @PUT
    @Path("{id}")
    @Tag(name = "Restaurant")
    void update(@PathParam("id") Long id, UpdateRestaurantDTO dto);

    @DELETE
    @Path("{id}")
    @Transactional
    @Tag(name = "Restaurant")
    void delete(@PathParam("id") Long id);

}