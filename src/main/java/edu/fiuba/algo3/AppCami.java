package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class AppCami extends Application {

    public void start(Stage primaryStage) throws Exception {

        Button mover=new Button("Mover auto");
        mover.setLayoutX(50);
        mover.setLayoutY(300);

        FileInputStream input=new FileInputStream("docs/auto.png");
        Image image = new Image(input);
        ImageView img=new ImageView(image);
        img.setPreserveRatio(true);
        img.setFitHeight(50);
        img.setY(100);

        FileInputStream input2=new FileInputStream("docs/imagenFondo.png");
        Image image1 = new Image(input2);
        ImageView fondo=new ImageView(image1);

        Group group = new Group(); //creating Group

        group.getChildren().addAll(fondo);
        group.getChildren().addAll(img);
        group.getChildren().addAll(mover);


        Translate translate = new Translate();
        translate.setX(20);
        translate.setY(0);
        translate.setZ(0);


        mover.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                img.getTransforms().addAll(translate);
            }
        });

        Scene scene = new Scene(group,500,500, Color.BLACK);
        primaryStage.setTitle("Aplicacion Cami");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public static void main (String[] args)
    {
        launch(args);
    }
}
