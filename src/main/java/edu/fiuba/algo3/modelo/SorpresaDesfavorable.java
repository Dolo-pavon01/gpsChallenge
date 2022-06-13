package edu.fiuba.algo3.modelo;

public class SorpresaDesfavorable implements Sorpresa {
  private static final double VALOR_SORPRESA = 1.25;

  @Override
  public void activar(Vehiculo vehiculo) {
    vehiculo.recibirSorpresa(VALOR_SORPRESA);
  }
}
