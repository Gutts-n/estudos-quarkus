package com.github.farias.yuri.leonardo.ifood.dish.dto;

import com.github.farias.yuri.leonardo.ifood.restaurant.Restaurant;

public class ListDishRestaurantDTO {
    Long id;

    public ListDishRestaurantDTO map(Restaurant restaurant) {
        var restaurantDTO = new ListDishRestaurantDTO();
        restaurantDTO.id = restaurant.id;
        return restaurantDTO;
    }
}
