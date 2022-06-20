package edu.fiuba.algo3.modelo;

public class Atras implements Sentido {
  public Posicion ejecutar(Posicion posicion) {
    return posicion.moverHaciaAbajo();
  }
}
