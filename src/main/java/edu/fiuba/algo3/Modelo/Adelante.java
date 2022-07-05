package edu.fiuba.algo3.Modelo;

public class Adelante implements Sentido {
  private final int VALOR_X = 0;
  private final int VALOR_Y = 1;

  @Override
  public Posicion ejecutar(Posicion posicion) {
    return posicion.mover(VALOR_X, VALOR_Y);
  }
}
