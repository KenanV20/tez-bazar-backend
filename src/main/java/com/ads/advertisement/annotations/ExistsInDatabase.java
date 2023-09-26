package com.ads.advertisement.annotations;

import com.ads.advertisement.validations.ExistsInDatabaseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Repeatable(ExistsInDatabase.List.class)
@Constraint(validatedBy = ExistsInDatabaseValidator.class)
public @interface ExistsInDatabase {
    String message() default "This section not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @interface List {
        ExistsInDatabase[] value();
    }
    String table();
    String column();
}
