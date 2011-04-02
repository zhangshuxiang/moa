/*
 *    AbstractStreamFilter.java
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
package moa.streams.filters;

import moa.core.ObjectRepository;
import moa.options.AbstractOptionHandler;
import moa.streams.InstanceStream;
import moa.tasks.TaskMonitor;

/**
 * Abstract Stream Filter.
 *
 * @author Richard Kirkby (rkirkby@cs.waikato.ac.nz)
 * @version $Revision: 7 $
 */
public abstract class AbstractStreamFilter extends AbstractOptionHandler
        implements StreamFilter {

    /** The input stream to this filter. */
    protected InstanceStream inputStream;

    @Override
    public void setInputStream(InstanceStream stream) {
        this.inputStream = stream;
        prepareForUse();
    }

    @Override
    public void prepareForUseImpl(TaskMonitor monitor,
            ObjectRepository repository) {
        restartImpl();
    }

    @Override
    public long estimatedRemainingInstances() {
        return this.inputStream.estimatedRemainingInstances();
    }

    @Override
    public boolean hasMoreInstances() {
        return this.inputStream.hasMoreInstances();
    }

    @Override
    public boolean isRestartable() {
        return this.inputStream.isRestartable();
    }

    @Override
    public void restart() {
        this.inputStream.restart();
        restartImpl();
    }

    /**
     * Restarts this filter. All instances that extends from
     * <code>AbstractStreamFilter</code> must implement <code>restartImpl</code>.
     * <code>restart</code> uses <code>restartImpl</code> in <code>AbstractStreamFilter</code>.
     */
    protected abstract void restartImpl();
}
