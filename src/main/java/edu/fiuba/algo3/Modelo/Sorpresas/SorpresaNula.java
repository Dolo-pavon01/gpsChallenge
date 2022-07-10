package edu.fiuba.algo3.Modelo.Sorpresas;

import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;

public class SorpresaNula implements Sorpresa {

  private final String NOMBRE = "sorpresa";
  private final String SEPARADOR = ";";

  @Override
  public String obtenerNombreEnPosicion(Posicion posicion) {
    return posicion.posicionAString() + SEPARADOR + NOMBRE;
  }

  @Override
  public String nombreSorpresa() {
    return "sopresaNula";
  }

  @Override
  public void activar(Vehiculo vehiculo) {
    return;
  }
}
