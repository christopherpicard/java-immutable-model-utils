package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntGreaterThanEqualToValidatorTest {

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new IntGreaterThanEqualToValidator("test", IntGreaterThanEqualToValidatorTest::getValidValue, 1));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new IntGreaterThanEqualToValidator("test", null, 1));
    }

    @Test
    public void testValidate_GreaterThan() {
        IntGreaterThanEqualToValidator instance = new IntGreaterThanEqualToValidator("test", IntGreaterThanEqualToValidatorTest::getValidValue, 0);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_Equal() {
        IntGreaterThanEqualToValidator instance = new IntGreaterThanEqualToValidator("test", IntGreaterThanEqualToValidatorTest::getValidValue, 1);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_LessThan() {
        IntGreaterThanEqualToValidator instance = new IntGreaterThanEqualToValidator("test", IntGreaterThanEqualToValidatorTest::getValidValue, 2);
        String result = instance.validate();
        assertEquals(String.format(Validator.GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, "test", 2), result);
    }

    private static int getValidValue() {
        return 1;
    }
}