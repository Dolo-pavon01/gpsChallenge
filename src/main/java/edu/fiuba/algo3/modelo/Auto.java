package edu.fiuba.algo3.modelo;

public class Auto implements Movible  {

  public Auto() {
    super();
  }

  @Override
  public void pasarPor(Obstaculo obstaculo) {
    obstaculo.penalizar(this);
  }


}
