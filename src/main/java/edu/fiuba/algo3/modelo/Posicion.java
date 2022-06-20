package edu.fiuba.algo3.modelo;

import java.util.*;

public class Posicion {
  public int x;
  public int y;
  private static List<Posicion> instances = new ArrayList<Posicion>();

  public Posicion trasladar(Posicion nueva) {
    return getPosicion(nueva.x, nueva.y);
  }

  public Posicion moverHaciaArriba()
  {
    return getPosicion(this.x,this.y +1);
  }
  public Posicion moverHaciaDerecha()
  {
    return getPosicion(this.x +1,this.y );
  }  public Posicion moverHaciaIzquierda()
  {
    return getPosicion(this.x-1,this.y );
  }  public Posicion moverHaciaAbajo()
  {
    return getPosicion(this.x,this.y -1);
  }
  private Posicion(int x, int y) {
    this.x = x;
    this.y = y;
    instances.add(this);
  }

  public static Posicion getPosicion(int x, int y) {
    for (Posicion i : instances) {
      if (i.x == x && i.y == y) return i;
    }
    return new Posicion(x, y);
  }

  public Posicion siguiente(char unaDireccion) {
    Direccion direccion = new Direccion();
    return direccion.moverA(this, unaDireccion);
  }

  public void pertenceADominio(int tamanio) {

  }
}
