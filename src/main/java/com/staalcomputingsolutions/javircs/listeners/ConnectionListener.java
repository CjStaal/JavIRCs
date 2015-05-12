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
import com.staalcomputingsolutions.javircs.server.ClientHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Charles Joseph Staal
 */
public class ConnectionListener implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private int port = 1380; //Default port.

    private final AtomicBoolean started;

    private SocketAddress serverSocketAddress;

    public ConnectionListener(int port) {
        this.started = new AtomicBoolean();
        this.started.set(false);
        this.setPort(port);
        this.logger.info("New connection listener with name: " + this.getClass().getName() + ", created.");
    }

    @Override
    public void run() {
        this.started.set(true);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            this.serverSocketAddress = serverSocket.getLocalSocketAddress();

            int counter = 0;

            while (started.get()) {
                /* Probably going to use a different method to handle new clients as this will take too long in my opinion. */
                ClientHandler.handleNewClient(ClientFactory.createClient(serverSocket.accept(), counter++));
            }
        } catch (IOException ex) {
            logger.error("Error in run method of +" + this.getClass().getName(), ex);
        }
        this.started.set(false);
    }

    public void setPort(int port) {
        this.port = port;
        logger.info(this.getClass().getName() + " port has been set to " + this.getPort());
    }
    
    public int getPort(){
        return this.port;
    }

    public SocketAddress getServerSocketAddress() {
        return this.serverSocketAddress;
    }

    public boolean isStarted() {
        return this.started.get();
    }

    public void setRunning(boolean running) {
        this.started.set(running);
    }
}
