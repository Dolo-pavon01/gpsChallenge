package edu.fiuba.algo3.modelo;

public class Auto extends Vehiculo {

  public Auto() {
    super();
  }

  @Override
  public void pasarPor(Obstaculo obstaculo) {
    obstaculo.penalizar(this);
  }
}
