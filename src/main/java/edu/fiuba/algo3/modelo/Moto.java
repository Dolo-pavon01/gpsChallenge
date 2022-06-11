package edu.fiuba.algo3.modelo;

public class Moto implements Vehiculo {
  public Posicion posicion;

  public Moto() {
    this.posicion = Posicion.getPosicion(0,0);
  }


  public int pasarPor(Piquete piquete) {
    return 2;
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
