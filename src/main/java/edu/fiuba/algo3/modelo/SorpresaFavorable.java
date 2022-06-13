package edu.fiuba.algo3.modelo;

public class SorpresaFavorable implements Sorpresa {
  private static final double VALOR_SORPRESA = 0.8;

  @Override
  public void activar(Vehiculo vehiculo) {
    vehiculo.recibirSorpresa(VALOR_SORPRESA);
  }
}
