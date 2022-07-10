package edu.fiuba.algo3.Modelo.Sorpresas;

import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;

public class SorpresaDesfavorable implements Sorpresa {
  private static final double VALOR_SORPRESA = 1.25;

  @Override
  public void activar(Vehiculo vehiculo) {
    vehiculo.recibirSorpresa(VALOR_SORPRESA);
  }
@Override
  public String nombreSorpresa()
  {
    return "sorpresa";
  }
}
