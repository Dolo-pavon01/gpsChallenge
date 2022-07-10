package edu.fiuba.algo3.Modelo;

public class SorpresaCambioVehiculo implements Sorpresa {

  @Override
  public void activar(Vehiculo vehiculo) {
    vehiculo.cambiarTipo();
  }

  @Override
  public String nombreSorpresa()
  {
    return "sorpresa";
  }
}
