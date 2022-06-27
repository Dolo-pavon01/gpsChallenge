package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Posicion {
  private static List<Posicion> instances = new ArrayList<Posicion>();
  private int x;
  private int y;

  public static Posicion getPosicion(int x, int y) {
    for (Posicion posicion : instances) {
      if (posicion.tieneMismasCoordenadas(x, y)) return posicion;
    }
    return new Posicion(x, y);
  }

  private Posicion(int x, int y) {
    this.x = x;
    this.y = y;
    instances.add(this);
  }

  public Posicion trasladar(Posicion nueva) {
    return getPosicion(nueva.x, nueva.y);
  }

  public String posicionAString() {
    return (this.x + "," + this.y);
  }

  public Posicion mover(int x, int y) {
    return getPosicion(this.x + x, this.y + y);
  }

  public boolean equals(Posicion otra)
  {
    return(tieneMismasCoordenadas(otra.x,otra.y));
  }
  private boolean tieneMismasCoordenadas(int x, int y) {
    return this.x == x && this.y == y;
  }

  public Posicion siguiente(char unaDireccion) {
    Direccion direccion = new Direccion();
    return direccion.moverA(this, unaDireccion);
  }
}