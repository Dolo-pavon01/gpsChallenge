package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto4x4;
import edu.fiuba.algo3.Modelo.Vehiculo.Moto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    String posicionString = "0;0";
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

  @Test
  public void test08EstaDentroDeLimiteDeUnaPosicionEnYMaximoDevuelveFalso()
  {
    // arrange
    Posicion posicion = Posicion.getPosicion(1, 1);
    // act
    Posicion posicionSiguiente = posicion.siguiente('d');
    // assert
    assertFalse(posicionSiguiente.estaFueraDeLimites(3,3));
  }



  /*@Test
  public void test09EstaDentroDeLimiteDeUnaPosicionEn0DevuelveVerdadero() {
    // arrange
    Posicion posicion = Posicion.getPosicion(1, 1);
    // act
    Posicion posicionSiguiente = posicion.siguiente('a');
    // assert
    assertTrue(posicionSiguiente.estaFueraDeLimites(2,2));
  }*/

}
