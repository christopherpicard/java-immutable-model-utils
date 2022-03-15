package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class CharGreaterThanEqualToValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new CharGreaterThanEqualToValidator(PARAMETER_NAME, CharGreaterThanEqualToValidatorTest::getValidValue, 'a'));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new CharGreaterThanEqualToValidator(PARAMETER_NAME, null, 'a'));
    }

    @Test
    public void testValidate_GreaterThan() {
        CharGreaterThanEqualToValidator instance = new CharGreaterThanEqualToValidator(PARAMETER_NAME,
                CharGreaterThanEqualToValidatorTest::getValidValue, 'a');
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_Equal() {
        CharGreaterThanEqualToValidator instance = new CharGreaterThanEqualToValidator(PARAMETER_NAME,
                CharGreaterThanEqualToValidatorTest::getValidValue, 'b');
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        CharGreaterThanEqualToValidator instance = new CharGreaterThanEqualToValidator(PARAMETER_NAME,
                CharGreaterThanEqualToValidatorTest::getValidValue, 'c');
        String result = instance.validate();
        assertEquals(String.format(Validator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 'c'), result);
    }

    private static char getValidValue() {
        return 'b';
    }
}