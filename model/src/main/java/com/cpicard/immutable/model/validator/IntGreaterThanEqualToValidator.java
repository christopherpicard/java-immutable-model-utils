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

package com.cpicard.immutable.model.validator;

import java.util.function.Supplier;

/**
 * A <code>IntGreaterThanEqualToValidator</code> is a validator that validates if a parameter is greater than or equal to the provided value.
 *
 * @author Chris Picard
 * @version 0.0.1
 */
public final class IntGreaterThanEqualToValidator extends ValidatorAbs {
    /**
     * The supplier of the value of the int parameter to validate that it is greater than or equal to the min value.
     */
    private final Supplier<Integer> valueSupplier;
    /**
     * The min value to validate if the parameter is greater than or equal to.
     */
    private final int minValue;

    /**
     * Base constructor.
     *
     * @param name Value of {@link ValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     * @param minValue Value of {@link #minValue}.
     */
    public IntGreaterThanEqualToValidator(final String name, final Supplier<Integer> valueSupplier, final int minValue) {
        super(name);
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
        this.minValue = minValue;
    }

    @Override
    public String validate() {
        String result = "";
        Integer value = valueSupplier.get();
        if (value != null && value > minValue) {
            result = String.format(GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT, getName(), minValue);
        }
        return result;
    }
}
