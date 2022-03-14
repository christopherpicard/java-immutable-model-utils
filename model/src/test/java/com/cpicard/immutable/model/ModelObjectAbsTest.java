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

import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelObjectAbsTest {

    private FakeModelObjectBuilder instance;

    @BeforeEach
    public void before() {
        instance = new FakeModelObjectBuilder();
    }

    @Test
    public void testBuilder() {
        UUID id = UUID.randomUUID();
        instance.setId(id);
        FakeModelObject result = instance.build();
        assertEquals(id, result.getId());
    }

    @Test
    public void testBuilder_NoId() {
        FakeModelObject result = instance.build();
        assertNotNull(result.getId());
    }

    @Test
    public void testReset() {
        UUID id = UUID.randomUUID();
        instance.setId(id);
        instance.reset();
        FakeModelObject result = instance.build();
        assertNotEquals(id, result.getId());
    }

    @Test
    public void testCopyValues() {
        UUID id = UUID.randomUUID();
        instance.setId(id);
        FakeModelObject result = instance.build();
        instance.reset();
        instance.copyValues(result);
        result = instance.build();
        assertEquals(id, result.getId());
    }

    @Test
    public void testSetValues() {
        UUID id = UUID.randomUUID();
        instance.setId(id);
        FakeModelObject result = instance.build();
        instance.reset();
        instance.setValues(result);
        result = instance.build();
        assertNotEquals(id, result.getId());
    }

    @Test
    public void testToString() {
        FakeModelObject result = instance.build();
        assertTrue(result.toString().contains("id="));
    }

}