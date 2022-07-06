package edu.fiuba.algo3.Modelo;

import java.util.HashMap;

public class CreadorObstaculos implements Creador {

  public HashMap crear(int largo, int ancho) {
    HashMap obstaculos = new HashMap<>(10, 70);
    for (int i = 0; i < ancho; i++) {
      for (int j = 0; j < largo; j++) {
        Posicion p = Posicion.getPosicion(i, j);
        obstaculos.put(p, new ObstaculoNulo());
      }
    }

    obstaculos.put(Posicion.getPosicion(10,11),new Piquete());
    return obstaculos;
  }
}