package com.github.farias.yuri.leonardo.ifood.restaurant.dto;

import com.github.farias.yuri.leonardo.ifood.infra.dto.DTO;

import javax.validation.constraints.NotNull;

public class LocalizationDTO implements DTO {
    @NotNull public Double latitude;

    @NotNull public Double longitude;
}
