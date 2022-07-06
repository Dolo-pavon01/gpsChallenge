package edu.fiuba.algo3.Controlador;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
public class ControladorOpciones  implements EventHandler<ActionEvent> {

    /*
    Controla las opciones de la vista principal,
    dispara acciones a Gameplay de acuerdo a las opciones
    elegidas por el usuario
     */

    private String nickName;
    private String tipoVehiculo;

    public ControladorOpciones(String nickName,String tipoVehiculo ){
        this.nickName = nickName;
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public void handle(ActionEvent event) {

        //Gameplay.getInstance().nuevoUsuario(this.nickname, this.tipoVehiculo);

    }


}
