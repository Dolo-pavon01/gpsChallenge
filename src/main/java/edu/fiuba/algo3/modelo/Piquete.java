package edu.fiuba.algo3.modelo;

public class Piquete implements Obstaculo {
  public Posicion posicion;
  public Piquete(Posicion posicion) {
    this.posicion = posicion;
  }


  public int penalizarA(Vehiculo vehiculo,char direccion) {
    if(this.posicion.esMismaPosicion(vehiculo.getPosicionSiguiente(direccion)))
      return vehiculo.pasarPor(this);
    return 0;
  }


}
