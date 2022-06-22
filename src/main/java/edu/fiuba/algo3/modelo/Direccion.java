package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Direccion {

  private static final char ADELANTE = 'w';
  private static final char ATRAS = 's';
  private static final char IZQUIERDA = 'a';
  private static final char DERECHA = 'd';
  private static HashMap<Character, Sentido> comandos;

  public Direccion() {
    this.comandos = new HashMap<Character, Sentido>(4, 10);
    this.comandos.put(ADELANTE, new Adelante());
    this.comandos.put(ATRAS, new Atras());
    this.comandos.put(IZQUIERDA, new Izquierda());
    this.comandos.put(DERECHA, new Derecha());
  }

  public static Posicion moverA(Posicion posicion, char unaDireccion) {
    if (unaDireccion != ADELANTE
        && unaDireccion != ATRAS
        && unaDireccion != IZQUIERDA
        && unaDireccion != DERECHA) {
      throw new CaracterDesconocido();
    }
    Sentido sentido = comandos.get(unaDireccion);
    return sentido.ejecutar(posicion);
  }
}
