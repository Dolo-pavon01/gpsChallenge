package edu.fiuba.algo3.modelo;

public class Derecha implements Sentido {
  public Posicion ejecutar(Posicion posicion) {
    return posicion.moverHaciaDerecha();
  }
}
