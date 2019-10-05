package com.abdheshnayak.mysqllearner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;

public class Mainwindow {
    @FXML
    public TextArea inputStatement;
    @FXML
    public Button readTypeStatement;
    @FXML
    public Button writeTypeStatement;
    @FXML
    public TextArea outputScreen;
    @FXML
    public Label loadingLabel;

    dataBase db;
    boolean flag=false;

    public Mainwindow() throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException, IOException {
        try {
            db=new dataBase();
        }catch (Exception e){
//            System.out.println(e);
//            setLabelLoading(true);
            flag=true;
        }
//        setLabelLoading(true);
    }

    public void initialize() throws SQLException {

        if(flag){
            loadingLabel.setText("Wrong Creditionals...\nServer is not Connected");
        }
    }

    public void runQuery(MouseEvent mouseEvent) throws InterruptedException, SQLException {


//        this.setLabelLoading(true);
        if(mouseEvent.getSource().equals(readTypeStatement)){

            String result=null;

            staticClass.waitVar=true;

            try {
                result = db.read(inputStatement.getText().trim());
            }catch (Exception e){
//                System.out.println(e);
            }
//            setLabelLoading(false);
//            while (staticClass.waitVar){
//                setLabelLoading(true);
//            }
//            setLabelLoading(false);
//            loadingLabel.setText("ram");
            if(result==null){
                outputScreen.setText(staticClass.commonString);
//                System.out.println(staticClass.commonString);
            }else {
                outputScreen.setText(result);
//                System.out.println(result);
            }
        }else if(mouseEvent.getSource().equals(writeTypeStatement)){

            boolean result=false;
            try {
                result = db.write(inputStatement.getText().trim());
            }catch (Exception e){
//                System.out.println(e);
            }
            if(result){
                outputScreen.setText("Written");
            }else {
                outputScreen.setText(staticClass.commonString);
            }
        }
    }
}
