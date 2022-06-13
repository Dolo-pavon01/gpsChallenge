package edu.fiuba.algo3.modelo;

public class SorpresaCambioVehiculo implements Sorpresa {

  public TipoVehiculo cambiarVehiculo(Moto moto) {
    return new Auto();
  }

  public TipoVehiculo cambiarVehiculo(Auto4x4 auto4x4) {
    return new Moto();
  }

  public TipoVehiculo cambiarVehiculo(Auto auto) {
    return new Auto4x4();
  }

  @Override
  public double activar(Vehiculo vehiculo) {
    vehiculo.recibirSorpresa(this);
    return 1;
  }
}
