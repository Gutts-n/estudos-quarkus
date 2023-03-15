package com.github.farias.yuri.leonardo.ifood.infra.constraint.handler;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.ConstraintViolation;
import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstraintViolationImpl implements Serializable {

    @Schema(description = "Attribute path, ex: creationDate, person.address.number")
    private final String attribute;

    @Schema(description = "Descriptive message from possible path error")
    private final String message;

    private ConstraintViolationImpl(ConstraintViolation<?> violation) {
        this.message = violation.getMessage();
        this.attribute = Stream.of(violation.getPropertyPath().toString().split("\\.")).skip(2).collect(Collectors.joining("."));
    }

    public ConstraintViolationImpl(String attribute, String message) {
        this.message = message;
        this.attribute = attribute;
    }

    public static ConstraintViolationImpl of(String violation) {
        return new ConstraintViolationImpl(null, violation);
    }

    public static ConstraintViolationImpl of(ConstraintViolation<?> violation) {
        return new ConstraintViolationImpl(violation);
    }

    public String getMessage() {
        return message;
    }
}
