package edu.fiuba.algo3.modelo;

public class SorpresaFavorable implements Sorpresa {
  @Override
  public int activar(Vehiculo vehiculo,int movimientos) {
    return (int)(movimientos * 0.8);
  }
}
