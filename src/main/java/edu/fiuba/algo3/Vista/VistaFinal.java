package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorVistaFinal;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class VistaFinal extends Application {
    /*
       Encargada de mostrar la vista final con:
            -Ranking
            -Nombre de Usuario Actual, sus movimientos generados y
            su posicion en el ranking
       Utiliza el controlador de vista final.
     */

    public ArrayList<String> informacion = new ArrayList<String>();
    public void start(Stage primaryStage) throws Exception {



        /*
        Cuando llega a la meta se puede poner una opcion que diga
        "Click Aqui para ver los datos del juego"
        ButtonShowStatus.setOnAction(new ControladorVistaFinal(this.informacion));
         */
    }
}
