package edu.fiuba.algo3;


import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class prueba extends Application{

    public int x = 1000;
    public int y = 600;
    public int startMap = 50 ;
    public int widthMap = 900;
    public int heightMap = 500 ;

    public  List elements = new ArrayList();
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Rectangle Example");
        Group group = new Group(); //creating Group
        Rectangle rect= this.rectangule(this.startMap,this.startMap,this.widthMap,this.heightMap);
        rect.setFill(Color.WHITE);

        this.elements.add(rect);

        //60 x 50
        Rectangle  nuevo =    this.rectangule(50,50,20,20);
        Rectangle p =         this.rectangule(50,80,20,20);
        Rectangle otro =      this.rectangule(80,50,20,20);
        Rectangle pr =        this.rectangule(80,80,20,20);
        Rectangle otracalle = this.rectangule(70,50,10,50);
        Rectangle  calle =    this.rectangule(50,70,50,10);
        Rectangle division = this.rectangule(100,50,10,50);
        division.setFill(Color.RED);

        calle.setFill(Color.RED);
        otracalle.setFill(Color.RED);


        for (int i  = 50; i < 900; i+=60){
            this.matriz(i,50,20,20);
            for (int y = 50; y < 560; y+=60){
                this.matriz(i,y,20,20);
            }
        }


        //this.matriz(50,50,20,20);
        //this.matriz(110,50,20,20);
        //this.matriz(170,50,20,20);

        this.matriz(50,110,20,20);

        this.matriz(110,110,20,20);

        this.matriz(170,110,20,20);
        group.getChildren().addAll(this.elements);

        Scene scene = new Scene(group,this.x,this.y, Color.GREY);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Rectangle rectangule(int x, int y, int w, int h ){
        Rectangle rect = new Rectangle();
        rect.setX(x);
        rect.setY(y);
        rect.setWidth(w);
        rect.setHeight(h);

        return  rect;

    }

    public void matriz(int x, int y, int w, int h){
        //100 50 20
        Rectangle  nuevo =    this.rectangule(x,y,w,h);
        Rectangle p =         this.rectangule(x,y+30,w,h);
        Rectangle otro =      this.rectangule(x+30,y,w,h);
        Rectangle pr =        this.rectangule(x+30,y+30,w,h);

        Rectangle otracalle = this.rectangule(x+20,y,w/2,50);
        Rectangle  calle =    this.rectangule(x,y+20,50,w/2);
        Rectangle division = this.rectangule(x+50,y,w/2,50);
        Rectangle  divisionabajo =    this.rectangule(x,y+50,60,w/2);
        calle.setFill(Color.RED);
        division.setFill(Color.RED);
        divisionabajo.setFill(Color.RED);
        otracalle.setFill(Color.RED);

        this.elements.add(nuevo);
        this.elements.add(p);
        this.elements.add(otro);
        this.elements.add(pr);
        this.elements.add(otracalle);
        this.elements.add(calle);
        this.elements.add(division);
        this.elements.add(divisionabajo);

    }


    public static void main (String[] args)
    {
        launch(args);
    }
}

