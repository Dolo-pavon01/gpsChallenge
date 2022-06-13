package edu.fiuba.algo3.modelo;

public class Auto4x4 implements TipoVehiculo {

  public int pasarPor(Penalizador visitor) {
    return visitor.visit(this);
  }

  @Override
  public TipoVehiculo cambiarTipo() {
    return new Moto();
  }
}
