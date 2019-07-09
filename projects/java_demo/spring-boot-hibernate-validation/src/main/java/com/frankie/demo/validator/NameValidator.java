package com.frankie.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class NameValidator implements ConstraintValidator<Name, String> {

    List<String> names =  Arrays.asList("suyan", "5x");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return names.contains(value);
    }
}
