package edu.fiuba.algo3.Modelo.Vehiculo;

import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;

public class Auto implements TipoVehiculo {
  private final String NOMBRE = "Auto";

  @Override
  public int pasarPor(Obstaculo visitor) {
    return visitor.visit(this);
  }

  @Override
  public String getNombre() {
    return NOMBRE;
  }

  @Override
  public String obtenerNombreEnPosicion(Posicion posicion) {
    return posicion.posicionAString() + ";" + NOMBRE;
  }

  @Override
  public TipoVehiculo cambiarTipo() {
    return new Auto4x4();
  }
}
