package io.github.HuangLinBao;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread  {



    static ServerSocket welcomeSocket;

    static {
        try {
            welcomeSocket = new ServerSocket(Integer.parseInt(Controller.aux_port.getText()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run(){
        try {
            while (true){
                Socket connectionSocket = welcomeSocket.accept();
                String credentials;
                String[] str;
                String[] sent;
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                credentials = inFromClient.readLine();
                if(credentials.contains("-")){
                    Controller.sb.append(credentials).append("\n");
                    Controller.aux_online.setText(Controller.sb.toString());
                   sent = Controller.sb.toString().split("\n");
                   for (int i = 0;i < sent.length;i++){
                       str = sent[i].split("-");
                       System.out.println(str[1]);
                       System.out.println(str[2]);
                       Socket clientSocket = new Socket(str[1].trim(),Integer.parseInt(str[2].trim()));
                       DataOutputStream outToPeer = new DataOutputStream(clientSocket.getOutputStream());
                       outToPeer.writeBytes(Controller.sb.toString());
                       clientSocket.close();

                   }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
