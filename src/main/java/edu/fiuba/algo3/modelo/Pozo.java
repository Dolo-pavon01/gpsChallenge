package edu.fiuba.algo3.modelo;

public class Pozo extends Obstaculo {
  public Pozo(int posicion) {
    this.posicion = posicion;
  }

  @Override
  public void penalizar(Auto auto) {
    auto.serPenalizadoCon(3);
  }

  @Override
  public void penalizar(Moto moto) {
    moto.serPenalizadoCon(3);
  }

  @Override
  public void penalizar(Auto4x4 auto4x4) {
    auto4x4.serPenalizadoCon(2);
  }
}
