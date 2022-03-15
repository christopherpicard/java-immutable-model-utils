package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class LongGreaterThanEqualToValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new LongGreaterThanEqualToValidator(PARAMETER_NAME, LongGreaterThanEqualToValidatorTest::getValidValue, 1L));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new LongGreaterThanEqualToValidator(PARAMETER_NAME, null, 1L));
    }

    @Test
    public void testValidate_GreaterThan() {
        LongGreaterThanEqualToValidator instance = new LongGreaterThanEqualToValidator(PARAMETER_NAME,
                LongGreaterThanEqualToValidatorTest::getValidValue, 0L);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Equal() {
        LongGreaterThanEqualToValidator instance = new LongGreaterThanEqualToValidator(PARAMETER_NAME,
                LongGreaterThanEqualToValidatorTest::getValidValue, 1L);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        LongGreaterThanEqualToValidator instance = new LongGreaterThanEqualToValidator(PARAMETER_NAME,
                LongGreaterThanEqualToValidatorTest::getValidValue, 2L);
        String result = instance.validate();
        assertEquals(String.format(Validator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 2L), result);
    }

    private static long getValidValue() {
        return 1L;
    }
}