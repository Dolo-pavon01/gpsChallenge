package edu.fiuba.algo3.modelo;

public class Moto implements TipoVehiculo {


  public int pasarPor(IVisitor visitor) {
    visitor.visit(this);
  }
}
