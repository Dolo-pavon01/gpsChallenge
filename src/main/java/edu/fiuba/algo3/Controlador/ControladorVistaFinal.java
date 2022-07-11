package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Modelo.Gameplay;
import edu.fiuba.algo3.Modelo.Partida;

import java.util.ArrayList;

public class ControladorVistaFinal {

  /*
  Controla las opciones de la vista final
  obtiene de Gameplay la informacion necesaria para mostrar lo que
  la vista requiere:
          -Ranking
          -Nombre de Usuario Actual, sus movimientos generados y
          su posicion en el ranking.
   */

  public ArrayList<String> getRankings() {

    ArrayList<String> rankings;

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
    return Gameplay.getInstance().infoRankings();
    // rankings.add("Jugador:  Matias    Movimientos: 80  Puesto Nro: 1");
    // rankings.add("Jugador:  Marcos    Movimientos: 20  Puesto Nro: 2");
    // rankings.add("Jugador:  Dolores   Movimientos: 10  Puesto Nro: 3");
    // Partida partida = new Partida();
    // rankings = partida.actualizarPodio("PANDOLFO TE AMO", 20);
    // rankings = (partida.actualizarPodio("Juli",30));

   //  return rankings;
  }
}
