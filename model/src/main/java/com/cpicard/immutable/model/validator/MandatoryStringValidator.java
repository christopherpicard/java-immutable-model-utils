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
import org.apache.commons.lang3.StringUtils;

/**
 * A <code>MandatoryStringValidator</code> is a validator that validates if a mandatory string is set. In this context a set string is one that is not
 * null and is not empty.
 *
 * @author Chris Picard
 * @version 0.0.1
 */
@SuppressWarnings("JavadocReference")
public final class MandatoryStringValidator extends ValidatorAbs {
    /**
     * The supplier of the value of the string parameter to validate that it is set.
     */
    private final Supplier<String> valueSupplier;

    /**
     * Base constructor.
     *
     * @param name Value of {@link ValidatorAbs#name}.
     * @param valueSupplier Value of {@link #valueSupplier}.
     */
    public MandatoryStringValidator(final String name, final Supplier<String> valueSupplier) {
        super(name);
        if (valueSupplier == null) {
            throw new IllegalArgumentException("Value supplier can not be null");
        }
        this.valueSupplier = valueSupplier;
    }

    @Override
    public String validate() {
        String result = "";
        if (StringUtils.isEmpty(valueSupplier.get())) {
            result = String.format(MandatoryObjectValidator.UNSET_ERROR_MESSAGE_FORMAT, getName());
        }
        return result;
    }
}
