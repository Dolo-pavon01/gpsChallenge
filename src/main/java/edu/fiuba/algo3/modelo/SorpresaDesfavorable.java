package edu.fiuba.algo3.modelo;

public class SorpresaDesfavorable implements Sorpresa {

  @Override
  public double activar(Vehiculo vehiculo) {
    return 1.25;
  }
}