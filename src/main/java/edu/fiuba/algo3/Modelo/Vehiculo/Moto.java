package edu.fiuba.algo3.Modelo.Vehiculo;

import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;

public class Moto implements TipoVehiculo {
  private final String NOMBRE = "Moto";

  @Override
  public String obtenerNombreEnPosicion(Posicion posicion) {
    return posicion.posicionAString() + ";" + NOMBRE;
  }

  @Override
  public int pasarPor(Obstaculo visitor) {
    return visitor.visit(this);
  }

  @Override
  public String getNombre() {
    return NOMBRE;
  }

  @Override
  public TipoVehiculo cambiarTipo() {
    return new Auto();
  }
}
