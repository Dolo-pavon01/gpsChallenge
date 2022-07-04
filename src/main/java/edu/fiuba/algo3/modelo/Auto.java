package edu.fiuba.algo3.modelo;

public class Auto implements TipoVehiculo {

  @Override
  public int pasarPor(Obstaculo visitor) {
    return visitor.visit(this);
  }

  @Override
  public TipoVehiculo cambiarTipo() {
    return new Auto4x4();
  }
}
