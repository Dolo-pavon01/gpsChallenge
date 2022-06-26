package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
