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

public class MapaBase {

    public Random randoNumber = new Random();
    ;

    public double x = 1000;
    public double y = 680;
    public double startMapX = 50;
    public double startMapY = 50;
    public double widthMap = 900;
    public double heightMap = 600;

    private double m;
    private double callesEnY;

    public List elements = new ArrayList();

    public Group crearMapaBase(int random) throws Exception {
        Group group = new Group();
        Rectangle rect = this.rectangule(this.startMapX, this.startMapY, this.widthMap, this.heightMap);
        rect.setFill(Color.RED);

        this.elements.add(rect);
        double m = this.heightMap / random;
        double t = m / 3; //
        double p = t / 2;
        this.m = m;


        FileInputStream input = new FileInputStream("docs/ED16.png");


        for (double i = this.startMapX; i < (this.widthMap + this.startMapX); i += m) {
            this.calle(i, this.startMapY, m, t, p, new FileInputStream("docs/ED16.png"));
            for (double y = this.startMapY; y < (this.heightMap); y += m) {
                this.calle(i, y, m, t, p, new FileInputStream("docs/ED16.png"));
            }
        }
        group.getChildren().addAll(this.elements);

        return group;
    }
    public double getLargoMovimiento()
    {
        return this.m / 2;
    }


    public Rectangle rectangule(double x, double y, double w, double h) {
        Rectangle rect = new Rectangle();
        rect.setX(x);
        rect.setY(y);
        rect.setWidth(w);
        rect.setHeight(h);

        return rect;

    }

    public void calle(double startX, double startY, double m, double t, double p, FileInputStream input) throws Exception {
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

        this.imagen(input, startX + p, startY + p, t);
        this.imagen(input, startX + p + t + p, startY + p, t);
        this.imagen(input, startX + p, startY + p + t + p, t);
        this.imagen(input, startX + p + t + p, startY + p + t + p, t);

        this.calleImagen(startX, startY, m, p, "docs/calle.png");
        this.calleImagen(startX, startY, p, m, "docs/calle2.png");
        this.calleImagen(startX + p + t, startY + p, p, t + p + t, "docs/calle2.png");
        this.calleImagen(startX, startY + p + t, m, p, "docs/calle.png");


    }

    public void calleImagen(double startX, double startY, double m, double p, String path) throws Exception {
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

    public void imagen(FileInputStream input2, double startX, double startY, double t) throws Exception {
        int indexPhoto = this.randoNumber.nextInt(17) + 2;
        FileInputStream input = new FileInputStream("docs/ED" + indexPhoto + ".png");
        Image image1 = new Image(input);
        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(startX);
        imageView1.setY(startY);
        imageView1.setFitWidth(t);
        imageView1.setFitHeight(t);
        this.elements.add(imageView1);

    }


}

