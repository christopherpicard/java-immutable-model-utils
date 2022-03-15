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

package com.cpicard.immutable.model.sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SampleModelObjectTest {
    private static final String NAME = "Name";
    private static final int ORDER = 2;

    @Test
    public void testBuild_NominalCase() {
        SampleModelObject.Builder instance = new SampleModelObject.Builder();
        instance.setName(NAME);
        instance.setOrder(ORDER);
        SampleModelObject result = instance.build();
        assertEquals(NAME, result.getName());
        assertEquals(ORDER, result.getOrder());
    }

    @Test
    public void testBuild_NoName() {
        SampleModelObject.Builder instance = new SampleModelObject.Builder();
        instance.setOrder(ORDER);
        assertThrows(IllegalStateException.class, instance::build);
    }

    @Test
    public void testBuild_NoOrder() {
        SampleModelObject.Builder instance = new SampleModelObject.Builder();
        instance.setName(NAME);
        assertThrows(IllegalStateException.class, instance::build);
    }

    @Test
    public void testCopyValues_NominalCase() {
        SampleModelObject.Builder builder = new SampleModelObject.Builder();
        builder.setName(NAME);
        builder.setOrder(ORDER);
        SampleModelObject sampleModelObject = builder.build();
        SampleModelObject.Builder instance = new SampleModelObject.Builder();
        instance.copyValues(sampleModelObject);
        SampleModelObject result = instance.build();
        assertEquals(sampleModelObject, result);
        assertEquals(sampleModelObject.getName(), result.getName());
        assertEquals(sampleModelObject.getOrder(), result.getOrder());
        assertEquals(sampleModelObject.getId(), result.getId());
    }

    @Test
    public void testSetValues_NominalCase() {
        SampleModelObject.Builder builder = new SampleModelObject.Builder();
        builder.setName(NAME);
        builder.setOrder(ORDER);
        SampleModelObject sampleModelObject = builder.build();
        SampleModelObject.Builder instance = new SampleModelObject.Builder();
        instance.setValues(sampleModelObject);
        SampleModelObject result = instance.build();
        assertEquals(sampleModelObject, result);
        assertEquals(sampleModelObject.getName(), result.getName());
        assertEquals(sampleModelObject.getOrder(), result.getOrder());
        assertNotEquals(sampleModelObject.getId(), result.getId());
    }
}