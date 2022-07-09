package edu.fiuba.algo3.Vista;
/*
import edu.fiuba.algo3.Controlador.ControladorMovimientos;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class VistaMapa {

    Implementa la vista del mapa con:
        -Obstaculos
        -Vehiculo
        -Meta
        -Manzanas
        -Calles
     utiliza el controlador de interacciones entre el usuario
     y el mapa.

    private Stage stage;
    public Random randoNumber = new Random();
    private double startMapX = 0;
    private double startMapY = 50;
    private double widthMap = 900;
    private double heightMap = 600;

    private String vehiculo;

    private double AnchoAltoMatriz;
    private int callesEnY;
    private double altoCalle;
    private double altoAnchoCuadra;
    private int callesEnX = 0;
    private List elements = new ArrayList();

    public VistaMapa(Stage stage, Integer random) throws Exception {
        this.stage = stage;

        Group group = new Group();
        Rectangle rect = this.rectangule(this.startMapX, this.startMapY, this.widthMap, this.heightMap);
        rect.setFill(Color.RED);

        this.elements.add(rect);
        this.AnchoAltoMatriz = this.heightMap / random;
        this.altoAnchoCuadra = this.AnchoAltoMatriz / 3; //
        this.altoCalle = this.altoAnchoCuadra / 2;
        this.callesEnY = random;


        for (double i = this.startMapX; i < (this.widthMap + this.startMapX); i += AnchoAltoMatriz) {
            this.callesEnX += 1;
            this.dibujarMatriz(i, this.startMapY, this.AnchoAltoMatriz, this.altoAnchoCuadra, this.altoCalle);
            for (double y = this.startMapY; y < (this.heightMap); y += this.AnchoAltoMatriz) {
                this.dibujarMatriz(i, y, AnchoAltoMatriz, this.altoAnchoCuadra, this.altoCalle);
            }
        }

        group.getChildren().addAll(this.elements);


    }

    public void dibujarMatriz(double startX, double startY, double m, double t, double p) throws Exception {
        Integer counter = 0;
        Rectangle calle1 = this.rectangule(startX, startY, m, p);
        calle1.setFill(Color.WHITE);

        Rectangle calle2 = this.rectangule(startX, startY + p, p, m - (p));
        calle2.setFill(Color.WHITE);

        Rectangle Manzana1 = this.rectangule(startX + p, startY + p, t, t);
        Manzana1.setFill(Color.LIGHTBLUE);

        Rectangle calle3 = this.rectangule(startX + p + t, startY + p, p, t);
        calle3.setFill(Color.WHITE);

        Rectangle Manzana2 = this.rectangule(startX + p + t + p, startY + p, t, t);
        Manzana2.setFill(Color.LIGHTBLUE);

        Rectangle calle4 = this.rectangule(startX + p + t + p + t, startY + p, p, m - (2 * p));
        calle4.setFill(Color.WHITE);
        Rectangle calle5 = this.rectangule(startX + p, startY + p + t, m - (p), p);
        calle5.setFill(Color.WHITE);

        Rectangle Manzana3 = this.rectangule(startX + p, startY + p + t + p, t, t);
        Manzana3.setFill(Color.LIGHTBLUE);

        Rectangle calle6 = this.rectangule(startX + p + t, startY + p + t + p, p, t);
        calle6.setFill(Color.WHITE);
        Rectangle Manzana4 = this.rectangule(startX + p + t + p, startY + p + t + p, t, t);
        Manzana4.setFill(Color.LIGHTBLUE);

        Rectangle calle7 = this.rectangule(startX, startY + p + t + p + t, m, p);
        calle7.setFill(Color.WHITE);

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

        int randomImage = new Random().nextInt(13) + 1;

        this.imagen(startX + p, startY + p, t, t, "docs/ED" + randomImage + ".png");
        this.imagen(startX + p + t + p, startY + p, t, t, "docs/ED" + (randomImage + 1) + ".png");
        this.imagen(startX + p, startY + p + t + p, t, t, "docs/ED" + (randomImage + 2) + ".png");
        this.imagen(startX + p + t + p, startY + p + t + p, t, t, "docs/ED" + (randomImage + 3) + ".png");

        this.imagen(startX, startY, m, p, "docs/calle.png");
        this.imagen(startX, startY, p, m, "docs/calle2.png");
        this.imagen(startX + p + t, startY + p, p, t + p + t, "docs/calle2.png");
        this.imagen(startX, startY + p + t, m, p, "docs/calle.png");


    }


    public void imagen(double startX, double startY, double m, double p, String path) throws Exception {
        FileInputStream input = new FileInputStream(path);
        Image image_calle = new Image(input);
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image_calle);
        imageView1.setX(startX);
        imageView1.setY(startY);
        imageView1.setFitWidth(m);
        imageView1.setFitHeight(p);
        this.elements.add(imageView1);
    }


    public Rectangle rectangule(double x, double y, double w, double h) {
        Rectangle rect = new Rectangle();
        rect.setX(x);
        rect.setY(y);
        rect.setWidth(w);
        rect.setHeight(h);

        return rect;

    }


    public void dibujarEntidad(String entidad,int x, int y  ) throws Exception {
        int coordenadaY= y;
        int coordenadaX = x;

        int cantidadCallesY = this.callesEnY * 2 ;
        int cantidadCallesX = this.callesEnX * 2 ;

        double techo = (Math.round((cantidadCallesY - coordenadaY )/2) * this.AnchoAltoMatriz) + this.startMapY;

        double startY =  techo ;
        if(coordenadaY % 2 == 0) {
            startY +=  0;
        } else {
            startY += this.altoCalle + this.altoAnchoCuadra;
        }


        double costado = (Math.round((cantidadCallesX - (cantidadCallesX - coordenadaX ) )/2)*this.AnchoAltoMatriz) ;
        double startX  = costado + this.startMapX;

        if(coordenadaX % 2 == 0 & coordenadaX > 0) {
            startX -=  ((this.altoCalle + this.altoAnchoCuadra) / 2);
        }else if (coordenadaX > 0) {
            startX += ((this.altoCalle + this.altoAnchoCuadra )/ 2);
        }

        this.imagen(startX,startY,this.altoCalle,this.altoCalle, (entidad + ".png"));

    }

    public void dibujarVehiculo(int x, int y){



    }





}
*/