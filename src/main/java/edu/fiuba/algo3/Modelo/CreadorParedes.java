package edu.fiuba.algo3.Modelo;

import java.util.HashMap;

public class CreadorParedes implements Creador {

  public HashMap crear(int largo,int ancho) {
    HashMap paredes = new HashMap<>(10, 70);
    for (int i = 0; i < largo; i++) {
      Posicion p = Posicion.getPosicion(-1, i);
      paredes.put(p, new Pared());
    }
    for (int i = 0; i < ancho; i++) {
      Posicion p = Posicion.getPosicion(i, -1);
      paredes.put(p, new Pared());
    }
    for (int i = 0; i < largo; i++) {
      Posicion p = Posicion.getPosicion(ancho, i);
      paredes.put(p, new Pared());
    }
    for (int i = 0; i < ancho; i++) {
      Posicion p = Posicion.getPosicion(i, largo);
      paredes.put(p, new Pared());
    }
    return paredes;
  }
}
