package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Auto;
import edu.fiuba.algo3.modelo.TipoVehiculo;
import edu.fiuba.algo3.modelo.Vehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class HandlerBotonVehiculo implements EventHandler<ActionEvent> {
    private Vehiculo vehiculo;
    private ImageView dibujoVehiculo;

    private TipoVehiculo tipo;

    private String clave;

    public HandlerBotonVehiculo(Vehiculo vehiculo, ImageView dibujoVehiculo,TipoVehiculo tipo,String clave)
    {
        this.vehiculo = vehiculo;
        this.dibujoVehiculo = dibujoVehiculo;
        this.tipo = tipo;
        this.clave = clave;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.vehiculo.setTipo(tipo);
        try {
            dibujoVehiculo.setImage(new Image(new FileInputStream("docs/Vehiculo_" + this.clave  +".png")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}