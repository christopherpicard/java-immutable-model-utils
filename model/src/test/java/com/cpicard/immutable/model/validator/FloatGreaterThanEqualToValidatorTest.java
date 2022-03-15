package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class FloatGreaterThanEqualToValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new FloatGreaterThanEqualToValidator(PARAMETER_NAME, FloatGreaterThanEqualToValidatorTest::getValidValue, 1.0F));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new FloatGreaterThanEqualToValidator(PARAMETER_NAME, null, 1.0F));
    }

    @Test
    public void testValidate_GreaterThan() {
        FloatGreaterThanEqualToValidator instance = new FloatGreaterThanEqualToValidator(PARAMETER_NAME,
                FloatGreaterThanEqualToValidatorTest::getValidValue, 0.0F);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Equal() {
        FloatGreaterThanEqualToValidator instance = new FloatGreaterThanEqualToValidator(PARAMETER_NAME,
                FloatGreaterThanEqualToValidatorTest::getValidValue, 1.0F);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        FloatGreaterThanEqualToValidator instance = new FloatGreaterThanEqualToValidator(PARAMETER_NAME,
                FloatGreaterThanEqualToValidatorTest::getValidValue, 2.0F);
        String result = instance.validate();
        assertEquals(String.format(Validator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 2.0F), result);
    }

    private static float getValidValue() {
        return 1.0F;
    }
}