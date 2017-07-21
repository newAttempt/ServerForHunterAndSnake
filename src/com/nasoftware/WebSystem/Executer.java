package com.nasoftware.WebSystem;

import com.nasoftware.Interfaces.DataMnager;
import com.nasoftware.Interfaces.EventHandlerVoid;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by zeyongshan on 7/17/17.
 */
public class Executer extends Thread {

    private Socket server;
    private String roomID;
    final   int    INST_NUM = 2;
    private int    instructionMap[];

    public Executer(Socket server)
    {
        this.server         = server;
        instructionMap      = new int[INST_NUM];
        instructionMap[0]   = 0 + 1;
        instructionMap[1]   = 3 + 1;
    }

    public void run()
    {
        while (server.isConnected())
        {
            try
            {
                DataInputStream in = new DataInputStream(server.getInputStream());
                String instruction = in.readUTF();
                parseInstructions(instruction);
            } catch (IOException e) {
                System.err.println("no input stream!");
                break;
            }
        }

    }

    private void parseInstructions(String instruction)
    {
        try{
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            if(instruction.equals(""))
                return;
            String temp[] = instruction.split(" ");
            if(temp.length != instructionMap[Integer.parseInt(temp[0])] || temp[0].length() != 1) {
                out.writeUTF("0");
                return;
            }
            switch (temp[0].toCharArray()[0])
            {
                case '0': {
                    EventHandlerVoid handler = () -> {
                        try {
                            out.writeUTF("s");
                        }catch (IOException e) {
                            System.err.println("fail to generate the dataOutputStream!");
                            return;
                        }
                    };
                    String id = DataMnager.setNewRole(handler);
                    out.writeUTF(id);
                    return;
                }
                case '1': {
                    if (temp[1].split("-").length != 2)
                        out.writeUTF("0");
                    try {
                        String parts[] = temp[1].split("-");
                        Integer.parseInt(parts[0]);
                        Integer.parseInt(parts[1]);
                        String id   = temp[1];
                        Double x    = Double.parseDouble(temp[2]);
                        Double y    = Double.parseDouble(temp[3]);
                        int result  = DataMnager.updatePosition(id, x, y);
                        if(result == 1) {
                            out.writeUTF("1");
                            return;
                        }
                        out.writeUTF("-1");
                        return;
                    } catch (NumberFormatException e) {
                        out.writeUTF("0");
                        return;
                    }
                }
                default: out.writeUTF("0");
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
0-0
return ID;


1:  updatePosition
1-3
instruction arg1 arg2 arg3
return 1|-1

return code:
"0"         wrong instruction format
 x|-x       success or false to run the code;
 s          start game!
 */