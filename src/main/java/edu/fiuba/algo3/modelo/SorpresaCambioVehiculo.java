package edu.fiuba.algo3.modelo;

public class SorpresaCambioVehiculo implements Sorpresa {

  public TipoVehiculo swapVehiculo(Moto moto) {
    return new Auto();
  }

  public TipoVehiculo swapVehiculo(Auto4x4 auto4x4) {
    return new Moto();
  }

  public TipoVehiculo swapVehiculo(Auto auto) {
    return new Auto4x4();
  }

  @Override
  public double activar(Vehiculo vehiculo) {
    vehiculo.recibirSorpresa(this);
    return 1;
  }
}
