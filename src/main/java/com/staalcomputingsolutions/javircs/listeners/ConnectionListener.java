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
package com.staalcomputingsolutions.javircs.listeners;

import com.staalcomputingsolutions.javircs.client.factory.ClientFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author Charles Joseph Staal
 */
public class ConnectionListener implements Runnable {

    private int port = 1380; //Default port.

    private final AtomicBoolean started;

    private ServerClientList serverClientList;

    private SocketAddress serverSocketAddress;

    public ConnectionListener() {
        this.started = new AtomicBoolean();
        this.started.set(false);
        this.serverClientList = new ServerClientList(); //Default serverClientList.
    }

    public ConnectionListener setServerClientList(ServerClientList serverClientList) {
        this.serverClientList = serverClientList;
        return this;
    }

    public ConnectionListener setPort(int port) {
        this.port = port;
        return this;
    }

    @Override
    public void run() {
        this.started.set(true);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            this.serverSocketAddress = serverSocket.getLocalSocketAddress();

            int counter = 0;

            while (started.get()) {
                this.serverClientList.addClient(ClientFactory.createClient(serverSocket.accept(), counter++));
            }
        } catch (IOException ex) {

        }
        this.started.set(false);
    }

    public ServerClientList getServerClientList() {
        return this.serverClientList;
    }

    public SocketAddress getServerSocketAddress() {
        return this.serverSocketAddress;
    }

    public boolean isStarted() {
        return this.started.get();
    }
}
