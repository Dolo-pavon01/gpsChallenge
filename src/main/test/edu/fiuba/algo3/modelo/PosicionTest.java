package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosicionTest {
  @Test
  public void test01SeMueveIzquierdaYDespuesArriba() {
    // arrange
    Posicion origen = Posicion.getPosicion(0, 0);
    // act
    Posicion siguiente = origen.siguiente('d');
    origen = origen.trasladar(siguiente);
    // assert
    assertEquals(Posicion.getPosicion(1, 0), origen);

    origen = origen.trasladar(origen.siguiente('w'));
    assertEquals(Posicion.getPosicion(1, 1), origen);
  }

  @Test
  public void test02SeMueveIzquierdaYDespuesDerecha() {
    // arrange
    Posicion origen = Posicion.getPosicion(0, 0);
    // act
    Posicion siguiente = origen.siguiente('d');
    origen = origen.trasladar(siguiente);
    // assert
    assertEquals(Posicion.getPosicion(1, 0), origen);
    origen = origen.trasladar(origen.siguiente('a'));
    assertEquals(Posicion.getPosicion(0, 0), origen);
  }

  @Test
  public void test03SeMuevePosicionArribaYDespuesSeMueveAbajo() {
    // arrange
    Posicion origen = Posicion.getPosicion(0, 0);
    // act & assert
    Posicion siguiente = origen.siguiente('w');
    origen = origen.trasladar(siguiente);
    assertEquals(Posicion.getPosicion(0, 1), origen);
    // act & assert
    origen = origen.trasladar(origen.siguiente('s'));
    assertEquals(Posicion.getPosicion(0, 0), origen);
  }

}
