package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SameReturnValue")
class CharLessThanEqualToValidatorTest {
    public static final String PARAMETER_NAME = "test";
    public static final String SHOULD_BE_EMPTY_ERROR_MESSAGE = "Error message should be empty";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new CharLessThanEqualToValidator(PARAMETER_NAME, CharLessThanEqualToValidatorTest::getValidValue, 'b'));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new CharLessThanEqualToValidator(PARAMETER_NAME, null, 'b'));
    }

    @Test
    public void testValidate_GreaterThan() {
        CharLessThanEqualToValidator instance = new CharLessThanEqualToValidator(PARAMETER_NAME, CharLessThanEqualToValidatorTest::getValidValue,
                'a');
        String result = instance.validate();
        assertEquals(String.format(Validator.LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, PARAMETER_NAME, 'a'), result);
    }

    @Test
    public void testValidate_Equal() {
        CharLessThanEqualToValidator instance = new CharLessThanEqualToValidator(PARAMETER_NAME, CharLessThanEqualToValidatorTest::getValidValue,
                'b');
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    @Test
    public void testValidate_LessThan() {
        CharLessThanEqualToValidator instance = new CharLessThanEqualToValidator(PARAMETER_NAME, CharLessThanEqualToValidatorTest::getValidValue,
                'c');
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), SHOULD_BE_EMPTY_ERROR_MESSAGE);
    }

    private static char getValidValue() {
        return 'b';
    }
}