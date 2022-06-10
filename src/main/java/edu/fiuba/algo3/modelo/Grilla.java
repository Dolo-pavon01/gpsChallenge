package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grilla {
  List<Obstaculo> obstaculos;
  private int movimientos;

  public Grilla(Obstaculo... obstaculosEnJuego) {
    obstaculos = new ArrayList<>();
    Collections.addAll(this.obstaculos,obstaculosEnJuego);
    this.movimientos = 0;
  }
  public int getMovimientos()
  {
    return this.movimientos;
  }
  public void avanzar(Vehiculo vehiculo,char direccion) {

    this.movimientos+=1;
    for(Obstaculo o: this.obstaculos)
      this.movimientos += o.penalizarA(vehiculo,direccion);
  }
}
