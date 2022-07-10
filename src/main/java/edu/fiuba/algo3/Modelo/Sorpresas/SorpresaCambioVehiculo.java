package edu.fiuba.algo3.Modelo.Sorpresas;

import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;

public class SorpresaCambioVehiculo implements Sorpresa {

  private final String NOMBRE = "sorpresa";
  private final String SEPARADOR = ";";

  @Override
  public String obtenerNombreEnPosicion(Posicion posicion) {
    return posicion.posicionAString() + SEPARADOR + NOMBRE;
  }

  @Override
  public void activar(Vehiculo vehiculo) {
    vehiculo.cambiarTipo();
  }

  @Override
  public String nombreSorpresa() {
    return "sorpresa";
  }
}
