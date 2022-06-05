package edu.fiuba.algo3.modelo;

public class Pozo extends Obstaculo {
  public Pozo(int posicion) {
    this.posicion = posicion;
    this.nombreObstaculo = "pozo";
  }

  @Override
  public int penalizar(int posicion) {
    if (this.posicion == posicion) {
      return 3;
    }
    return 0;
  }
}
