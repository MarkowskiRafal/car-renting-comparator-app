package comparator.service;

import comparator.model.Vehicle;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class ProductionYearValidatorTest {

    private ProductionYearRange constraintAnnotation;
    private ProductionYearValidator validator;
    private Vehicle vehicle;

    @BeforeEach
    public void setUp() {
        constraintAnnotation = mock(ProductionYearRange.class);
        validator = new ProductionYearValidator();
        vehicle = new Vehicle();
    }

    @Test
    public void testNullProductionYear() {
        // given
        validator.initialize(constraintAnnotation);

        // when
        boolean isValid = validator.isValid(vehicle.getProductionYear(), mock(ConstraintValidatorContext.class));

        // then
        assertFalse(isValid);
    }

    @Test
    public void testInvalidProductionYearBelowZero() {
        // given
        vehicle.setProductionYear(-150);

        // when
        boolean isValid = validator.isValid(vehicle.getProductionYear(), mock(ConstraintValidatorContext.class));

        // then
        assertFalse(isValid);
    }

    @Test
    public void testInvalidProductionYearBelowMinimalValue() {
        // given
        vehicle.setProductionYear(ProductionYearValidator.MIN_PRODUCTION_YEAR - 1);

        // when
        boolean isValid = validator.isValid(vehicle.getProductionYear(), mock(ConstraintValidatorContext.class));

        // then
        assertFalse(isValid);
    }

    @Test
    public void testInvalidProductionYearAboveCurrentYear() {
        // given
        vehicle.setProductionYear(ProductionYearValidator.CURRENT_YEAR + 1);

        // when
        boolean isValid = validator.isValid(vehicle.getProductionYear(), mock(ConstraintValidatorContext.class));

        // when
        assertFalse(isValid);
    }

    @Test
    public void testValidProductionYear() {
        // given
        vehicle.setProductionYear(2000);

        // when
        boolean isValid = validator.isValid(vehicle.getProductionYear(), mock(ConstraintValidatorContext.class));

        // then
        assertTrue(isValid);
    }

    @Test
    public void testValidProductionYearWithCurrentYear() {
        // given
        vehicle.setProductionYear(ProductionYearValidator.CURRENT_YEAR);

        // when
        boolean isValid = validator.isValid(vehicle.getProductionYear(), mock(ConstraintValidatorContext.class));

        // then
        assertTrue(isValid);
    }
}