package edu.fiuba.algo3.modelo;

public interface TipoVehiculo {
  int pasarPor(Obstaculo visitor);

  TipoVehiculo cambiarTipo();
}
