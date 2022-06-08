package edu.fiuba.algo3.modelo;

public class Moto implements Movible{
  private Posicion posicion;

  public Moto() {
    super();
  }

  @Override
  public int pasarPor(Penalizador obstaculo) {
    return obstaculo.penalizarA(this);
  }

}
