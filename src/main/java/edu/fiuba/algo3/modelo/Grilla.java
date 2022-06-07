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
    int frente_vehiculo = vehiculo.posicion() + 1;
    for (Obstaculo obstaculo : this.obstaculos) {
      if (obstaculo.tieneMismaPosicion(frente_vehiculo))
          vehiculo.pasarPor(obstaculo);
    }
    vehiculo.mover();
  }
}
