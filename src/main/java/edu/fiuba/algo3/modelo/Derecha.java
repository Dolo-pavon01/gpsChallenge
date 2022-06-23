package edu.fiuba.algo3.modelo;

public class Derecha implements Sentido {
  @Override
  public Posicion ejecutar(Posicion posicion) {
    return posicion.moverHaciaDerecha();
  }
}
