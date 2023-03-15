package com.github.farias.yuri.leonardo.ifood.dish.resource;

import com.github.farias.yuri.leonardo.ifood.dish.Dish;
import com.github.farias.yuri.leonardo.ifood.dish.dto.AddDishDTO;
import com.github.farias.yuri.leonardo.ifood.dish.dto.ListDishDTO;
import com.github.farias.yuri.leonardo.ifood.dish.mapper.DishMapper;
import com.github.farias.yuri.leonardo.ifood.restaurant.Restaurant;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/restaurants")
public class DishResource implements DishResourceInterface {

    @Inject
    DishMapper mapper;

    public List<ListDishDTO> findAll(Long restaurantId) {
        var restaurant = Restaurant.findByIdOptional(restaurantId).orElseThrow(
                () -> {
                    throw new NotFoundException("Restaurant does not exist.");
                }
        );
        return mapper.toDishesDTO(Dish.list("restaurant", restaurant));
    }

    public ListDishDTO findById(Long restaurantId, Long id) {
        Restaurant.findByIdOptional(restaurantId).orElseThrow(
                () -> {
                    throw new NotFoundException("Restaurant does not exist.");
                }
        );

        return mapper.toDishDTO((Dish) Dish.findByIdOptional(id).orElseThrow(
                        () -> {
                            throw new NotFoundException("Dish does not exist.");
                        }
                )
        );
    }

    @Transactional
    public Response create(Long restaurantId, AddDishDTO dto) {
        Restaurant.findByIdOptional(restaurantId).orElseThrow(
                () -> {
                    throw new NotFoundException("Restaurant does not exist.");
                }
        );
        var dish = mapper.toDish(dto);

        dish.persist();
        return Response.created(URI.create("restaurants/" + restaurantId + "/dishes/" + dish.id)).build();
    }

    @Transactional
    public Response update(Long restaurantId, Long id, AddDishDTO dto) {
        Restaurant.findByIdOptional(restaurantId).orElseThrow(
                () -> {
                    throw new NotFoundException("Restaurant does not exist.");
                }
        );

        var dish = (Dish) Dish.findByIdOptional(id).orElseThrow(
                () -> {
                    throw new NotFoundException("Dish does not exist.");
                }
        );

        dish.name = dto.name;
        dish.price = dto.price;
        dish.description = dto.description;

        dish.persist();

        return Response.ok().build();
    }

    public void delete(Long restaurantId, Long id) {
        Dish.findByIdOptional(id).ifPresentOrElse(
                PanacheEntityBase::delete,
                () -> {
                    throw new NotFoundException("Dish does not exist.");
                }
        );
    }
}
