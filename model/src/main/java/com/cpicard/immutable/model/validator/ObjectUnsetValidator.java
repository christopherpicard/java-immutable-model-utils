package com.cpicard.immutable.model.validator;

import java.util.function.Supplier;

/**
 * A <code>ObjectUnsetValidator</code> is a validator that validates if an object is not set. This handles the case where there is a choice between
 * values. It will enforce that the choices not picked are not set.
 *
 * @author Chris Picard
 * @version 0.0.1
 */
public final class ObjectUnsetValidator extends ValidatorAbs {
    /**
     * The supplier of the value of the parameter to validate that it is unset.
     */
    private final Supplier<Object> valueSupplier;

    /**
     * Base constructor.
     *
     * @param name Value of {@link ValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     */
    public ObjectUnsetValidator(final String name, final Supplier<Object> valueSupplier) {
        super(name);
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
    }

    @Override
    public String validate() {
        String result = "";
        if (valueSupplier.get() != null) {
            result = String.format(IS_SET_ERROR_MESSAGE_FORMAT, getName());
        }
        return result;
    }
}
