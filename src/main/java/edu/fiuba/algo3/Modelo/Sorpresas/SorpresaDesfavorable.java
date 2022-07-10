package edu.fiuba.algo3.Modelo.Sorpresas;

import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;

public class SorpresaDesfavorable implements Sorpresa {
  private static final double VALOR_SORPRESA = 1.25;

  private final String NOMBRE = "sorpresa";
  private final String SEPARADOR = ";";

  @Override
  public String obtenerNombreEnPosicion(Posicion posicion) {
    return posicion.posicionAString() + SEPARADOR + NOMBRE;
  }

  @Override
  public void activar(Vehiculo vehiculo) {
    vehiculo.recibirSorpresa(VALOR_SORPRESA);
  }

  @Override
  public String nombreSorpresa() {
    return "sorpresa";
  }
}
