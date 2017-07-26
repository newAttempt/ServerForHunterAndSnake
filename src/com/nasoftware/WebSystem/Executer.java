package com.nasoftware.WebSystem;

import com.nasoftware.Interfaces.DataMnager;
import com.nasoftware.Interfaces.EventHandlerVoid;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by zeyongshan on 7/17/17.
 */
public class Executer extends Thread {

    private Socket server;
    private String roomID;
    final   int    INST_NUM = 3;
    private int    instructionMap[];

    public Executer(Socket server)
    {
        this.server         = server;
        instructionMap      = new int[INST_NUM];
        instructionMap[0]   = 0 + 1;
        instructionMap[1]   = 3 + 1;
        instructionMap[2]   = 1 + 1;
    }

    public void run()
    {
        while (server.isConnected())
        {
            try
            {
                InputStream in = server.getInputStream();
                int len = in.available();
                byte[] buff = new byte[len];
                try {
                    int flag = in.read(buff);
                    if(flag == -1) {
                        break;
                    }
                } catch (SocketException e) {}
                String instruction = new String(buff);
                if(instruction.equals(""))
                    continue;
                System.out.println(instruction);
                String temp[] = instruction.split("x");
                for(String x : temp)
                {
                    if(x.equals("") || x.equals("x"))
                        continue;
                    System.out.println(x);
                    parseInstructions(x);
                }
            } catch (IOException e) {
                System.err.println("no input stream!");
                break;
            }
        }

    }

    private void parseInstructions(String instruction)
    {
        try{
            OutputStream out = server.getOutputStream();
            if(instruction.equals(""))
                return;
            String temp[] = instruction.split(" ");
            try {
                if(Integer.parseInt(temp[0]) > INST_NUM) {
                    out.write(new String("0").getBytes("UTF-8"));
                    return;
                }
                if(temp.length != instructionMap[Integer.parseInt(temp[0])] || temp[0].length() != 1) {
                    out.write(new String("0").getBytes("UTF-8"));
                    return;
                }
            } catch (NumberFormatException e) {
                out.write(new String("0").getBytes("UTF-8"));
                return;
            }

            switch (temp[0].toCharArray()[0])
            {
                case '0': {
                    EventHandlerVoid handler = () -> {
                        try {
                            out.write(new String("0 s").getBytes("UTF-8"));
                        }catch (IOException e) {
                            System.err.println("fail to generate the dataOutputStream!");
                            return;
                        }
                    };
                    String id ="0 " + DataMnager.setNewRole(handler);
                    out.write(id.getBytes("UTF-8"));
                    return;
                }
                case '1': {
                    if (temp[1].split("-").length != 2)
                        out.write(new String("1 0").getBytes("UTF-8"));
                    try {
                        String parts[] = temp[1].split("-");
                        Integer.parseInt(parts[0]);
                        Integer.parseInt(parts[1]);
                        String id   = temp[1];
                        Double x    = Double.parseDouble(temp[2]);
                        Double y    = Double.parseDouble(temp[3]);
                        int result  = DataMnager.updatePosition(id, x, y);
                        if(result == 1) {
                            out.write(new String("1 1").getBytes("UTF-8"));
                            return;
                        }
                        out.write(new String("1 -1").getBytes("UTF-8"));
                        return;
                    } catch (NumberFormatException e) {
                        out.write(new String("1 0").getBytes("UTF-8"));
                        return;
                    }
                }
                case '2': {
                    String userID = temp[1];
                    Distributor distributor = new Distributor(server, userID);
                    distributor.start();
                    break;
                }
                default:
                    out.write(new String("2 0").getBytes("UTF-8"));
            }
        } catch (IOException e) {
            System.err.println("fail to generate the dataOutputStream!");
        }
    }
}


/*
command explanation:
command-argNumbers
0:  getPositionFromRoom
0 0
return ID;


1:  updatePosition
1 3
instruction arg1 arg2 arg3
return 1|-1

2:  setUserID
2 1

return code:
"0"         wrong instruction format
 x|-x       success or false to run the code;
 s          start game!
 */