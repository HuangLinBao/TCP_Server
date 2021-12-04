package io.github.HuangLinBao;
import java.net.*;
import java.util.*;
import java.io.*;


import com.jfoenix.controls.*;
import javafx.event.*;
import javafx.fxml.*;

public class Controller implements Initializable {
    @FXML
    static JFXTextArea aux_online;
    @FXML
    static JFXTextField aux_port;
    @FXML
    JFXTextArea online;
    @FXML
    JFXTextField port;
    @FXML
    JFXComboBox<String> interfaces;
    static  StringBuilder sb = new StringBuilder();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            Controller.aux_online = online;
            Controller.aux_port = port;
            interfaces.getItems().removeAll(interfaces.getItems());
            interfaces.getItems().addAll("Loopback Pseudo-Interface 1: 192.168.2.107");
            interfaces.getSelectionModel().select("Loopback Pseudo-Interface 1: 192.168.2.107");
    }

    public void listen() throws IOException {
        new ServerThread().start();
        new RedirectThread().start();

    }
}
