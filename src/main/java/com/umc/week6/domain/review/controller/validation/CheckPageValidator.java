package com.umc.week6.domain.review.controller.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import static com.umc.week6.global.error.code.GlobalErrorCode.PAGE_CANNOT_BE_NEGATIVE;

@Component
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {
    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page < 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(PAGE_CANNOT_BE_NEGATIVE.getMessage())
                    .addConstraintViolation();
            return false;
        } else {
            return true;
        }
    }
}
