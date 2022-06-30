package edu.fiuba.algo3.visuales;

import edu.fiuba.algo3.MapaBase;
import edu.fiuba.algo3.modelo.Mapa;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.List;

public class VistaMapa extends Group {

    public double tamanio;
    public VistaMapa() throws Exception {

        MapaBase base = new MapaBase();
        List calles = base.crearMapaBase();

        this.getChildren().addAll(calles);

    }


}
