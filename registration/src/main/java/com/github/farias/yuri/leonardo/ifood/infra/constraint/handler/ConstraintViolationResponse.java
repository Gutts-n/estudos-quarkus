package com.github.farias.yuri.leonardo.ifood.infra.constraint.handler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConstraintViolationResponse {

    private final List<ConstraintViolationImpl> violations = new ArrayList();

    private ConstraintViolationResponse(ConstraintViolationException exception) {
        exception.getConstraintViolations().forEach(violation -> violations.add(ConstraintViolationImpl.of(violation)));
    }

    public static ConstraintViolationResponse of(ConstraintViolationException e) {
        return new ConstraintViolationResponse(e);
    }

    public List<ConstraintViolationImpl> getViolations() {
        return Collections.unmodifiableList(violations);
    }
}
