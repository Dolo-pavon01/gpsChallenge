package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

public class Grilla {
  List<Obstaculo> obstaculos;

  public Grilla(Obstaculo... obstaculosEnJuego) {
    obstaculos = new ArrayList<>();
    Collections.addAll(this.obstaculos,obstaculosEnJuego);
  }

  public void avanzar(Vehiculo vehiculo) {
    vehiculo.mover();
    int posicion_vehiculo = vehiculo.posicion();
    for (Obstaculo obstaculo : this.obstaculos) {
      if (obstaculo.tieneMismaPosicion(posicion_vehiculo))
          vehiculo.pasarPor(obstaculo);
    }
  }
}
