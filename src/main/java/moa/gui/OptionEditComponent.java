/*
 *    OptionEditComponent.java
 *    Copyright (C) 2007 University of Waikato, Hamilton, New Zealand
 *    @author Richard Kirkby (rkirkby@cs.waikato.ac.nz)
 *
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package moa.gui;

import moa.options.Option;

/**
 * Interface representing a component to edit an option. 
 *
 * @author Richard Kirkby (rkirkby@cs.waikato.ac.nz)
 * @version $Revision: 7 $ 
 */
public interface OptionEditComponent {

    /**
     * Gets the option of this component
     *
     * @return the option of this component
     */
    public Option getEditedOption();

    /**
     * Sets the state of the component
     *
     * @param cliString the state of the component
     */
    public void setEditState(String cliString);

    /**
     * This method applies the state
     *
     */
    public void applyState();
}
