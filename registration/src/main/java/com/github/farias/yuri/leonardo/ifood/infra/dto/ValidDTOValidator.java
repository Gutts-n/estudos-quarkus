package com.github.farias.yuri.leonardo.ifood.infra.dto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidDTOValidator implements ConstraintValidator<ValidDTO, DTO> {

    @Override
    public void initialize(ValidDTO constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(DTO dto, ConstraintValidatorContext constraintValidatorContext) {
        return dto.isValid(constraintValidatorContext);
    }
}
