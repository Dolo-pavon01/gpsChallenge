package edu.fiuba.algo3.visuales;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Etiqueta {

    public Label crearEtiqueta(String texto,int x,int y)
    {
        Label etiqueta = new Label(texto);
        etiqueta.setLayoutX(x);
        etiqueta.setLayoutY(y);
        return aplicarDefault(etiqueta);

    }

    public Label aplicarDefault(Label etiqueta)
    {
        etiqueta.setTextFill(Color.BLACK);
        etiqueta.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        return etiqueta;
    }
}
