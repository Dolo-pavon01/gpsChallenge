package edu.fiuba.algo3.Controlador;

import java.util.ArrayList;
import edu.fiuba.algo3.Modelo.Gameplay;

public class ControladorMovimientos {

  private int counter = 0;
  /*
      Controla las opciones de la vista del Mapa,
      dispara acciones a Gameplay de acuerdo a los
      movimientos elegidos por el usuario
  */

  public boolean partidaCerrada() {

    /*
    this.counter += 1;
    if (this.counter < 1000) {

      return false;
    }

    return true;
     */

    return Gameplay.getInstance().llegoAMeta();
  }

  public String vehiculo() {
    // return "Auto";
    return Gameplay.getInstance().getVehiculo();
  }

  public boolean evento(Character direccion) {

    // return true;
    return Gameplay.getInstance().jugar(direccion);
  }

  public int getDimension() {
    // return 6;
    return Gameplay.getInstance().getAlto();
  }

  public ArrayList<String> getObstaculos() {

    /*
    ArrayList<String> entidades = new ArrayList<String>();
    entidades.add("1;2;controlPolicial");
    entidades.add("6;1;Piquete");
    entidades.add("3;3;pozo");

    return entidades;
    */
    return Gameplay.getInstance().getObstaculos();
  }

  public ArrayList<String> getSorpresas() {
    /*
       ArrayList<String> entidades = new ArrayList<String>();
       entidades.add("1;2;sorpresa");
       entidades.add("6;1;sorpresa");
       entidades.add("3;3;sorpresa");

       return entidades;


    */
    return Gameplay.getInstance().getSorpresas();
  }

  public String meta() {
    // return "0;2;addasd";
    return Gameplay.getInstance().getMeta();
  }
}
