package edu.fiuba.algo3.modelo;

public class Auto4x4 implements TipoVehiculo {
  public int contadorPozos;
  public Auto4x4()
  {
    this.contadorPozos =0;
  }

  public int pasarPor(IVisitor visitor) {
    return visitor.visit(this);
  }

  @Override
  public TipoVehiculo cambiarTipo() {
    return new Moto();
  }
}
