package com.cpicard.immutable.model.validator;

import org.apache.commons.lang3.StringUtils;

/**
 * A <code>ValidatorAbs</code> is the common implementation used by all validators that holds the name of the parameter being validated.
 *
 * @author Chris Picard
 * @version 0.0.1
 */
public abstract class ValidatorAbs implements Validator {
    /**
     * The name of the parameter being validated.
     */
    private final String name;

    /**
     * Base constructor.
     *
     * @param name Value of {@link #name}.
     */
    public ValidatorAbs(final String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Name must be set.");
        }
        this.name = name;
    }

    /**
     * Accessor for the {@link #name} member variable.
     *
     * @return Current value of the {@link #name} member variable.
     */
    protected String getName() {
        return name;
    }
}
