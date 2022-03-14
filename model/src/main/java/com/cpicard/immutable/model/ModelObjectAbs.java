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

import java.util.Objects;
import java.util.UUID;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <code>ModelObjectAbs</code> is designed to serve as the parent class for {@link ModelObject}s. It contains all the common logic needed by model all
 * model objects.
 *
 * @author Chris Picard
 * @version 0.0.1
 */
public abstract class ModelObjectAbs implements ModelObject {
    /**
     * Globally unique id that identifies the model object on any system.
     */
    private final UUID id;

    /**
     * Base constructor that will populate the <code>ModelObjectAbs</code> with the values from the provided builder.
     * This method is protected to ensure that the class is immutable and always valid, but allow for child classes to extend it.
     *
     * @param builder Fully populated builder that has been validated.
     */
    protected ModelObjectAbs(final Builder<?> builder) {
        this.id = Objects.requireNonNullElseGet(builder.id, UUID::randomUUID);
    }

    /**
     * Accessor for the value of {@link #id}.
     *
     * @return Value of {@link #id}.
     */
    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * The builder class provides the ability to populate all the values of a model object, validate the model object content, and provide an
     * immutable version of the model object.
     *
     * @param <T> The class the builder is constructing.
     */
    public abstract static class Builder<T extends ModelObjectAbs> extends BuilderAbs<T> {
        /**
         * Builder value for {@link ModelObjectAbs#id}.
         */
        private UUID id;

        @Override
        public void copyValues(final T modelObject) {
            this.id = modelObject.getId();
        }

        @Override
        public void setValues(final T modelObject) {
        }

        @Override
        public void reset() {
            id = null;
        }

        /**
         * Mutator for the value of {@link ModelObjectAbs#id}.
         *
         * @param id New value of {@link ModelObjectAbs#id}.
         */
        public void setId(final UUID id) {
            this.id = id;
        }
    }
}
