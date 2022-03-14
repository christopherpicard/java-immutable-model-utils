package com.cpicard.immutable.model.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorAbsTest {

    @Test
    public void testConstructor_NominalCase() {
        assertDoesNotThrow(() -> new FakeValidator("test"));
    }

    @Test
    public void testConstructor_NullName() {
        assertThrows(IllegalArgumentException.class, () -> new FakeValidator(null));
    }
}