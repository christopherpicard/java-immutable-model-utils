package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MandatoryIntValidatorTest {

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new MandatoryIntValidator("test", MandatoryIntValidatorTest::getValidValue));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new MandatoryIntValidator("test", null));
    }

    @Test
    public void testValidate_Valid() {
        MandatoryIntValidator instance = new MandatoryIntValidator("test", MandatoryIntValidatorTest::getValidValue);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_NotValid() {
        MandatoryIntValidator instance = new MandatoryIntValidator("test", MandatoryIntValidatorTest::getInvalidValue);
        String result = instance.validate();
        assertEquals(String.format(Validator.UNSET_ERROR_MESSAGE_FORMAT, "test"), result);
    }


    private static int getValidValue() {
        return 1;
    }

    private static int getInvalidValue() {
        return 0;
    }
}