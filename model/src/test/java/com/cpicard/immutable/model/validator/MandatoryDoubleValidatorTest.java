package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MandatoryDoubleValidatorTest {

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new MandatoryDoubleValidator("test", MandatoryDoubleValidatorTest::getValidValue));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new MandatoryDoubleValidator("test", null));
    }

    @Test
    public void testValidate_Valid() {
        MandatoryDoubleValidator instance = new MandatoryDoubleValidator("test", MandatoryDoubleValidatorTest::getValidValue);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_NotValid() {
        MandatoryDoubleValidator instance = new MandatoryDoubleValidator("test", MandatoryDoubleValidatorTest::getInvalidValue);
        String result = instance.validate();
        assertEquals(String.format(Validator.UNSET_ERROR_MESSAGE_FORMAT, "test"), result);
    }


    private static double getValidValue() {
        return 1.0;
    }

    private static double getInvalidValue() {
        return 0.0;
    }
}