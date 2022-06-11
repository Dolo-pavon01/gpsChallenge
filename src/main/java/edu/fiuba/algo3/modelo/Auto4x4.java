package edu.fiuba.algo3.modelo;

public class Auto4x4 implements Vehiculo {
  private int contadorPozos;
  private static final int LIMITE_POZOS_ATRAVESADOS = 2;
  private Posicion posicion;

  public Auto4x4() {
    this.posicion = Posicion.getPosicion(0,0);
    this.contadorPozos = 0;
  }


  public int pasarPor(Piquete piquete) {
    throw new HayPiqueteException();
  }
  public Posicion getPosicion() {
    return this.posicion;
  }
  public int pasarPor(Pozo pozo) {
    this.contadorPozos +=1;
    if(contadorPozos > LIMITE_POZOS_ATRAVESADOS)
      return 2;
    return 0;
  }

  public void moverse(Posicion posicion)
  {
    this.posicion.trasladar(posicion);
  }

}
