package com.github.farias.yuri.leonardo.ifood.restaurant.mapper;

import com.github.farias.yuri.leonardo.ifood.restaurant.Restaurant;
import com.github.farias.yuri.leonardo.ifood.restaurant.dto.AddRestaurantDTO;
import com.github.farias.yuri.leonardo.ifood.restaurant.dto.ListRestaurantDTO;
import com.github.farias.yuri.leonardo.ifood.restaurant.dto.UpdateRestaurantDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface RestaurantMappper {

    Restaurant toRestaurant(AddRestaurantDTO dto);
    Restaurant toRestaurant(UpdateRestaurantDTO dto, @MappingTarget Restaurant restaurant);

    @IterableMapping(dateFormat = "dd/MM/yyyy HH:mm:ss")
    List<ListRestaurantDTO> toRestaurantsDTO(List<Restaurant> restaurants);

}
