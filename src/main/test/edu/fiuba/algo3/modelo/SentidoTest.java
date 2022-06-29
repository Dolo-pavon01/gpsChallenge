package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SentidoTest {

  @Test
  public void test01SentidoAdelanteActualizaPosicionHaciaArriba() {
    // arrange
    Adelante adelante = new Adelante();
    Posicion posicion = Posicion.getPosicion(0, 0);
    Posicion posicionEsperada = Posicion.getPosicion(0, 1);
    // act
    Posicion posicionSiguiente = adelante.ejecutar(posicion);
    // assert
    assertTrue(posicionSiguiente.equals(posicionEsperada));
  }

  @Test
  public void test02SentidoAtrasActualizaPosicionHaciaAbajo() {
    // arrange
    Atras atras = new Atras();
    Posicion posicion = Posicion.getPosicion(0, 0);
    Posicion posicionEsperada = Posicion.getPosicion(0, -1);
    // act
    Posicion posicionSiguiente = atras.ejecutar(posicion);
    // assert
    assertTrue(posicionSiguiente.equals(posicionEsperada));
  }

  @Test
  public void test03SentidoIzquierdaActualizaPosicionHaciaIzquierda() {
    // arrange
    Izquierda izquierda = new Izquierda();
    Posicion posicion = Posicion.getPosicion(0, 0);
    Posicion posicionEsperada = Posicion.getPosicion(-1, 0);
    // act
    Posicion posicionSiguiente = izquierda.ejecutar(posicion);
    // assert
    assertTrue(posicionSiguiente.equals(posicionEsperada));
  }

  @Test
  public void test04SentidoDerechaActualizaPosicionHaciaDerecha() {
    // arrange
    Derecha derecha = new Derecha();
    Posicion posicion = Posicion.getPosicion(0, 0);
    Posicion posicionEsperada = Posicion.getPosicion(1, 0);
    // act
    Posicion posicionSiguiente = derecha.ejecutar(posicion);
    // assert
    assertTrue(posicionSiguiente.equals(posicionEsperada));
  }
}
