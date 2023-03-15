package com.github.farias.yuri.leonardo.ifood.dish.resource;

import com.github.farias.yuri.leonardo.ifood.dish.dto.AddDishDTO;
import com.github.farias.yuri.leonardo.ifood.dish.dto.ListDishDTO;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

public interface DishResourceInterface {

    @GET
    @Path("/{restaurantId}/dishes")
    @Tag(name = "Dish")
    List<ListDishDTO> findAll(@PathParam("restaurantId") Long restaurantId);

    @GET
    @Path("/{restaurantId}/dishes/{id}")
    @Tag(name = "Dish")
    ListDishDTO findById(@PathParam("restaurantId") Long restaurantId, @PathParam("id") Long id);

    @POST
    @Path("/{restaurantId}/dishes")
    @Tag(name = "Dish")
    Response create(@PathParam("restaurantId") Long restaurantId, AddDishDTO dto);

    @PUT
    @Path("/{restaurantId}/dishes/{id}")
    @Tag(name = "Dish")
    Response update(@PathParam("restaurantId") Long restaurantId, @PathParam("id") Long id, AddDishDTO dto);

    @DELETE
    @Path("/{restaurantId}/dishes/{id}")
    @Tag(name = "Dish")
    void delete(@PathParam("restaurantId") Long restaurantId, @PathParam("id") Long id);
}
