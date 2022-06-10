package edu.fiuba.algo3.modelo;

public class Auto implements Vehiculo  {
private Posicion posicion;
  public Auto() {
    this.posicion = new Posicion(0,0);
  }

  public int pasarPor(Piquete piquete) {
    return 2;
  }
  public Posicion getPosicionSiguiente(char unaDireccion)
  {
    return this.posicion.siguiente(unaDireccion);
  }
  public int pasarPor(Pozo pozo) {
    moverse(pozo.posicion);
    return 2;
  }

  public void moverse(Posicion posicion)
  {
    this.posicion.trasladar(posicion);
  }


}
