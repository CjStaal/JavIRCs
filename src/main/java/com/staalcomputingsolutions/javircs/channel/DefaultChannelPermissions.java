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

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultChannelPermissions {

    private boolean OnlyOpsCanChangeTopic = true;
    private boolean NoChannelCtcp = false;
    private boolean NoChannelColours = false;
    private boolean RequiresKey = false;
    private boolean IsModerated = false;
    private boolean IsModeratedForNonAuthed = false;
    private boolean IsSecret = false;
    private boolean IsInviteOnly = false;

    public boolean isOnlyOpsCanChangeTopic() {
        return this.OnlyOpsCanChangeTopic;
    }

    public void setOnlyOpsCanChangeTopic(boolean OnlyOpsCanChangeTopic) {
        this.OnlyOpsCanChangeTopic = OnlyOpsCanChangeTopic;
    }

    public boolean isNoChannelCtcp() {
        return this.NoChannelCtcp;
    }

    public void setNoChannelCtcp(boolean NoChannelCtcp) {
        this.NoChannelCtcp = NoChannelCtcp;
    }

    public boolean isNoChannelColours() {
        return this.NoChannelColours;
    }

    public void setNoChannelColours(boolean NoChannelColours) {
        this.NoChannelColours = NoChannelColours;
    }

    public boolean isRequiresKey() {
        return this.RequiresKey;
    }

    public void setRequiresKey(boolean RequiresKey) {
        this.RequiresKey = RequiresKey;
    }

    public boolean isIsModerated() {
        return this.IsModerated;
    }

    public void setIsModerated(boolean IsModerated) {
        this.IsModerated = IsModerated;
    }

    public boolean isIsModeratedForNonAuthed() {
        return this.IsModeratedForNonAuthed;
    }

    public void setIsModeratedForNonAuthed(boolean IsModeratedForNonAuthed) {
        this.IsModeratedForNonAuthed = IsModeratedForNonAuthed;
    }

    public boolean isIsSecret() {
        return this.IsSecret;
    }

    public void setIsSecret(boolean IsSecret) {
        this.IsSecret = IsSecret;
    }

    public boolean isIsInviteOnly() {
        return this.IsInviteOnly;
    }

    public void setIsInviteOnly(boolean IsInviteOnly) {
        this.IsInviteOnly = IsInviteOnly;
    }
    
}
