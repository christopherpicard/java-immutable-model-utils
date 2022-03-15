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

import com.cpicard.immutable.model.ModelObjectAbs;
import com.cpicard.immutable.model.validator.MandatoryIntValidator;
import com.cpicard.immutable.model.validator.MandatoryStringValidator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A <code>User</code> is a player in the fantasy soccer management game. Each user is allowed a single team in the game.
 * <P>
 * This object is immutable. To modify use the object's builder class. You can use the @{link Builder#copyValues} method
 * to initialize the builder to the original values.
 * </P>
 *
 * @author Chris Picard
 * @version 0.0.1
 */
public final class SampleModelObject extends ModelObjectAbs {
    /**
     * The name of the object.
     */
    private final String name;
    /**
     * The email address of the user which is used to identify the user.
     */
    private final int order;

    /**
     * Base constructor that will populate the <code>User</code> with the values from the provided builder.
     * This method is private to ensure that the builder is used to instantiate the class to ensure that all the checks are validated.
     *
     * @param builder Fully populated builder that has been validated.
     */
    private SampleModelObject(final Builder builder) {
        super(builder);
        this.name = builder.name;
        this.order = builder.order;
    }

    /**
     * Accessor for the {@link #name} member variable.
     *
     * @return Current value of the {@link #name} member variable.
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor for the {@link #order} member variable.
     *
     * @return Current value of the {@link #order} member variable.
     */
    public int getOrder() {
        return order;
    }

    // BEGIN_GENERATED_CODE

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SampleModelObject that = (SampleModelObject) o;

        return new EqualsBuilder()
                .append(name, that.name)
                .append(order, that.order)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(order)
                .toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    // END_GENERATED_CODE

    /**
     * The builder class provides the ability to populate all the values of a model object, validate if the model object content, and provide an
     * immutable version of the model object.
     */
    public static final class Builder extends ModelObjectAbs.Builder<SampleModelObject> {
        /**
         * Builder representation of {@link SampleModelObject#name}.
         */
        private String name;
        /**
         * Builder representation of {@link SampleModelObject#order}.
         */
        private int order;

        public Builder() {
            addValidator(new MandatoryStringValidator("Name", this::getName));
            addValidator(new MandatoryIntValidator("Order", this::getOrder));
        }

        @Override
        public SampleModelObject build() {
            validate();
            return new SampleModelObject(this);
        }

        @Override
        public void reset() {
            super.reset();
            name = null;
            order = 0;
        }

        @Override
        public void copyValues(final SampleModelObject user) {
            super.copyValues(user);
            setValues(user);
        }

        @Override
        public void setValues(final SampleModelObject user) {
            super.setValues(user);
            this.name = user.getName();
            this.order = user.getOrder();
        }

        /**
         * Accessor for the {@link SampleModelObject#name} member variable.
         *
         * @return Current value of the {@link SampleModelObject#name} member variable.
         */
        public String getName() {
            return name;
        }

        /**
         * Mutator for the {@link SampleModelObject#name} member variable.
         *
         * @param name New value of the {@link SampleModelObject#name} member variable.
         */
        public void setName(final String name) {
            this.name = name;
        }

        /**
         * Accessor for the {@link SampleModelObject#order} member variable.
         *
         * @return Current value of the {@link SampleModelObject#order} member variable.
         */
        public int getOrder() {
            return order;
        }

        /**
         * Mutator for the {@link SampleModelObject#order} member variable.
         *
         * @param order New value of the {@link SampleModelObject#order} member variable.
         */
        public void setOrder(final int order) {
            this.order = order;
        }
    }
}
