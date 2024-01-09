package comparator.service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductionYearValidator implements ConstraintValidator<ProductionYearRange, Integer> {
    public static final int MIN_PRODUCTION_YEAR = 1880;
    public static final int CURRENT_YEAR = LocalDate.now().getYear();

    @Override
    public void initialize(ProductionYearRange constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer productionYear, ConstraintValidatorContext constraintValidatorContext) {
        if (productionYear == null) {
            return false;
        }
        return (productionYear > MIN_PRODUCTION_YEAR) && (productionYear <= CURRENT_YEAR);
    }
}