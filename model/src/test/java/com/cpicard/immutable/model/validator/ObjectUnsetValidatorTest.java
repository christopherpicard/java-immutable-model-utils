package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObjectUnsetValidatorTest {
    public static final String PARAMETER_NAME = "test";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new ObjectUnsetValidator(PARAMETER_NAME, ObjectUnsetValidatorTest::getValidValue));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new ObjectUnsetValidator(PARAMETER_NAME, null));
    }

    @Test
    public void testValidate_Valid() {
        ObjectUnsetValidator instance = new ObjectUnsetValidator(PARAMETER_NAME, ObjectUnsetValidatorTest::getValidValue);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_NotValid() {
        ObjectUnsetValidator instance = new ObjectUnsetValidator(PARAMETER_NAME, ObjectUnsetValidatorTest::getInvalidValue);
        String result = instance.validate();
        assertEquals(String.format(Validator.IS_SET_ERROR_MESSAGE_FORMAT, PARAMETER_NAME), result);
    }

    private static String getValidValue() {
        return null;
    }

    private static String getInvalidValue() {
        return "set";
    }
}