package comparator.service.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductionYearValidator implements ConstraintValidator<ProductionYearRange, Integer> {
    public static final int CURRENT_YEAR = LocalDate.now().getYear();
    public static int minProductionYear;

    @Override
    public void initialize(ProductionYearRange constraintAnnotation) {
        minProductionYear = constraintAnnotation.minProductionYear();
    }

    @Override
    public boolean isValid(Integer productionYear, ConstraintValidatorContext constraintValidatorContext) {
        if (productionYear == null) {
            return false;
        }
        return (productionYear > minProductionYear) && (productionYear <= CURRENT_YEAR);
    }
}