package com.nasoftware;
import com.nasoftware.WebSystem.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        if(args.length != 1) {
            System.err.println("The argument should be port number!");
            System.exit(-1);
        }
        try {
            ServerManager serverManager = new ServerManager(Integer.parseInt(args[0]));
            serverManager.start();
        } catch (NumberFormatException e)
        {
            System.err.println("The argument should only contains numbers!");
            System.exit(-2);
        }
    }
}
