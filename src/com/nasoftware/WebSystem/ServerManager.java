package com.nasoftware.WebSystem;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zeyongshan on 7/17/17.
 */

public class ServerManager extends Thread
{

    private ServerSocket serverSocket;

    public ServerManager(int port)
    {
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
        } catch (IOException e)
        {
            System.err.print("fail to create serverSocket!");
            System.exit(-2);
        }
    }

    public void run()
    {
        while (true)
        {
            try
            {
                Socket server = serverSocket.accept();
                Distributor distributor = new Distributor(server);
                Executer    executer    = new Executer(server);
                distributor.start();
                executer.start();
                System.err.println("port " + serverSocket.getLocalPort() + "just connected!!!!!");
            } catch (SocketTimeoutException e)
            {
                System.err.println("port " + serverSocket.getLocalPort() + "time out!");
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}