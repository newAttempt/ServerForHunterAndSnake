package com.nasoftware.WebSystem;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by zeyongshan on 7/17/17.
 */
public class Executer extends Thread {

    private Socket server;
    private String roomID;

    public Executer(Socket server)
    {
        this.server = server;
    }

    public void run()
    {
        while (server.isConnected())
        {
            try
            {
                DataInputStream in = new DataInputStream(server.getInputStream());
            } catch (IOException e) {
                System.err.println("no input stream!");
                break;
            }
        }

    }
}


/*
command explanation:
command-argNumbers
1:      0      getRoom
 */