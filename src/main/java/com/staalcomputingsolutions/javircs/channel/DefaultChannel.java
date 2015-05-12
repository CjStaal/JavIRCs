/*
 * Copyright (C) 2015 Charles Joseph Staal
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.staalcomputingsolutions.javircs.channel;

import com.staalcomputingsolutions.javircs.client.Client;

/**
 * This is the default channel object. The constructor takes a ChannelContext
 * object and uses that for all the information that the channel needs to be set
 * up.
 *
 * @author Charles Joseph Staal
 */
public class DefaultChannel implements Channel {

    private ChannelContext context;

    /**
     * This is used to create the channel. 
     * @param context {@link ChannelContext} object for configuration.
     */
    public DefaultChannel(final ChannelContext context) {
        this.context = context;
    }

    /**
     * Returns the {@link ChannelContext} object.
     * @return {@link ChannelContext}
     */
    public ChannelContext getChannelContext() {
        return this.context;
    }

    /**
     * Returns the current mode of the channel.
     * @return {@link String} object with the current mode.
     */
    @Override
    public String getMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Removes a {@link Client} member.
     * @param clientToBeRemoved {@link Client} to be removed.
     */
    @Override
    public void removeMember(Client clientToBeRemoved) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
