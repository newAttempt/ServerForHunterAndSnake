package com.nasoftware.WebSystem;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by zeyongshan on 7/17/17.
 */
public class Distributor extends Thread {

    private Socket server;

    public Distributor(Socket server)
    {
        this.server = server;
    }

    public void run()
    {
        while (true)
        {
            try {
                DataOutputStream out = new DataOutputStream(server.getOutputStream());

            } catch (IOException e){
                System.err.println("cannot create output stream!");
                break;
            }
        }
    }
}


/*
1-0|1-#                     Get room success or false with room number.
2-#-arg1-arg2....           the info of hunters in the room number.
3-#-arg1-arg2....           the info of snakes in the room number.
 */