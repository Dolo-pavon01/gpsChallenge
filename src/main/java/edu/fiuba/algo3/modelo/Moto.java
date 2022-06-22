package edu.fiuba.algo3.modelo;

public class Moto implements TipoVehiculo {

  @Override
  public int pasarPor(IVisitor visitor) {
    return visitor.visit(this);
  }

  @Override
  public TipoVehiculo cambiarTipo() {
    return new Auto();
  }
}
