package edu.fiuba.algo3.modelo;

public class Piquete extends Obstaculo {
  public Piquete(int posicion) {
    this.posicion = posicion;
    this.nombreObstaculo = "piquete";
  }

  @Override
  public int penalizar(int posicion) {
    if (this.posicion == posicion) {
      return 2;
    }
    return 0;
  }
}
