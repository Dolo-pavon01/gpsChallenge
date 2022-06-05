package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Grilla {
  List<Obstaculo> obstaculos;

  public Grilla(Obstaculo obstaculo) {
    this.obstaculos = new ArrayList<Obstaculo>();
    this.obstaculos.add(obstaculo);
  }

  public Grilla(List obstaculos) {
    this.obstaculos = obstaculos;
  }

  public void avanzar(Vehiculo vehiculo, String direccion) {
    int posicionActual = vehiculo.posicion();
    int proximaPosicion = posicionActual + 1;
    int penalizacion = 0;

    for (Obstaculo obstaculo : this.obstaculos) {
      penalizacion += obstaculo.penalizar(proximaPosicion);
    }

    vehiculo.mover(proximaPosicion, 1 + penalizacion);
  }
}
