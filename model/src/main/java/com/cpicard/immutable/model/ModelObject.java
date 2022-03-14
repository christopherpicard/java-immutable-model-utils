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

/**
 * A <code>ModelObject</code> is any domain model object that models a piece of domain for an application. These items are unique items that are used
 * in the application object.
 *
 * @author Chris Picard
 * @version 0.0.1
 */
public interface ModelObject {

    /**
     * Accessor for the id of the model object. The id is a globally unique id that can be used to identify the model object on any system.
     *
     * @return Globally unique id for the model object.
     */
    UUID getId();
}
