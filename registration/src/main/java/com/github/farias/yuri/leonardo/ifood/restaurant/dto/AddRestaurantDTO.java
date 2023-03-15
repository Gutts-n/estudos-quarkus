package com.github.farias.yuri.leonardo.ifood.restaurant.dto;

import com.github.farias.yuri.leonardo.ifood.infra.dto.DTO;
import com.github.farias.yuri.leonardo.ifood.infra.dto.ValidDTO;
import com.github.farias.yuri.leonardo.ifood.restaurant.Restaurant;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ValidDTO
public class AddRestaurantDTO implements DTO {

    @NotNull public LocalizationDTO localization;

    @Size(min = 4, max = 120)
    @NotNull public String owner;

    @CNPJ
    @NotNull public String cnpj;

    @Size(min = 4, max = 30)
    @NotNull public String name;

    @Override
    public boolean isValid(ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        if (Restaurant.find("cnpj", cnpj).count() > 0) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("CNPJ já cadastrado")
                    .addPropertyNode("cnpj")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
