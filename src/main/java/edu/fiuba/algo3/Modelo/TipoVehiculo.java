package edu.fiuba.algo3.Modelo;

public interface TipoVehiculo {
  int pasarPor(Obstaculo visitor);
  String getNombre();

  TipoVehiculo cambiarTipo();
}
