package com.example.a;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class adminn implements Initializable {
    private int mistake = 0;
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Button backk;

    @FXML
    private Button loginn;

    @FXML
    private TextField P;

    @FXML
    private TextField U;

    @FXML
    void backkk(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        lb1.setVisible(false);
        lb2.setVisible(false);
    }

    @FXML
    void llogin(MouseEvent event) {
        mistake=0;
       if(Se()){
            try(DataInputStream i = new DataInputStream(new FileInputStream("Data/"+U.getText()+".txt"));){
                i.readUTF();
                String u = i.readUTF();
                if(P.getText().equals(u)){
                    Parent root = FXMLLoader.load(getClass().getResource("News.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else {
                    Alert a = new Alert(Alert.AlertType.ERROR,"Password Incorect");
                    a.showAndWait();
                }
            }catch (FileNotFoundException ex){
                Alert l = new Alert(Alert.AlertType.ERROR,"user not found");
                l.showAndWait();
            }catch (IOException ex){
                Alert l = new Alert(Alert.AlertType.ERROR,"Mistake");
                l.showAndWait();
            }
        }
    }
    public Boolean Se(){
        if(U.getText().isEmpty()){
            lb1.setVisible(true);
            mistake=1;
        }else{
            lb1.setVisible(false);
            mistake=0;
        }
        if(P.getText().isEmpty()){
            lb2.setVisible(true);
            mistake=-1;
        }else {
            lb2.setVisible(false);
            mistake=0;
        }
        return mistake==0;

    }


}

