package edu.fiuba.algo3.modelo;

public interface TipoVehiculo {
  int pasarPor(IVisitor visitor);

  TipoVehiculo recibirSorpresa(SorpresaCambioVehiculo sorpresaCambioVehiculo);
}
