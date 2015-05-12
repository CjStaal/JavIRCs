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
package com.staalcomputingsolutions.javircs.server;

import com.staalcomputingsolutions.javircs.client.Client;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Joseph Staal
 */
public class ServerClientList {

    private List<Client> serverClientList = new ArrayList();
    
    public ServerClientList(){
        
    }
    
    public void removeClient(Client client){
        this.serverClientList.remove(client);
    }
    
    public void addClient(Client client) {
        this.serverClientList.add(client);
    }

    public Iterable<Client> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
