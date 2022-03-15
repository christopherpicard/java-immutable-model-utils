package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class DoubleGreaterThanEqualToValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new DoubleGreaterThanEqualToValidator(PARAMETER_NAME, DoubleGreaterThanEqualToValidatorTest::getValidValue, 1.0));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new DoubleGreaterThanEqualToValidator(PARAMETER_NAME, null, 1.0));
    }

    @Test
    public void testValidate_GreaterThan() {
        DoubleGreaterThanEqualToValidator instance = new DoubleGreaterThanEqualToValidator(PARAMETER_NAME,
                DoubleGreaterThanEqualToValidatorTest::getValidValue, 0.0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Equal() {
        DoubleGreaterThanEqualToValidator instance = new DoubleGreaterThanEqualToValidator(PARAMETER_NAME,
                DoubleGreaterThanEqualToValidatorTest::getValidValue, 1.0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        DoubleGreaterThanEqualToValidator instance = new DoubleGreaterThanEqualToValidator(PARAMETER_NAME,
                DoubleGreaterThanEqualToValidatorTest::getValidValue, 2.0);
        String result = instance.validate();
        assertEquals(String.format(Validator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 2.0), result);
    }

    private static double getValidValue() {
        return 1.0;
    }
}