package edu.fiuba.algo3.modelo;

public class SorpresaCambioVehiculo implements Sorpresa {

  @Override
  public void activar(Vehiculo vehiculo) {
    vehiculo.cambiarTipo();
  }
}
