package edu.fiuba.algo3.modelo;

public class Piquete extends Obstaculo implements Penalizador {
  public Piquete(int posicion) {
    this.posicion = posicion;
  }

  @Override
  public int penalizarA(Auto auto) {
    throw new HayPiqueteException();
  }

  @Override
  public int penalizarA(Moto moto) {
    return 4 ;
  }

  @Override
  public int penalizarA(Auto4x4 auto4x4) {
    throw new HayPiqueteException();
  }

}
