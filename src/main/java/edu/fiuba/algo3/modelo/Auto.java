package edu.fiuba.algo3.modelo;

public class Auto implements Vehiculo  {
private Posicion posicion;
  public Auto() {
    this.posicion = Posicion.getPosicion(0,0);
  }

  public int pasarPor(Piquete piquete) {
    throw new HayPiqueteException();
  }
  public Posicion getPosicion() {
    return this.posicion;
  }
  public int pasarPor(Pozo pozo) {
    return 3;
  }

  public void moverse(Posicion posicion)
  {
    this.posicion.trasladar(posicion);
  }


}
