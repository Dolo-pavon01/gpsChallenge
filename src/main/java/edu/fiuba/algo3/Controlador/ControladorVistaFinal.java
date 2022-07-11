package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Modelo.Gameplay;
import edu.fiuba.algo3.Modelo.Partida;

import java.util.ArrayList;

public class ControladorVistaFinal {


  public ArrayList<String> getRankings() {

    return Gameplay.getInstance().infoRankings();

  }
}
