package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Posicion {
  private static List<Posicion> instances = new ArrayList<Posicion>();
  private int x;
  private int y;

  public Posicion trasladar(Posicion nueva) {
    return getPosicion(nueva.x, nueva.y);
  }

  public String posicionAString()
  {
    return (Integer.toString(this.x) +"," + Integer.toString(this.y));
  }

  public Posicion moverHaciaArriba() {
    return getPosicion(this.x, this.y + 1);
  }

  public Posicion moverHaciaDerecha() {
    return getPosicion(this.x + 1, this.y);
  }

  public Posicion moverHaciaIzquierda() {
    return getPosicion(this.x - 1, this.y);
  }

  public Posicion moverHaciaAbajo() {
    return getPosicion(this.x, this.y - 1);
  }

  private Posicion(int x, int y) {
    this.x = x;
    this.y = y;
    instances.add(this);
  }

  private boolean tieneMismasCoordenadas(int x, int y) {
    return this.x == x && this.y == y;
  }

  public static Posicion getPosicion(int x, int y) {
    for (Posicion posicion : instances) {
      if (posicion.tieneMismasCoordenadas(x, y)) return posicion;
    }
    return new Posicion(x, y);
  }

  public Posicion siguiente(char unaDireccion) {
    Direccion direccion = new Direccion();
    return direccion.moverA(this, unaDireccion);
  }

}
