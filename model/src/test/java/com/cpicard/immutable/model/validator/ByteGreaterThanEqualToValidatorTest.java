package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class ByteGreaterThanEqualToValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new ByteGreaterThanEqualToValidator(PARAMETER_NAME, ByteGreaterThanEqualToValidatorTest::getValidValue, (byte) 1));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new ByteGreaterThanEqualToValidator(PARAMETER_NAME, null, (byte) 1));
    }

    @Test
    public void testValidate_GreaterThan() {
        ByteGreaterThanEqualToValidator instance = new ByteGreaterThanEqualToValidator(PARAMETER_NAME,
                ByteGreaterThanEqualToValidatorTest::getValidValue, (byte) 0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Equal() {
        ByteGreaterThanEqualToValidator instance = new ByteGreaterThanEqualToValidator(PARAMETER_NAME,
                ByteGreaterThanEqualToValidatorTest::getValidValue, (byte) 1);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        ByteGreaterThanEqualToValidator instance = new ByteGreaterThanEqualToValidator(PARAMETER_NAME,
                ByteGreaterThanEqualToValidatorTest::getValidValue, (byte) 2);
        String result = instance.validate();
        assertEquals(String.format(Validator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 2), result);
    }

    private static byte getValidValue() {
        return 1;
    }
}