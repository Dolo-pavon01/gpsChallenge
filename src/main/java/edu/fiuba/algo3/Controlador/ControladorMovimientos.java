package edu.fiuba.algo3.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ControladorMovimientos {

  private int counter = 0;
  /*
      Controla las opciones de la vista del Mapa,
      dispara acciones a Gameplay de acuerdo a los
      movimientos elegidos por el usuario
  */

  public boolean partidaCerrada() {

    this.counter += 1;
    if (this.counter < 100) {

      return false;
    }
    // return  Gameplay.getInstance().llegoaMeta()};
    return true;
  }

  public String vehiculo() {
    // return Gameplay.getInstance().vehiculoEnJuego();

    return "0;1;Auto";
  }

  public boolean evento(Character direccion) {
    // Gameplay.getInstance().jugar(this.direccion);
    // G
    return true;
  }

  public ArrayList<String> getObstaculos() {

    ArrayList<String> entidades = new ArrayList<String>();
    entidades.add("1;2;controlPolicial");
    entidades.add("6;1;Piquete");
    entidades.add("3;3;pozo");

    return entidades;
  }

  public ArrayList<String> getSorpresas() {

    ArrayList<String> entidades = new ArrayList<String>();
    entidades.add("1;2;sorpresa");
    entidades.add("6;1;sorpresa");
    entidades.add("3;3;sorpresa");

    return entidades;
  }
}
