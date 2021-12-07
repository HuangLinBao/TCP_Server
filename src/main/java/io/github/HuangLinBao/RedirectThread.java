package io.github.HuangLinBao;
import java.io.*;
import java.net.*;

public class RedirectThread extends Thread {
    @Override
    public void  run(){
        try {
            //ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(Controller.aux_port.getText()));
            while (true){
                Socket connectionSocket = ServerThread.welcomeSocket.accept();
                String message;
                String[] msg;
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                message = inFromClient.readLine();
                if(message.contains(",")){
                    msg = message.split(",");
                    System.out.println(msg[1]);
                    System.out.println(msg[2]);
                    Socket clientSocket = new Socket(msg[1],Integer.parseInt(msg[2]));
                    DataOutputStream outToPeer = new DataOutputStream(clientSocket.getOutputStream());
                    outToPeer.writeBytes(msg[0]);
                    clientSocket.close();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
