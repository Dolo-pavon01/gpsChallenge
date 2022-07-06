package edu.fiuba.algo3.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorMovimientos implements EventHandler<ActionEvent> {

    /*

    Controla las opciones de la vista del Mapa,
    dispara acciones a Gameplay de acuerdo a los
    movimientos elegidos por el usuario

     */

    private Character direccion;
    public ControladorMovimientos(Character direccion){
        this.direccion = direccion;
    }

    public  boolean partidaAbierta(){

        //return  Gameplay.getInstance().llegoaMeta()};
        return  true;
    }

    @Override
    public void handle(ActionEvent event) {

        //Gameplay.getInstance().jugar(this.direccion);


    }



}
