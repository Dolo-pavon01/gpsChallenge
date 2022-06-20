package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Direccion {

  private static HashMap<Character, Sentido> comandos;

  public Direccion() {
    this.comandos = new HashMap<Character, Sentido>(4, 10);
    this.comandos.put('w', new Adelante());
    this.comandos.put('s', new Atras());
    this.comandos.put('a', new Izquierda());
    this.comandos.put('d', new Derecha());
  }

  public static Posicion moverA(Posicion posicion, char unaDireccion) {
    Sentido sentido = comandos.get(unaDireccion);
    return sentido.ejecutar(posicion);
  }
}
