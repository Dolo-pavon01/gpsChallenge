package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Modelo.TipoVehiculo;
import edu.fiuba.algo3.Modelo.Vehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class HandlerBotonVehiculo implements EventHandler<ActionEvent> {

    private  String vehiculo;

    public void nuevoVehiculo(String vehiculo){
        this.vehiculo = vehiculo;
    }
    @Override
    public void handle(ActionEvent actionEvent) {}

    public String getVehiculoEnJuego(){
        return this.vehiculo;
    }

}