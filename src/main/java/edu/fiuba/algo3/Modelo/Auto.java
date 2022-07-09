package edu.fiuba.algo3.Modelo;

public class Auto implements TipoVehiculo {

  @Override
  public int pasarPor(Obstaculo visitor) {
    return visitor.visit(this);
  }

  @Override
  public String getNombre() {
    return "Auto";
  }

  @Override
  public TipoVehiculo cambiarTipo() {
    return new Auto4x4();
  }
}
