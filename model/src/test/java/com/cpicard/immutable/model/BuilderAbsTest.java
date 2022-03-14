/*
 * Copyright (c) Chris Picard 2022.
 * All Rights Reserved
 *
 * IN NO EVENT SHALL REGENTS BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES,
 * INCLUDING LOST PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF REGENTS HAS BEEN ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * REGENTS SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
 * AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE AND ACCOMPANYING DOCUMENTATION, IF ANY, PROVIDED HEREUNDER IS PROVIDED
 * "AS IS". REGENTS HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
 */

package com.cpicard.immutable.model;

import com.cpicard.immutable.model.validator.MandatoryObjectValidator;
import com.cpicard.immutable.model.validator.MandatoryStringValidator;
import com.cpicard.immutable.model.validator.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuilderAbsTest {
    private static final String FAILING_PARAMETER_NAME = "test2";
    private static final MandatoryStringValidator PASSING_VALIDATOR = new MandatoryStringValidator("test1", BuilderAbsTest::getValue);
    private static final MandatoryObjectValidator FAILING_VALIDATOR = new MandatoryObjectValidator(FAILING_PARAMETER_NAME,
            BuilderAbsTest::getNullValue);

    private FakeBuilder instance;

    @BeforeEach
    public void before() {
        instance = new FakeBuilder();
    }

    @Test
    public void testValidate_Valid() {
        instance.addValidator(PASSING_VALIDATOR);
        assertDoesNotThrow(() -> instance.validate());
    }

    @Test
    public void testValidate_NotValid() {
        instance.addValidator(FAILING_VALIDATOR);
        assertThrows(IllegalStateException.class, () -> instance.validate());
    }

    @Test
    public void testIsValid_Valid() {
        instance.addValidator(PASSING_VALIDATOR);
        assertTrue(instance.isValid());
    }

    @Test
    public void testIsValid_NotValid() {
        instance.addValidator(FAILING_VALIDATOR);
        assertFalse(instance.isValid());
    }

    @Test
    public void getValidationErrors_Valid() {
        instance.addValidator(PASSING_VALIDATOR);
        String result = instance.getValidationErrors();
        assertTrue(result.isEmpty(), "Validation errors string should be empty");
    }

    @Test
    public void getValidationErrors_NotValid() {
        instance.addValidator(FAILING_VALIDATOR);
        String result = instance.getValidationErrors();
        assertEquals(String.format(Validator.UNSET_ERROR_MESSAGE_FORMAT, FAILING_PARAMETER_NAME), result);
    }

    private static String getValue() {
        return "testValue";
    }

    private static String getNullValue() {
        return null;
    }
}