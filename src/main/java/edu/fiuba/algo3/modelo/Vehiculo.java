package edu.fiuba.algo3.modelo;

public abstract class Vehiculo extends Movible {
  protected Posicion posicion;

  public Vehiculo() {
   posicion = new Posicion(0,0);
  }
  public Posicion posicion()
  {return this.posicion;}


  public abstract int pasarPor(Penalizador obstaculo);


}
