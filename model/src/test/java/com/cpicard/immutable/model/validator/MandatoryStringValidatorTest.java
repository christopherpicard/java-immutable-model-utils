package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MandatoryStringValidatorTest {

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new MandatoryStringValidator("test", MandatoryStringValidatorTest::getValidValue));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new MandatoryStringValidator("test", null));
    }

    @Test
    public void testValidate_Valid() {
        MandatoryStringValidator instance = new MandatoryStringValidator("test", MandatoryStringValidatorTest::getValidValue);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_NotValid() {
        MandatoryStringValidator instance = new MandatoryStringValidator("test", MandatoryStringValidatorTest::getInvalidValue);
        String result = instance.validate();
        assertEquals(String.format(Validator.UNSET_ERROR_MESSAGE_FORMAT, "test"), result);
    }


    private static String getValidValue() {
        return "set";
    }

    private static String getInvalidValue() {
        return "";
    }
}