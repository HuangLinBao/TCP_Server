package io.github.HuangLinBao;
import java.io.*;
import java.net.*;

public class RedirectThread extends Thread {
    @Override
    public void  run(){
        try {
            ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(Controller.aux_port.getText()));
            while (true){
                Socket connectionSocket = welcomeSocket.accept();
                String message;
                String[] msg;
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                message = inFromClient.readLine();
                if(message.contains(",")){
                    msg = message.split(",");
                    Socket clientSocket = new Socket(msg[1],Integer.parseInt(msg[2]));
                    DataOutputStream outToPeer = new DataOutputStream(clientSocket.getOutputStream());
                    outToPeer.writeBytes(msg[0]);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
