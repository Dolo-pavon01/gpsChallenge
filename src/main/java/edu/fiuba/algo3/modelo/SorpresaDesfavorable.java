package edu.fiuba.algo3.modelo;

public class SorpresaDesfavorable implements Sorpresa {

  @Override
  public int activar(Vehiculo vehiculo, int movimientos ) {
    return (int)(movimientos * 1.25);
  }
}
