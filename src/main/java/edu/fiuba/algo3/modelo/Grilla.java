package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Grilla {
  HashMap<Posicion, Obstaculo> obstaculos;
  private int movimientos;

  public Grilla() {
    obstaculos = new HashMap<Posicion, Obstaculo>(10, 70);
    this.movimientos = 0;
  }

  public int getMovimientos() {
    return this.movimientos;
  }

  public void avanzar(Vehiculo vehiculo, char direccion) {

    this.movimientos += 1;
    Posicion posicionActual = vehiculo.getPosicion();
    Posicion posicion = posicionActual.siguiente(direccion);
    Obstaculo obstaculo = obstaculos.get(posicion);
    try{
      this.movimientos += obstaculo.penalizarA(vehiculo);
    }
    catch(RuntimeException HayPiqueteException)
    {
      return;
    }
    vehiculo.moverse(posicion);
  }
}