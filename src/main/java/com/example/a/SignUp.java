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
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

public class SignUp implements Initializable {
    private String customers="";
    private  int mistake = 0;
    private String info="";
    public int Lines=0;
    public ToggleGroup d;
    @FXML
    private TextField E;

    @FXML
    private RadioButton female;

    @FXML
    private ToggleGroup genders;

    @FXML
    private ToggleGroup genders1;

    @FXML
    private ToggleGroup genders2;

    @FXML
    private Button login;

    @FXML
    private Button login1;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton other;

    @FXML
    private PasswordField P;

    @FXML
    private TextField U;
    @FXML
    private Label lb1;

    @FXML
    private Label lb2;

    @FXML
    private Label lb3;
    @FXML
    private Label lb4;
    @FXML
    private Button admin;


    @FXML
    void llogin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void ssignUp(ActionEvent event) throws IOException{
        mistake=0;
        if ( Folder() && Se() && CheckData() && logic()  && createFolder() && readFile() && addData() && CountLines()) {
            Parent root = FXMLLoader.load(getClass().getResource("News.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
    @Override
    public void initialize(URL url , ResourceBundle resourceBundle){
       lb1.setVisible(false);
       lb2.setVisible(false);
       lb3.setVisible(false);
       lb4.setVisible(false);
    }
     Boolean Folder(){
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
     private  Boolean createFolder(){
             try {
                 File x1 = new File("Data/"+U.getText()+".txt");
                 if(U.getText().equals("user")){
                    throw  new FileNotFoundException();
                 }

                 if (!x1.exists() && x1.createNewFile()) {
                     mistake=0;
                     System.out.println(x1.getName());
                 }else{
                    throw new FileNotFoundException();
                 }
             }catch(FileNotFoundException ex){
                 Alert a = new Alert(Alert.AlertType.ERROR,"File exists");
                 a.showAndWait();
                 mistake=-1;
             }catch (IOException ex){
                 ex.printStackTrace();
                 mistake=-1;
             }
           return mistake==0;
         }

     Boolean readFile(){
           try{
             File s = new File("Data/"+U.getText()+".txt");
               if(s.exists()){
                   mistake=0;
                try(DataOutputStream o = new DataOutputStream(new FileOutputStream("Data/"+U.getText()+".txt"));
                    DataInputStream i =new DataInputStream(new FileInputStream("Data/"+U.getText()+".txt"));) {
                    o.writeUTF(U.getText());
                     o.writeUTF(P.getText());
                     o.writeUTF(E.getText());
                      o.close();
                      ////////////
                      customers+="user: "+i.readUTF()+""+"\n";
                      customers+="password: "+i.readUTF()+""+"\n";
                      customers+="email: "+i.readUTF()+""+"\n";
                      i.close();
                      System.out.println(customers);
                      Alert a = new Alert(Alert.AlertType.INFORMATION,"Added successfully!");
                      a.showAndWait();
                }
               }else {
                   mistake=-1;
                   throw new FileNotFoundException();
               }
           }catch (FileNotFoundException ex){
               Alert a = new Alert(Alert.AlertType.ERROR,"File exist");
               a.showAndWait();
               mistake=-1;
           }catch (IOException ex){
               Alert a = new Alert(Alert.AlertType.ERROR,"Error");
               a.showAndWait();
               mistake=-1;
           }
           return mistake ==0;
    }
    Boolean addData(){
        try( DataInputStream t = new DataInputStream(new FileInputStream("Data/DataBase.txt"))){
            mistake=0;
            while (true) {
                info += t.readUTF();
            }
        }catch (EOFException ex){
            System.out.print(" ");
        }catch (IOException ex){
            ex.printStackTrace();
            mistake=-1;
        }
        try(RandomAccessFile r = new RandomAccessFile("Data/DataBase.txt","rw");){
            r.writeUTF(info);
            r.writeUTF(customers);
            r.close();
            mistake=0;
        }catch (EOFException ex){
            System.out.print(" ");
        }
        catch (IOException ex){
            mistake=-1;
            ex.printStackTrace();
    } return mistake==0;
    }
    Boolean CheckData(){

       try {
           if (U.getText().length() > 9) {
               Alert a = new Alert(Alert.AlertType.ERROR, "Wrong user");
               a.showAndWait();
               mistake=-1;
           }
            else if (P.getText().length() > 9) {
               Alert a = new Alert(Alert.AlertType.ERROR, "Wrong password");
               a.showAndWait();
               mistake=-1;
           }
            else if (E.getText().length() > 9) {
               Alert a = new Alert(Alert.AlertType.ERROR, "Wrong email");
               a.showAndWait();
               mistake=-1;
           }
           if (U.getText().equals(P.getText())) {
               mistake=-1;
                    throw new FileNotFoundException();
           }

       }catch(FileNotFoundException ex){
        Alert al = new Alert(Alert.AlertType.ERROR,"Password Matched");
        al.showAndWait();
        mistake=-1;
       }catch (IOException ex){
         Alert l = new Alert(Alert.AlertType.ERROR,"Error");
         l.showAndWait();
         mistake=1;
       }return mistake == 0;

    }
    Boolean Se() {
        if (P.getText().isEmpty()) {
            lb2.setVisible(true);
            mistake=1;
        } else
            lb2.setVisible(false);

        if (U.getText().isEmpty()) {
                lb1.setVisible(true);
                mistake = 1;
        } else
                lb1.setVisible(false);
            if (E.getText().isEmpty()) {
                lb3.setVisible(true);
                mistake = 1;
            } else
                lb3.setVisible(false);


            if (d.getSelectedToggle() == null) {
                lb4.setVisible(true);
                mistake = -1;
            } else {
                lb4.setVisible(false);
            }return mistake == 0;
        }
     Boolean CountLines(){
        File u = new File("Data/DataBase.txt");
        try(LineNumberReader s = new LineNumberReader(new FileReader(u))){
            while(s.readLine()!=null);
            Lines=s.getLineNumber();
            mistake=0;
        }catch (FileNotFoundException ex){
         ex.printStackTrace();
         mistake=-1;
        }
        catch (IOException ex){
      ex.printStackTrace();
      mistake=-1;
        }
        System.out.println(Lines);
        return mistake == 0;
    }
     public  Boolean logic(){
        try{
         DataInputStream dis = new DataInputStream(new FileInputStream("Data/DataBase.txt"));
         String line;
         String f = "password: ";
         String x = f+U.getText();
         while ((line = dis.readLine()) != null) {
             if (line.trim().equals(x)) {
                 System.out.println("exist");
                 Alert x1 = new Alert(Alert.AlertType.ERROR,"Password matched");
                 x1.showAndWait();
                 mistake = 1;
                 break;
             }
         }
         dis.close();
        }catch (EOFException ex){
            System.out.print("");
        } catch (FileNotFoundException ex){
            mistake=-1;
         ex.printStackTrace();
        }catch (IOException ex){
            mistake=-1;
           ex.printStackTrace();
        }
          return mistake==0;
    }

}
