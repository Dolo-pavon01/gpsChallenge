package edu.fiuba.algo3.Modelo.Sorpresas;

import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;

public class SorpresaCambioVehiculo implements Sorpresa {

  @Override
  public void activar(Vehiculo vehiculo) {
    vehiculo.cambiarTipo();
  }

  @Override
  public String nombreSorpresa()
  {
    return "sorpresa";
  }
}
