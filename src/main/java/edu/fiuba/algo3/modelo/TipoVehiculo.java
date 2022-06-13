package edu.fiuba.algo3.modelo;

public interface TipoVehiculo {
  int pasarPor(Penalizador visitor);

  TipoVehiculo cambiarTipo();
}
