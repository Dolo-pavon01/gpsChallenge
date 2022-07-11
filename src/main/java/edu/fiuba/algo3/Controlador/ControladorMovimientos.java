package edu.fiuba.algo3.Controlador;

import java.util.ArrayList;
import edu.fiuba.algo3.Modelo.Gameplay;

public class ControladorMovimientos {

  private int counter = 0;


  public boolean partidaCerrada() {

    return Gameplay.getInstance().llegoAMeta();
  }

  public String vehiculo() {
    return Gameplay.getInstance().getVehiculo();
  }

  public boolean evento(Character direccion) {
    return Gameplay.getInstance().jugar(direccion);
  }

  public int getDimension() {
    return Gameplay.getInstance().getAlto();
  }

  public ArrayList<String> getObstaculos() {
    return Gameplay.getInstance().getObstaculos();
  }

  public ArrayList<String> getSorpresas() {
    return Gameplay.getInstance().getSorpresas();
  }

  public String meta() {
    return Gameplay.getInstance().getMeta();
  }
}
