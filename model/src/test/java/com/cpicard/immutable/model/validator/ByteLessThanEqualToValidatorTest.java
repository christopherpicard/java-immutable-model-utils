package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class ByteLessThanEqualToValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new ByteLessThanEqualToValidator(PARAMETER_NAME, ByteLessThanEqualToValidatorTest::getValidValue, (byte) 1));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new ByteLessThanEqualToValidator(PARAMETER_NAME, null, (byte) 1));
    }

    @Test
    public void testValidate_GreaterThan() {
        ByteLessThanEqualToValidator instance = new ByteLessThanEqualToValidator(PARAMETER_NAME, ByteLessThanEqualToValidatorTest::getValidValue,
                (byte) 0);
        String result = instance.validate();
        assertEquals(String.format(Validator.LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 0), result);
    }

    @Test
    public void testValidate_Equal() {
        ByteLessThanEqualToValidator instance = new ByteLessThanEqualToValidator(PARAMETER_NAME, ByteLessThanEqualToValidatorTest::getValidValue,
                (byte) 1);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        ByteLessThanEqualToValidator instance = new ByteLessThanEqualToValidator(PARAMETER_NAME, ByteLessThanEqualToValidatorTest::getValidValue,
                (byte) 2);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static byte getValidValue() {
        return 1;
    }
}