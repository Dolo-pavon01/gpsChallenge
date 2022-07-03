package edu.fiuba.algo3.visuales;

import edu.fiuba.algo3.MapaBase;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

public class VistaMapa extends Group {

    public double x = 1000;
    public double y = 680;
    public double startMapX = 50 ;
    public double startMapY = 50 ;
    public double widthMap = 900;
    public double heightMap = 600 ;
    public double callesEnY;
    public double callesEnX;
    public double largoMovimiento;
    public VistaMapa() throws Exception {
        Random randoNumber = new Random();

        MapaBase base = new MapaBase();


        this.callesEnY = randoNumber.nextInt(2) * 6 + 12;
        Group calles = base.crearMapaBase((int) (this.callesEnY/3));
        this.largoMovimiento = heightMap/callesEnY * 2;
        this.callesEnX = this.callesEnY * 2/3;
        System.out.print("calles en X:" + this.callesEnX + "  calles en Y:" + this.callesEnY + "\n");
        this.getChildren().addAll(calles);
    }

    private double getXEnPixeles(int x)
    {
        return(x* widthMap/callesEnY);
    }
    private double getYEnPixeles(int y)
    {
        return (y * heightMap/callesEnX);
    }


    public Group crearMapa(Mapa mapa) throws FileNotFoundException
    {
        for(int i = 0; i < this.callesEnY;i ++)
        {
            for(int j = 0; j < this.callesEnX;j++)
            {
                double x = getXEnPixeles(i);
                double y = getYEnPixeles(j);
                IVisitor obstaculo = mapa.obstaculoEnPosicion(Posicion.getPosicion(i,j));
                if(obstaculo.dibujar() != null)
                {
                    ImageView dibujoObstaculo = this.dibujar(obstaculo,x,y);
                    //ImageView dibujoSorpresa = dibujar(mapa.sorpresaEnPosicion(Posicion.getPosicion(i,j)),x,y);
                    this.getChildren().addAll(dibujoObstaculo);
                }
            }
        }
        return this;
    }

    private ImageView dibujar(IVisitor obstaculo,double x, double y) throws FileNotFoundException {

            ImageView dibujo = new ImageView(new Image(new FileInputStream(obstaculo.dibujar())));
            dibujo.setPreserveRatio(true);
            dibujo.setFitHeight(50);
            dibujo.setX(x);
            dibujo.setY(y);
            System.out.print( x + " " + y + "\n");
            return dibujo;
    }
    private ImageView dibujar(Sorpresa sorpresa,double x, double y) throws FileNotFoundException {
        ImageView dibujoSorpresa = new ImageView(new Image(new FileInputStream("docs/sorpresa.png")));
        dibujoSorpresa.setPreserveRatio(true);
        dibujoSorpresa.setFitHeight(50);
        dibujoSorpresa.setX(x);
        dibujoSorpresa.setY(y);
        System.out.print( x + " " + y + "\n");
        return dibujoSorpresa;
    }

    }
