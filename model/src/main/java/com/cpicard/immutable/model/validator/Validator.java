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

/**
 * A <code>Validator</code> is a utility that will perform a validation check on a parameter of a model object to ensure that the immutable form of
 * the object is always valid.
 *
 * @author Chris Picard
 * @version 0.0.1
 */
public interface Validator {
    /**
     * Format used to generate an unset error message. Unset errors occur when a mandatory value is not set.
     */
    String UNSET_ERROR_MESSAGE_FORMAT = "%s must be set";
    /**
     * Format used to generate an is set error message. Is set errors occur what a value that is supposed to be unset is set.
     */
    String IS_SET_ERROR_MESSAGE_FORMAT = "%s must not be set";
    /**
     * Format used to generate a greater than equal to error message. Greater than equal to errors occur what a value is not greater than or equal to
     * a provided value.
     */
    String GREATER_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT = "%s must be greater than equal to %s";
    /**
     * Format used to generate a less than equal to error message. Less than equal to errors occur what a value is not less than or equal to a
     * provided value.
     */
    String LESS_THAN_EQUAL_TO_ERROR_MESSAGE_FORMAT = "%s must be less than equal to %s";

    /**
     * Performs the validation check on the parameter the validator is for.
     *
     * @return Empty string if valid, error message if invalid.
     */
    String validate();
}
