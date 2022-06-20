package edu.fiuba.algo3.modelo;

public class Adelante implements Sentido {

  @Override
  public Posicion ejecutar(Posicion posicion) {
    return posicion.moverHaciaArriba();
  }
}
