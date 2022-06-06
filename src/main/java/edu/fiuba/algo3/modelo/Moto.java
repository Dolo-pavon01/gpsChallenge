package edu.fiuba.algo3.modelo;

public class Moto extends Vehiculo {

  public Moto() {
    super();
  }

  @Override
  public void pasarPor(Obstaculo obstaculo) {
    obstaculo.penalizar(this);
  }
}
