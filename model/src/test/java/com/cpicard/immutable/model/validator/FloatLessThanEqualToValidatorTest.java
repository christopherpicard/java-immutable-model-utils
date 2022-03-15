package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class FloatLessThanEqualToValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new FloatLessThanEqualToValidator(PARAMETER_NAME, FloatLessThanEqualToValidatorTest::getValidValue, 1.0F));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new FloatLessThanEqualToValidator(PARAMETER_NAME, null, 1.0F));
    }

    @Test
    public void testValidate_GreaterThan() {
        FloatLessThanEqualToValidator instance = new FloatLessThanEqualToValidator(PARAMETER_NAME, FloatLessThanEqualToValidatorTest::getValidValue,
                0.0F);
        String result = instance.validate();
        assertEquals(String.format(Validator.LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 0.0), result);
    }

    @Test
    public void testValidate_Equal() {
        FloatLessThanEqualToValidator instance = new FloatLessThanEqualToValidator(PARAMETER_NAME, FloatLessThanEqualToValidatorTest::getValidValue,
                1.0F);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        FloatLessThanEqualToValidator instance = new FloatLessThanEqualToValidator(PARAMETER_NAME, FloatLessThanEqualToValidatorTest::getValidValue,
                2.0F);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static float getValidValue() {
        return 1.0F;
    }
}