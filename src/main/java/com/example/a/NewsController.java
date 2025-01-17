package com.example.a;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewsController implements Initializable {
    @FXML
    private ImageView o1;

    @FXML
    private ImageView o2;

    @FXML
    private ImageView o3;

    @FXML
    private ImageView o4;
    @FXML
    private TextArea l1;

    @FXML
    private TextArea l2;

    @FXML
    private TextArea l3;

    @FXML
    private TextArea l4;

    @FXML
    private Label j;
    @FXML
    private Button log;
    @FXML
    private MenuBar f;
    @FXML
    void t1(ActionEvent event) {
        f.setVisible(true);
    }
    @Override
    public void initialize(URL url , ResourceBundle bundle){
  f.setVisible(false);
  o1.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\k1.jpg"));
  l1.setText("These Nike NFT 'Cryptokicks' Sneakers Sold For $130K");
  o2.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\k2.jpg"));
  l2.setText("Wagner's waza-ari brings gold on final day in Tbilisi");
  o3.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\k3.jpg"));
  l3.setText("The Scottish National Party’s limitations have been laid bare");
  o4.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\k4.jpg"));
  l4.setText("Disney Lays Off More Than 300 Streaming-Focused Employees in China");

    }

    @FXML
    void t2(ActionEvent event) {
        f.setVisible(false);
        o1.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\s1.jpg"));
        l1.setText("Wayne Rooney has doubts Arsenal can handle ‘pressure’ as he tips Manchester City to win Premier League title race");
        o2.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\s2.jpg"));
        l2.setText("Runner Zane Robertson explains reasons for doping violations, discloses feeling suicidal thoughts after scandal");
        o3.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\s3.jpg"));
        l3.setText("World Athletics bans some transgender women from events");
        o4.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\s4.jpg"));
        l4.setText("‘At times I was really pissed off to be part of that era’: Novak Djokovic speaks to CNN about competing with Nadal and Federer");
    }

    @FXML
    void t3(ActionEvent event) {
        f.setVisible(false);
        o1.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\b1.jpg"));
        l1.setText("Warning UK car industry under threat without help");
        o2.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\b2.jpg"));
        l2.setText("Google: India tribunal upholds $160m fine on company");
        o3.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\b3.jpg"));
        l3.setText("US firms 'more negative' about doing business in China" + "Published" + "7 days ago");
        o4.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\b4.jpg"));
        l4.setText("The tech helping driverless cars see round corners" + "Published" + "2 days ago");
    }

    @FXML
    void t4(ActionEvent event) {
        f.setVisible(false);
      o1.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\e1.jpg"));
      l1.setText("Russian hackers are preparing for a new campaign in Ukraine");
      o2.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\e2.jpg"));
      l2.setText("America’s other great migration" +"White migrants from America’s South turned its northern politics rightwards");
      o3.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\e3.jpg"));
      l3.setText("Which will grow faster: India or Indonesia?" + "Both countries are pioneering new ways to get rich in a troubled world\n");
      o4.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\e4.jpg"));
      l4.setText("Biden administration condemns Russia’s detention of Wall Street Journal reporter");
    }
    @FXML
    void out(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void bio(ActionEvent event) {
        o1.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\a1.jpg"));
        l1.setText("Bacterial ‘Nanosyringe’ Could Deliver Gene Therapy to Human Cells" + "This novel injection system could help advance gene therap");
        o2.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\a2.jpg"));
        l2.setText("Gene Drives Could Fight Malaria and Other Global Killers but Might Have Unintended Consequences");
        o3.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\a3.jpg"));
        l3.setText("Artificial Neuron Snaps a Venus Flytrap Shut");
        o4.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\a4.jpg"));
        l4.setText("A Portable MRI Makes Imaging More Democratic");
    }
    @FXML
    void art(ActionEvent event) {
        o1.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\a11.jpg"));
        l1.setText("Elon Musk among experts urging a halt to AI training");
        o2.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\a22.jpg"));
        l2.setText("Bill Gates: AI is most important tech advance in decades");
        o3.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\a33.jpg"));
        l3.setText("ChatGPT bug leaked users' conversation histories");
        o4.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\a44.jpg"));
        l4.setText("Bard: Google's rival to ChatGPT launches for over-18s");
    }
    @FXML
    void aud(ActionEvent event) {
         o1.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\u1.jpg"));
         l1.setText("Samsung, New York Mets Team Up Again for New Scoreboard on Opening Day 2023");
         o2.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\u2.jpg"));
         l2.setText("Home Run: A Look Back at 5 Big League Pro AV Upgrades for 2022");
         o3.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\u3.jpg"));
         l3.setText("The Minnesota Twins Go Big on Massive LED Overhaul");
         l4.setText("With Fulcrum Acoustic, Stetson's College Baseball Stadium Scores Big");
         o4.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\u4.jpg"));
    }
    @FXML
    void In(ActionEvent event) {
      o1.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\i1.jpg"));
      l1.setText("‘Extraordinary properties’: Scientists develop new ultra-fast electronic devices for 6G and beyond");
      o2.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\i2.jpg"));
      l2.setText("Will Bing bounce back? Microsoft revamps search engine with ChatGPT technology");
      o3.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\i3.jpg"));
      l3.setText("Your windows may soon produce wireless Internet connections powered by sunlight");
      o4.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\i4.jpg"));
      l4.setText("Tumblr is bringing back nudity, reversing the infamous 2018 porn ban");
    }
    @FXML
    void co(ActionEvent event) {
           o1.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\c1.jpg"));
           l1.setText("A New Computer Proof ‘Blows Up’ Centuries-Old Fluid Equations");
           o2.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\c2.jpg"));
           l2.setText("Review: Acer Nitro 5 Gaming Laptop");
           o3.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\c3.jpg"));
           l3.setText("How to Reboot Your Gadgets and How Often to Do It");
           o4.setImage(new Image("C:\\Users\\User\\IdeaProjects\\A\\Photo\\c4.jpg"));
           l4.setText("Review: Lenovo ThinkPad X1 Carbon (Linux Edition)");

    }
    @FXML
    void con(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Email: 220103023@stu.sdu.edu.kz");
        alert.showAndWait();
    }


}

