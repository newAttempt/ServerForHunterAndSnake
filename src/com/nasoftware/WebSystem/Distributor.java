package com.nasoftware.WebSystem;

import com.nasoftware.Interfaces.DataMnager;
import sun.text.normalizer.Trie;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by zeyongshan on 7/17/17.
 */


public class Distributor extends Thread {

    private Socket server;
    private String userID;

    public Distributor(Socket server, String userID)
    {
        this.server = server;
        this.userID = userID;
    }

    public void run()
    {
        while (true)
        {
            try {
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                while (server.isConnected()) {
                    String info = DataMnager.getInfoOfCurrentRoom(userID);
                    if(info!=null)
                        out.writeUTF(info);
                    sleep(10);
                }
            } catch (IOException e){
                System.err.println("cannot create output stream!");
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/*
1-0|1-#                     Get room success or false with room number.
2-#-arg1-arg2....           the info of hunters in the room number.
3-#-arg1-arg2....           the info of snakes in the room number.
 */