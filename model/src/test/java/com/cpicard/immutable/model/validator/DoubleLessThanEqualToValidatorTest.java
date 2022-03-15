package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class DoubleLessThanEqualToValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new DoubleLessThanEqualToValidator(PARAMETER_NAME, DoubleLessThanEqualToValidatorTest::getValidValue, 1.0));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new DoubleLessThanEqualToValidator(PARAMETER_NAME, null, 1.0));
    }

    @Test
    public void testValidate_GreaterThan() {
        DoubleLessThanEqualToValidator instance = new DoubleLessThanEqualToValidator(PARAMETER_NAME,
                DoubleLessThanEqualToValidatorTest::getValidValue, 0.0);
        String result = instance.validate();
        assertEquals(String.format(Validator.LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 0.0), result);
    }

    @Test
    public void testValidate_Equal() {
        DoubleLessThanEqualToValidator instance = new DoubleLessThanEqualToValidator(PARAMETER_NAME,
                DoubleLessThanEqualToValidatorTest::getValidValue, 1.0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        DoubleLessThanEqualToValidator instance = new DoubleLessThanEqualToValidator(PARAMETER_NAME,
                DoubleLessThanEqualToValidatorTest::getValidValue, 2.0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static double getValidValue() {
        return 1.0;
    }
}