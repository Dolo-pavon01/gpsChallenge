package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class CreadorParedes implements Creador {

  public HashMap crear(int tamanioMapa) {
    HashMap paredes = new HashMap<>(10, 70);
    for (int i = 0; i < tamanioMapa; i++) {
      Posicion p = Posicion.getPosicion(-1, i);
      paredes.put(p, new Pared());
    }
    for (int i = 0; i < tamanioMapa; i++) {
      Posicion p = Posicion.getPosicion(i, -1);
      paredes.put(p, new Pared());
    }
    for (int i = 0; i < tamanioMapa; i++) {
      Posicion p = Posicion.getPosicion(tamanioMapa, i);
      paredes.put(p, new Pared());
    }
    for (int i = 0; i < tamanioMapa; i++) {
      Posicion p = Posicion.getPosicion(i, tamanioMapa);
      paredes.put(p, new Pared());
    }
    return paredes;
  }
}
