package edu.fiuba.algo3.modelo;

public class Izquierda implements Sentido {
  public Posicion ejecutar(Posicion posicion) {
    return Posicion.getPosicion(posicion.x - 1, posicion.y);
  }
}
