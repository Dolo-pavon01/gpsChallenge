package edu.fiuba.algo3.modelo;

public class Auto implements TipoVehiculo {

  public int pasarPor(IVisitor visitor) {
    return visitor.visit(this);
  }

  @Override
  public TipoVehiculo recibirSorpresa(SorpresaCambioVehiculo sorpresaCambioVehiculo) {
    return sorpresaCambioVehiculo.cambiarVehiculo(this);
  }
}
