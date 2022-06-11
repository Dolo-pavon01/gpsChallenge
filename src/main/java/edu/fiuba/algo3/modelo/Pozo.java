package edu.fiuba.algo3.modelo;

public class Pozo implements Obstaculo {
  public int penalizarA(Vehiculo vehiculo)
  {
      return vehiculo.pasarPor(this);
  }


}
