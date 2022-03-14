package com.cpicard.immutable.model.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MandatoryCollectionValidatorTest {

    public static final String PARAMETER_NAME = "test";

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new MandatoryCollectionValidator(PARAMETER_NAME, MandatoryCollectionValidatorTest::getValidValue));
    }

    @Test
    public void testConstructor_NullSupplier() {
        assertThrows(IllegalArgumentException.class, () -> new MandatoryCollectionValidator(PARAMETER_NAME, null));
    }

    @Test
    public void testValidate_Valid() {
        MandatoryCollectionValidator instance = new MandatoryCollectionValidator(PARAMETER_NAME, MandatoryCollectionValidatorTest::getValidValue);
        String result = instance.validate();
        assertTrue(StringUtils.isEmpty(result), "Error message should be empty");
    }

    @Test
    public void testValidate_NotValid() {
        MandatoryCollectionValidator instance = new MandatoryCollectionValidator(PARAMETER_NAME, MandatoryCollectionValidatorTest::getInvalidValue);
        String result = instance.validate();
        assertEquals(String.format(Validator.UNSET_ERROR_MESSAGE_FORMAT, PARAMETER_NAME), result);
    }

    private static List<String> getValidValue() {
        return Collections.singletonList("set");
    }

    private static List<String> getInvalidValue() {
        return new ArrayList<>();
    }
}