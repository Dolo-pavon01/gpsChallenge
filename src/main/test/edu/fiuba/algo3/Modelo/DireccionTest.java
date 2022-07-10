package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Direccion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {

  @Test
  public void test01TrasladarConDireccionWCambiaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Direccion direccion = new Direccion();
    // act
    Posicion siguientePosicion = direccion.moverA(posicion, 'w');
    // assert
    assertEquals(Posicion.getPosicion(0, 1), siguientePosicion);
  }

  @Test
  public void test02TrasladarConDireccionSCambiaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Direccion direccion = new Direccion();
    // act
    Posicion siguientePosicion = direccion.moverA(posicion, 's');
    // assert
    assertEquals(Posicion.getPosicion(0, -1), siguientePosicion);
  }

  @Test
  public void test03TrasladarConDireccionACambiaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Direccion direccion = new Direccion();
    // act
    Posicion siguientePosicion = direccion.moverA(posicion, 'a');
    // assert
    assertEquals(Posicion.getPosicion(-1, 0), siguientePosicion);
  }

  @Test
  public void test04TrasladarConDireccionDCambiaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Direccion direccion = new Direccion();
    // act
    Posicion siguientePosicion = direccion.moverA(posicion, 'd');
    // assert
    assertEquals(Posicion.getPosicion(1, 0), siguientePosicion);
  }

  @Test
  public void test05TrasladarDireccionConCaracterDesconocidoLanzaExcepcion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Direccion direccion = new Direccion();
    // act & assert
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          direccion.moverA(posicion, 't');
        });
  }

  @Test
  public void test06MoverEnUnDireccionDActualizaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Posicion posicionEsperada = Posicion.getPosicion(1, 0);
    Direccion direccion = new Direccion();
    // act
    Posicion posicionSiguiente = Direccion.moverA(posicion, 'd');
    // assert
    assertTrue(posicionSiguiente.equals(posicionEsperada));
  }

  @Test
  public void test07MoverEnUnDireccionAActualizaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Posicion posicionEsperada = Posicion.getPosicion(-1, 0);
    Direccion direccion = new Direccion();
    // act
    Posicion posicionSiguiente = Direccion.moverA(posicion, 'a');
    // assert
    assertTrue(posicionSiguiente.equals(posicionEsperada));
  }

  @Test
  public void test08MoverEnUnDireccionSActualizaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Posicion posicionEsperada = Posicion.getPosicion(0, -1);
    Direccion direccion = new Direccion();
    // act
    Posicion posicionSiguiente = Direccion.moverA(posicion, 's');
    // assert
    assertTrue(posicionSiguiente.equals(posicionEsperada));
  }

  @Test
  public void test09MoverEnUnDireccionSActualizaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Posicion posicionEsperada = Posicion.getPosicion(0, 1);
    Direccion direccion = new Direccion();
    // act
    Posicion posicionSiguiente = Direccion.moverA(posicion, 'w');
    // assert
    assertTrue(posicionSiguiente.equals(posicionEsperada));
  }

  @Test
  public void test10MoverEnUnaDireccionConCaracterInvalidoLanzaExcepcion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Direccion direccion = new Direccion();
    // act & assert
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          Direccion.moverA(posicion, 'x');
        });
  }
}
