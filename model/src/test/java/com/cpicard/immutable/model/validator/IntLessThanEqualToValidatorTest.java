package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntLessThanEqualToValidatorTest {

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new IntLessThanEqualToValidator("test", IntLessThanEqualToValidatorTest::getValidValue, 1));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new IntLessThanEqualToValidator("test", null, 1));
    }

    @Test
    public void testValidate_GreaterThan() {
        IntLessThanEqualToValidator instance = new IntLessThanEqualToValidator("test", IntLessThanEqualToValidatorTest::getValidValue, 0);
        String result = instance.validate();
        assertEquals(String.format(Validator.LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, "test", 0), result);
    }

    @Test
    public void testValidate_Equal() {
        IntLessThanEqualToValidator instance = new IntLessThanEqualToValidator("test", IntLessThanEqualToValidatorTest::getValidValue, 1);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_LessThan() {
        IntLessThanEqualToValidator instance = new IntLessThanEqualToValidator("test", IntLessThanEqualToValidatorTest::getValidValue, 2);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    private static int getValidValue() {
        return 1;
    }
}