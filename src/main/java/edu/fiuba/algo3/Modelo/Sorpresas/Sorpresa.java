package edu.fiuba.algo3.Modelo.Sorpresas;

import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;

public interface Sorpresa {
  void activar(Vehiculo vehiculo);

  String nombreSorpresa();
}