package com.example.a;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {
    private int mistake=0;

    @FXML
    private Button forgetPassword;

    @FXML
    private Button signUp;
    @FXML
    private Button loginn;

    @FXML
    private PasswordField passwordd;

    @FXML
    private CheckBox rem;

    @FXML
    private TextField U;
    @FXML
    private TextField P;
    @FXML
    private Label lb1;

    @FXML
    private Label lb2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
     lb1.setVisible(false);
     lb2.setVisible(false);
        File files = new File("Save");

        try(  DataInputStream i = new DataInputStream(new FileInputStream("Save/user.txt"));) {
            if (U.getText().isEmpty() && P.getText().isEmpty()) {
                U.setText(i.readUTF());
                P.setText(i.readUTF());
                mistake=0;
            }
        }catch (EOFException ex){
            System.out.print("");
        }
        catch(FileNotFoundException ex){
            Alert a = new Alert(Alert.AlertType.ERROR,"File not exist");
            a.showAndWait();
            mistake=1;
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

    @FXML
    void adminn(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminn.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void ssignup(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void llogin(ActionEvent event) {
        mistake=0;
        if(Se() && Folder() &&  createMe() &&Rem()) {
            File f = new File("Data/" + U.getText() + ".txt");
            if (f.exists()) {
                try (DataInputStream i = new DataInputStream(new FileInputStream("Data/" + U.getText() + ".txt"));) {
                    i.readUTF();
                    String u = i.readUTF();
                    if (P.getText().equals(u)) {
                        Parent root = FXMLLoader.load(getClass().getResource("News.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Password incorrect");
                        alert.showAndWait();
                    }
                } catch (EOFException ex) {
                    System.out.print("");
                } catch (FileNotFoundException ex) {
                    Alert l = new Alert(Alert.AlertType.ERROR, "user not found");
                    l.showAndWait();
                } catch (IOException ex) {
                    Alert l = new Alert(Alert.AlertType.ERROR, "Mistake");
                    l.showAndWait();
                }
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "User not exist");
                a.showAndWait();
            }
        }
    }
    @FXML
    void fforget(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Forgett.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     Boolean Se(){
        if(U.getText().isEmpty()){
            lb1.setVisible(true);
            mistake=1;
        }else{
            lb1.setVisible(false);
        }
        if(P.getText().isEmpty()){
            lb2.setVisible(true);
            mistake=-1;
        }else {
            lb2.setVisible(false);
        }
        return mistake==0;

    }
    Boolean createMe(){

        return mistake==0;
    }
    Boolean Rem(){
        String s = "";
          try(DataOutputStream o = new DataOutputStream(new FileOutputStream("Save/user.txt"))){
                 if(rem.isSelected()){
                  o.writeUTF(U.getText()+"");
                  o.writeUTF(P.getText()+"");
                 }else{
                 o.writeUTF(s);
                 o.writeUTF(s);
                 }
          }catch (IOException ex){
              mistake=1;
              ex.printStackTrace();
          }
          return mistake == 0;
    }
     private  Boolean Folder(){
        File files = new File("Data");
        if(files.exists()==false){
            files.mkdir();
            try {
                File x = new File("Data/DataBase.txt");
                if (x.createNewFile()) {
                    mistake=0;
                    System.out.println(x.getName());
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
                mistake=-1;
            }catch (IOException ex){
                ex.printStackTrace();
                mistake=-1;
            }
            mistake=0;
        }
        return mistake==0;

    }


}
