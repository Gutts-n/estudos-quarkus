package com.github.farias.yuri.leonardo.ifood.dish.mapper;

import com.github.farias.yuri.leonardo.ifood.dish.Dish;
import com.github.farias.yuri.leonardo.ifood.dish.dto.AddDishDTO;
import com.github.farias.yuri.leonardo.ifood.dish.dto.ListDishDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface DishMapper {
    Dish toDish(AddDishDTO dto);

    List<ListDishDTO> toDishesDTO(List<Dish> dishes);

    ListDishDTO toDishDTO(Dish Dish);
}
