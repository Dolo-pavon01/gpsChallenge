package edu.fiuba.algo3;


import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import java.io.FileInputStream;

public class App extends Application{

    public  Random randoNumber = new Random(); ;

    public double x = 1000;
    public double y = 680;
    public double startMapX = 50 ;
    public double startMapY = 50 ;
    public double widthMap = 900;
    public double heightMap = 600 ;

    public  List elements = new ArrayList();
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Rectangle Example");
        Group group = new Group(); //creating Group
        Rectangle rect= this.rectangule(this.startMapX,this.startMapY,this.widthMap,this.heightMap);
        rect.setFill(Color.GREY);

        this.elements.add(rect);

        int random = (this.randoNumber.nextInt(4) + 1) *2;
        //randoms del 2 al 10 solo pares.
        double m = this.heightMap /random;
        double t = m / 3 ;
        double p = t/2;
        FileInputStream input=new FileInputStream("docs/ED16.png");



        for (double i  = this.startMapX; i < (this.widthMap + this.startMapX); i+=m){
            this.calle(i,this.startMapY,m,t,p,new FileInputStream("docs/ED16.png"));
            for (double y = this.startMapY; y < (this.heightMap ); y+=m){
                this.calle(i,y,m,t,p,new FileInputStream("docs/ED16.png"));
            }
        }





        group.getChildren().addAll(this.elements);

        Scene scene = new Scene(group,this.x,this.y);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Rectangle rectangule(double x, double y, double w, double h ){
        Rectangle rect = new Rectangle();
        rect.setX(x);
        rect.setY(y);
        rect.setWidth(w);
        rect.setHeight(h);

        return  rect;

    }
    public void calle(double startX,double startY, double m, double t, double p, FileInputStream input)throws Exception{
        Integer counter =0 ;
        Rectangle calle1= this.rectangule(startX,startY,m,p);
        calle1.setFill(Color.GREY);
        Rectangle calle2 = this.rectangule(startX,startY +p, p,m-(p));
        calle2.setFill(Color.GREY);
        Rectangle Manzana1= this.rectangule(startX + p, startY+p ,t,t);
        Manzana1.setFill(Color.AZURE);

        Rectangle calle3= this.rectangule(startX+p+t,startY+p,p,t);
        calle3.setFill(Color.GREY);
        Rectangle Manzana2= this.rectangule(startX+p+t+p, startY+p,t,t);
        Manzana2.setFill(Color.AZURE);

        Rectangle calle4= this.rectangule(startX+p+t+p+t, startY+p,p,m-(2*p));
        calle4.setFill(Color.RED);
        Rectangle calle5= this.rectangule(startX+p,startY+p+t,m-(p),p);
        calle5.setFill(Color.GREY);
        Rectangle Manzana3 = this.rectangule(startX+p,startY+p+t+p,t,t);
        Manzana3.setFill(Color.AZURE);

        Rectangle calle6= this.rectangule(startX+p+t,startY+p+t+p,p,t);
        calle6.setFill(Color.GREY);
        Rectangle Manzana4= this.rectangule(startX+p+t+p,startY+p+t+p,t,t);
        Manzana4.setFill(Color.AZURE);

        Rectangle calle7= this.rectangule(startX,startY+p+t+p+t,m,p);
        calle7.setFill(Color.GREY);

        this.elements.add(calle1);
        this.elements.add(calle2);
        this.elements.add(calle3);
        //this.elements.add(calle4);
        this.elements.add(calle5);
        this.elements.add(calle6);
        //this.elements.add(calle7);
        this.elements.add(Manzana1);
        this.elements.add(Manzana2);
        this.elements.add(Manzana3);
        this.elements.add(Manzana4);

        this.imagen(input,startX + p, startY+p ,t);
        this.imagen(input,startX+p+t+p, startY+p,t);
        this.imagen(input,startX+p,startY+p+t+p,t);
        this.imagen(input,startX+p+t+p,startY+p+t+p,t);

    }

    public  void imagen(FileInputStream input2, double startX,double startY,double t) throws Exception{
        int indexPhoto = this.randoNumber.nextInt(17)+2;
        FileInputStream input =new FileInputStream("docs/ED"+ indexPhoto +".png");
        Image image1 = new Image(input);
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(startX);
        imageView1.setY(startY);
        imageView1.setFitWidth(t);
        imageView1.setFitHeight(t);
        this.elements.add(imageView1);
        
    }

    public static void main (String[] args)
    {
        launch(args);
    }
}
