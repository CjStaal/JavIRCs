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

import com.staalcomputingsolutions.javircs.client.ClientFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author Charles Joseph Staal
 */
public class ConnectionListener implements Runnable{
    
    private static AtomicBoolean started = new AtomicBoolean();

    private static SocketAddress serverSocketAddress;
    private static int port = 1380;
    
    private static ServerClientList serverClientList;
    
    private static ConnectionListener instance = null;
    
    private ConnectionListener(){
        ConnectionListener.started.set(false);
    }
    
    public ConnectionListener getInstance(){
        if(instance == null){
            instance = new ConnectionListener();
        }
        return instance;
    }
    
    @Override
    public void run() {
        ConnectionListener.started.set(true);
        try(ServerSocket serverSocket = new ServerSocket(port)){
            ConnectionListener.serverSocketAddress = serverSocket.getLocalSocketAddress();
            
            int counter = 0;
            
            while(started.get()){
                ConnectionListener.serverClientList.addClient(ClientFactory.createClient(serverSocket.accept(), counter++));
            }
        } catch (IOException ex){
            
        }
    }
    
    public static void setPort(int port) throws ConnectionListenerException{
        if(instance != null){
            ConnectionListener.port = port;
        } else {
            throw new ConnectionListenerException("The connection listener has not been initialized.");
        }
    }
    
    public static void setClientList(ServerClientList serverClientList) throws ConnectionListenerException{
        if(instance != null){
            ConnectionListener.serverClientList = serverClientList;
        } else {
            throw new ConnectionListenerException("The connection listener has not been initialized.");
        }
    }
    
    public static SocketAddress getServerSocketAddress(){
        return ConnectionListener.serverSocketAddress;
    }
    
    public static boolean isStarted(){
        return ConnectionListener.started.get();
    }
}
