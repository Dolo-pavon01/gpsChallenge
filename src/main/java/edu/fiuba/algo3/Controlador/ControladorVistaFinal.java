package edu.fiuba.algo3.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ControladorVistaFinal implements EventHandler<ActionEvent> {

    /*
    Controla las opciones de la vista final
    obtiene de Gameplay la informacion necesaria para mostrar lo que
    la vista requiere:
            -Ranking
            -Nombre de Usuario Actual, sus movimientos generados y
            su posicion en el ranking.
     */
    private ArrayList<String> informacion;
    public ControladorVistaFinal(ArrayList<String> informacion){
        this.informacion = informacion;
    }
    @Override
    public void handle(ActionEvent event) {

        /*
        Le envia el arrayList a Gamplay quien lo llena con informacion de los rankings
        tales como :
            [
              "Jugador:  Matias    Movimientos: 20 Puesto Nro: 3",
              "Jugador:  Marcos    Movimientos: 20 Puesto Nro: 3",
                                ....                             ,
              "Jugador:  Matias-02 Movimientos: 20 Puesto Nro: 3"

             ]

         */
        //Gameplay.getInstance().infoRankings(this.information);
    }

}