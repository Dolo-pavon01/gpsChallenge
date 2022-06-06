package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Grilla {
  List<Obstaculo> obstaculos;

  public Grilla(Obstaculo... obstaculos) {
    this.obstaculos = new ArrayList<Obstaculo>();
    for (Obstaculo obstaculo : obstaculos) {
      this.obstaculos.add(obstaculo);
    }
  }

  public void avanzar(Vehiculo vehiculo) {
    vehiculo.mover();
    for (Obstaculo obstaculo : this.obstaculos) {
      if (obstaculo.posicion == vehiculo.posicion) {
        vehiculo.pasarPor(obstaculo);
      }
    }
  }
}
