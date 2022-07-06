package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorVistaFinal;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaFinal  {
    /*
       Encargada de mostrar la vista final con:
            -Ranking
            -Nombre de Usuario Actual, sus movimientos generados y
            su posicion en el ranking
       Utiliza el controlador de vista final.
     */

    public ArrayList<String> informacion = new ArrayList<String>();
    private Stage stage;


    public VistaFinal(Stage stage){

        this.stage = stage;

    }
    public void mostrarVistaFinal(){

        /*
        Cuando llega a la meta se puede poner una opcion que diga
        "Click Aqui para ver los datos del juego"
        ButtonShowStatus.setOnAction(new ControladorVistaFinal(this.informacion));

        codigo para mostrar informacion

         */
    }
}
