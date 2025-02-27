package com.example.a;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server extends Application {
    @Override
    public void start(Stage primaryStage){
        TextArea ta = new TextArea();
        Scene scene = new Scene(new ScrollPane(ta),450,200);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(()->{
           try{
               ServerSocket serverSocket = new ServerSocket(2323);
               Platform.runLater(()->
                       ta.appendText("Server started at "+new Date()+'\n'));
               Socket socket =serverSocket.accept();
               DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
               DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());
               while(true){
                   double radius = inputFromClient.readDouble();
                   double area = radius*radius*Math.PI;
                   outputToServer.writeDouble(area);
                   Platform.runLater(()->{
                       ta.appendText("Radius received from client: "
                       +radius+'n');
                       ta.appendText("Area is:"+area+'n');
                   });
               }
           }catch(IOException ex){
               ex.printStackTrace();
           }
        }).start();

    }

}
