package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
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

        FileInputStream input=new FileInputStream("C:\\Users\\camil\\Documents\\GitHub\\gpsChallenge\\docs\\auto.png");
        Image image = new Image(input);
        ImageView img=new ImageView(image);
        img.setPreserveRatio(true);
        img.setFitHeight(50);
        img.setY(100);

        Rectangle rect=new Rectangle(); //instantiating Rectangle
        rect.setX(0); //setting the X coordinate of upper left //corner of rectangle
        rect.setY(0); //setting the Y coordinate of upper left //corner of rectangle
        rect.setWidth(100); //setting the width of rectangle
        rect.setHeight(100); // setting the height of rectangle
        rect.setFill(Color.GREY);

        Rectangle rect1=new Rectangle(); //instantiating Rectangle
        rect1.setX(0); //setting the X coordinate of upper left //corner of rectangle
        rect1.setY(150); //setting the Y coordinate of upper left //corner of rectangle
        rect1.setWidth(100); //setting the width of rectangle
        rect1.setHeight(100); // setting the height of rectangle
        rect1.setFill(Color.GREY);

        Rectangle rect2=new Rectangle(); //instantiating Rectangle
        rect2.setX(150); //setting the X coordinate of upper left //corner of rectangle
        rect2.setY(0); //setting the Y coordinate of upper left //corner of rectangle
        rect2.setWidth(100); //setting the width of rectangle
        rect2.setHeight(100); // setting the height of rectangle
        rect2.setFill(Color.GREY);

        Rectangle rect3=new Rectangle(); //instantiating Rectangle
        rect3.setX(150); //setting the X coordinate of upper left //corner of rectangle
        rect3.setY(150); //setting the Y coordinate of upper left //corner of rectangle
        rect3.setWidth(100); //setting the width of rectangle
        rect3.setHeight(100); // setting the height of rectangle
        rect3.setFill(Color.GREY);


        Group group = new Group(); //creating Group


        group.getChildren().addAll(img);
        group.getChildren().addAll(mover);
        group.getChildren().addAll(rect,rect1,rect2,rect3);


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
