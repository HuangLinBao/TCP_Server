package io.github.HuangLinBao;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread  {

    public ServerThread() throws IOException {
    }

    @Override
    public void run(){
        try {
            ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(Controller.aux_port.getText()));
            while (true){
                Socket connectionSocket = welcomeSocket.accept();
                String credentials;
                String[] str;
                String[] sent;
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                credentials = inFromClient.readLine();
                if(credentials.contains("-")){
                    Controller.sb.append(credentials).append("\n");
                    Controller.aux_online.setText(Controller.sb.toString());
                   sent = Controller.sb.toString().split("\n");
                   for (int i = 0;i < sent.length;i++){
                       str = sent[i].split("-");
                       Socket clientSocket = new Socket(str[1],Integer.parseInt(str[2]));
                       DataOutputStream outToPeer = new DataOutputStream(clientSocket.getOutputStream());
                       outToPeer.writeBytes(Controller.sb.toString());

                   }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
