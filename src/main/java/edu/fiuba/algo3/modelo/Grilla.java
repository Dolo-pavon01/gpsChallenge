package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

public class Grilla {
  List<Penalizador> obstaculos;
  private int movimientos;

  public Grilla(Penalizador... obstaculosEnJuego) {
    obstaculos = new ArrayList<>();
    Collections.addAll(this.obstaculos,obstaculosEnJuego);
    this.movimientos = 0;
  }

  public void avanzar(Vehiculo vehiculo) {
    for (Penalizador obstaculo : this.obstaculos) {
      if (obstaculo.esMismaPosicion(vehiculo.posicion)) {
        this.movimientos = vehiculo.pasarPor(obstaculo);
      }
    }

  }
}
