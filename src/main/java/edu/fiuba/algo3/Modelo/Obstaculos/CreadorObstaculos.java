package edu.fiuba.algo3.Modelo.Obstaculos;

import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;

import java.util.HashMap;

public class CreadorObstaculos implements Creador {

  public HashMap crear(int alto, int ancho) {
    HashMap obstaculos = new HashMap<>(10, 70);
    for (int i = 0; i < alto; i++) {
      for (int j = 0; j < ancho; j++) {
        Posicion p = Posicion.getPosicion(i, j);
        obstaculos.put(p, new ObstaculoNulo());
      }
    }
    return obstaculos;
  }
}
