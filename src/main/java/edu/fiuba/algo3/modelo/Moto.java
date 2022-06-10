package edu.fiuba.algo3.modelo;

public class Moto implements Vehiculo {
  public Posicion posicion;

  public Moto() {
    this.posicion = new Posicion(0, 0);
  }


  public int pasarPor(Piquete piquete) {
    moverse(piquete.posicion);
    return 3;
  }

  public Posicion getPosicionSiguiente(char unaDireccion) {
    return this.posicion.siguiente(unaDireccion);
  }

  public int pasarPor(Pozo pozo) {
    moverse(pozo.posicion);
    return 3;
  }

  public Posicion getPosicion()
  {
    return this.posicion;
}

  public void moverse(Posicion posicion)
  {
    this.posicion.trasladar(posicion);
  }

}
