package edu.fiuba.algo3.Modelo.Vehiculo;

public class Izquierda implements Sentido {
  private final int VALOR_X = -1;
  private final int VALOR_Y = 0;

  @Override
  public Posicion ejecutar(Posicion posicion) {
    return posicion.mover(VALOR_X, VALOR_Y);
  }
}
