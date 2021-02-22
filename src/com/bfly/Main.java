package com.bfly;


import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main extends Application {
    Label text1;
    Label text2;
    int i;
    public static void main(String[] args) {
        // write your code here
        Application.launch(args);
    }

    public void go(){
        System.out.println("Forward!");
        System.out.println(i);
    }

    public void pause(){
        System.out.println("Pause!");
        System.out.println(i);
    }

    public void back(){
        System.out.println("Rewind!");
        System.out.println(i);
    }

    //public void importImage() {
    //    FileChooser filechooser = new FileChooser();
    //    File seleFile = filechooser.showOpenDialog(stage);
    //
    //}

    static ArrayList<Image> images = new ArrayList<>();

    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Maddie Bfly");

        //importing images
        FileInputStream bflyintro = new FileInputStream("C:\\Users\\Bfly\\Pictures\\backgrounds\\Star vs the Forces of Evil - Intro [1080p]-screenshot.png");
        FileInputStream maddiebfly = new FileInputStream("C:\\Users\\Bfly\\Pictures\\Madeleine Butterfly\\madeleine butterfly.png");
        FileInputStream celenatheshy = new FileInputStream("C:\\Users\\Bfly\\Pictures\\SvtFoE\\Celena the shy.png");
        FileInputStream moonbfly = new FileInputStream("C:\\Users\\Bfly\\Pictures\\SvtFoE\\Moon Butterfly 3.png");
        FileInputStream starbfly = new FileInputStream("C:\\Users\\Bfly\\Pictures\\SvtFoE\\starButterfly2.png");
        Image bfly0 = new Image(bflyintro);
        Image bfly1 = new Image(maddiebfly);
        Image bfly2 = new Image(celenatheshy);
        Image bfly3 = new Image(moonbfly);
        Image bfly4 = new Image(starbfly);
        images.add(bfly0);
        images.add(bfly1);
        images.add(bfly2);
        images.add(bfly3);
        images.add(bfly4);


        //image selection

        //Filechooser


        //UI
        ToggleButton tBtn1 = new ToggleButton("rewind");
        ToggleButton tBtn2 = new ToggleButton("pause");
        ToggleButton tBtn3 = new ToggleButton("forward");
        Button importBtn = new Button("Import Image");

        ToggleGroup toggleGroup = new ToggleGroup();

        tBtn1.setToggleGroup(toggleGroup);
        tBtn2.setToggleGroup(toggleGroup);
        tBtn3.setToggleGroup(toggleGroup);
        tBtn1.setOnAction(actionEvent -> back());
        tBtn2.setOnAction(actionEvent -> pause());
        tBtn3.setOnAction(actionEvent -> go());
        //importBtn.setOnAction( actionEvent -> importImage());

        //functions
            boolean Sgo = tBtn3.isSelected();
            boolean Spause = tBtn2.isSelected();
            boolean Sback = tBtn1.isSelected();
            while(Sgo){
                i++;
            }
            while(Sback) {
                i--;
            }

        //Layout
        HBox layout1 = new HBox(tBtn1, tBtn2, tBtn3);
        ImageView current = new ImageView(images.get(i));
        //layout2.getChildren().add(current);
        HBox layout2 = new HBox(current);

        VBox layoutMain = new VBox(layout1, layout2);
        //StackPane stack = new StackPane(layout2, layout1);

        //Scene settings
        Scene scene1 = new Scene(layoutMain);
        stage.setScene(scene1);
        stage.setFullScreen(true);
        //scene1.setCursor(Cursor.WAIT);

        //show scene
        stage.show();
        System.out.println(i);
    }
}