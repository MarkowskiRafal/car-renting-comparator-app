package comparator.service;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductionYearValidator.class)
public @interface ProductionYearRange {
    String message() default "Invalid production year";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int minProductionYear() default 1880;
}