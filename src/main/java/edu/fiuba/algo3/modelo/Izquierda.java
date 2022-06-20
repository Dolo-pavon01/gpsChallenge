package edu.fiuba.algo3.modelo;

public class Izquierda implements Sentido {
  public Posicion ejecutar(Posicion posicion) {
    return posicion.moverHaciaIzquierda();
  }
}
