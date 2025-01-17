package com.example.a;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Forgett implements Initializable {
    @FXML
    private TextField E;

    @FXML
    private TextField P;

    @FXML
    private TextField U;
    @FXML
    private Button backk;
    @FXML
    private Button s;
    @Override
    public void initialize(URL url, ResourceBundle bundle){
        P.setVisible(false);
    }

    @FXML
    void backkk(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
     void SS(MouseEvent event){
        if(U.getText().isEmpty()){
            Alert l = new Alert(Alert.AlertType.ERROR,"Username is empty");
            l.showAndWait();
        }
        try(DataInputStream i = new DataInputStream(new FileInputStream("Data/"+U.getText()+".txt"))){
         i.readUTF();
        String a2 = i.readUTF();
        String a3 = i.readUTF();
        if(a3.equals(E.getText())){
            P.setText(a2);
            P.setVisible(true);
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR,"Email incorect");
            a.showAndWait();
        }
        }catch (FileNotFoundException ex){
            Alert l = new Alert(Alert.AlertType.ERROR,"File not exist");
            l.showAndWait();
        }catch(IOException ex){
          ex.printStackTrace();
        }
    }
}
