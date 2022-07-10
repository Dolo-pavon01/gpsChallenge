package edu.fiuba.algo3.Modelo.Vehiculo;

import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.Modelo.Vehiculo.TipoVehiculo;

public class Moto implements TipoVehiculo {

  @Override
  public int pasarPor(Obstaculo visitor) {
    return visitor.visit(this);
  }

  @Override
  public String getNombre() {
    return "Moto";
  }

  @Override
  public TipoVehiculo cambiarTipo() {
    return new Auto();
  }
}
