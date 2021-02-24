package com.bfly;


import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main extends Application {
    Label text1;
    Label text2;
    Boolean Sgo;
    Boolean Spause;
    Boolean Sback;
    int i;
    public static void main(String[] args) {
        // write your code here
        Application.launch(args);
    }

    public void go(){
        System.out.println("Forward!");
        if(i>10)i++;
        System.out.println(i);
        while(Sgo)i++;
    }

    public void pause(){
        System.out.println("Pause!");
        System.out.println(i);
    }

    public void back(){
        System.out.println("Rewind!");
        if(i<0)i--;
        System.out.println(i);
        while(Sback)i--;
    }


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

        DirectoryChooser imgSele = new DirectoryChooser();
        imgSele.setInitialDirectory(new File("C:\\Users\\Bfly\\Pictures"));
        Button importBtn = new Button("Import Images");
        /*
        importBtn.setOnAction(e -> {
            File FileSele = imgSele.showDialog(stage);
            Image newImg = new Image(FileSele.getName());
            //images.add(newImg);
        });
        */




        ImageView current = new ImageView();
        //layout2.getChildren().add(current);
        current.setImage(images.get(i));



        //UI

        ToggleButton tBtn1 = new ToggleButton("rewind");
        ToggleButton tBtn2 = new ToggleButton("pause");
        ToggleButton tBtn3 = new ToggleButton("forward");

        ToggleGroup toggleGroup = new ToggleGroup();

        tBtn1.setToggleGroup(toggleGroup);
        //tBtn2.setToggleGroup(toggleGroup);
        tBtn3.setToggleGroup(toggleGroup);
        tBtn1.setOnAction(actionEvent -> {
            back();
            current.setImage(images.get(i));
        });
        tBtn2.setOnAction(actionEvent -> {
            pause();
            current.setImage(images.get(i));
        });
        tBtn3.setOnAction(actionEvent -> {
            go();
            current.setImage(images.get(i));
        });

        //functions
        Sgo = tBtn3.isSelected();
        Spause = tBtn2.isSelected();
        Sback = tBtn1.isSelected();


        //new UI
        SplitMenuButton selectr = new SplitMenuButton();
        selectr.setText("Images");

        MenuItem c1 = new MenuItem("Choice 1");
        MenuItem c2 = new MenuItem("Choice 2");
        MenuItem c3 = new MenuItem("Choice 3");

        selectr.getItems().addAll(c1, c2, c3);

        //Layout
        HBox layout1 = new HBox(tBtn1, tBtn3, importBtn);
        //HBox layout1 = new HBox();
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