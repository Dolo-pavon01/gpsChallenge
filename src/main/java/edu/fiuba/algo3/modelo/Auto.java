package edu.fiuba.algo3.modelo;

public class Auto implements TipoVehiculo {

  public int pasarPor(IVisitor visitor) {
    visitor.visit(this);
  }

}
