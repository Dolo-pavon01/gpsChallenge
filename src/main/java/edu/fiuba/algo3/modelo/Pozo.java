package edu.fiuba.algo3.modelo;

public class Pozo extends Penalizador {
  private Posicion posicion;

  public Pozo(Posicion posicion) {
    this.posicion = posicion;
  }

  @Override
  public int penalizarA(Auto auto) {
    return 3;
  }

  @Override
  public int penalizarA(Moto moto) {
    return 3;
  }

  @Override
  public int penalizarA(Auto4x4 auto4x4) {
    return 2;
  }
}
