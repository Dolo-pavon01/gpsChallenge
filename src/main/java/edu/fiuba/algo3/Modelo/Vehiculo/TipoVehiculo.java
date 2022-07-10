package edu.fiuba.algo3.Modelo.Vehiculo;

import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;

public interface TipoVehiculo {
  int pasarPor(Obstaculo visitor);
  String getNombre();

  TipoVehiculo cambiarTipo();
}
