package com.ads.advertisement.annotations;

import com.ads.advertisement.validations.WordCountValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotBlank(message = "Description may not be null or empty")
@ReportAsSingleViolation
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WordCountValidator.class)
public @interface WordCount {
    int value() default 4;
    String message() default "Description must contain at least {value} words";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

