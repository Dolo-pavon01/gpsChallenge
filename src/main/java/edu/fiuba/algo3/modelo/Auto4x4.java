package edu.fiuba.algo3.modelo;

public class Auto4x4 implements Vehiculo {
  private int contadorPozos;
  private static final int LIMITE_POZOS_ATRAVESADOS = 2;
  private Posicion posicion;

  public Auto4x4() {
    this.posicion = new Posicion(0,0);
    this.contadorPozos = 0;
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
    if(contadorPozos> LIMITE_POZOS_ATRAVESADOS)
      return 2;
    this.contadorPozos +=1;
    return 0;
  }

  public void moverse(Posicion posicion)
  {
    this.posicion.trasladar(posicion);
  }

}
