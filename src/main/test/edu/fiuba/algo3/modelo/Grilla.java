package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Grilla {
  List <Pozo> obstaculos;

  public Grilla(Pozo pozo) {
    this.obstaculos = new ArrayList<Pozo>();
    this.obstaculos.add(pozo);
  }

  public Grilla(List obstaculos) {
    this.obstaculos = obstaculos;
  }

  public void avanzar(Moto moto, String direccion) {
    int posicionActual = moto.posicion();
    int proximaPosicion = posicionActual + 1;
    int penalizacion = 0;

    for (Pozo pozo : this.obstaculos) {
      penalizacion += pozo.aplicarPenalizacion(proximaPosicion);
    }

    moto.actualizaPosicion(proximaPosicion);
    moto.actualizarCantidadMovimientos(1 + penalizacion);
  }

  public void avanzar(Auto auto, String direccion) {

  }
}
