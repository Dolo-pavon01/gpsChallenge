package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

  @Test
  public void test04SeIngresaCaracterDesconocidoPorFueraDeWASDYElSistemaArrojaExcepcion() {
    // arrange
    Posicion origen = Posicion.getPosicion(0, 0);
    // act & assert
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          origen.siguiente('f');
        });
  }

  @Test
  public void test05ObtenerPosicionComoCadenaDeCaracteres() {
    // arrange
    String posicionString = "0,0";
    Posicion posicion = Posicion.getPosicion(0, 0);
    // act & assert
    assertEquals(posicionString, posicion.posicionAString());
  }

  @Test
  public void test06TrasladarConLaMismaPosicionDevuelveMismaInstancia() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    // act
    Posicion posicionNueva = posicion.trasladar(posicion);
    // assert
    assertEquals(posicionNueva, posicion);
  }

  @Test
  public void test07AvanzarASiguientePosicionConCaracterActualizaPosicion() {
    // arrange
    Posicion posicionEsperada = Posicion.getPosicion(1, 0);
    Posicion posicion = Posicion.getPosicion(0, 0);
    // act
    Posicion posicionSiguiente = posicion.siguiente('d');
    // assert
    assertTrue(posicionSiguiente.equals(posicionEsperada));
  }
}
