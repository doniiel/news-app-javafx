package com.example.a;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Proekt extends Application {
@Override
    public void start(Stage stage)throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
    stage.setScene(new Scene(root,800,600));
    stage.setTitle("News");
    stage.show();

}
}
