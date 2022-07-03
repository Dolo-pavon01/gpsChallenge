package edu.fiuba.algo3.visuales;

import edu.fiuba.algo3.MapaBase;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.util.Random;

public class VistaMapa extends Group {

    public double x = 1000;
    public double y = 680;
    public double startMapX = 50;
    public double startMapY = 50;
    public double widthMap = 900;
    public double heightMap = 600;
    public double callesEnY;
    public double callesEnX;
    public double largoMovimiento;

    private MapaBase base = new MapaBase();

    public VistaMapa() throws Exception {

        Random randoNumber = new Random();
        Group calles = this.base.crearMapaBase(randoNumber.nextInt(4)  + 2);
        this.callesEnY = this.base.getMaxCallesY();
        this.largoMovimiento = heightMap / callesEnY ;
        this.callesEnX = this.base.getMaxCallesX();
        System.out.print("calles en X:" + this.callesEnX + "  calles en Y:" + this.callesEnY + "\n");
        this.getChildren().addAll(calles);
    }

    public Group crearMapa(Mapa mapa) throws Exception {
        for (int i = 1; i < this.callesEnX; i++)
        {
            for (int j = 1; j < this.callesEnY; j++)
            {
                Obstaculo obstaculo = mapa.obstaculoEnPosicion(Posicion.getPosicion(i, j));
                if (obstaculo.nombreObstaculo() != null)
                {
                    this.base.obtaculoEn(i, j, new ImageView(new Image(new FileInputStream("docs/" + obstaculo.nombreObstaculo()+ ".png") )));
                }
            }
        }

        this.getChildren().addAll(this.base.elements);
        return this;

    }
}
