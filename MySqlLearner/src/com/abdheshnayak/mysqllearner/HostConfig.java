package com.abdheshnayak.mysqllearner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HostConfig {
    @FXML
    public TextField host;
    @FXML
    public TextField port;
    @FXML
    public TextField database;
    @FXML
    public TextField userName;
    @FXML
    public PasswordField password;
    @FXML
    public Button startbtn;

    public void initialize(){
        host.setText(staticClass.host);
        port.setText(staticClass.port);
        database.setText(staticClass.database);
        userName.setText(staticClass.user);
        password.setText(staticClass.password);

    }

    public void startFun(MouseEvent mouseEvent) throws IOException {
        if(mouseEvent.getSource().equals(startbtn)){
            staticClass.host=host.getText().trim();
            staticClass.port=port.getText().trim();
            staticClass.database=database.getText().trim();
            staticClass.user=userName.getText().trim();
            staticClass.password=password.getText().trim();
//            System.out.println(staticClass.password);
            if(staticClass.password.equals(null)){
                staticClass.password="";
            }

//            System.out.println(staticClass.user+"\n"+staticClass.database+"\n"+staticClass.url);
            Stage st= (Stage) startbtn.getScene().getWindow();
            st.close();
            BorderPane root=(BorderPane)FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
            Scene scene= new Scene(root,600,600);
            st.setScene(scene);
            st.show();
        }
    }
}
