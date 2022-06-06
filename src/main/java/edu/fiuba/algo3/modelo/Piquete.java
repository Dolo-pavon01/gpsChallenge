package edu.fiuba.algo3.modelo;

public class Piquete extends Obstaculo {
  public Piquete(int posicion) {
    this.posicion = posicion;
  }

  @Override
  public void penalizar(Auto auto) {
    throw new HayPiqueteException();
    // auto.serPenalizadoCon(2);
  }

  @Override
  public void penalizar(Moto moto) {
    moto.serPenalizadoCon(2);
  }

  @Override
  public void penalizar(Auto4x4 auto4x4) {
    throw new HayPiqueteException();
  }

}
