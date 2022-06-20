package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DireccionTest {

  @Test
  public void test01DireccionWMueveHaciaArriba() {
    // arrange
    Posicion posicionMock = mock(Posicion.class);
    Direccion direccion = new Direccion();
    // act
    direccion.moverA(posicionMock, 'w');
    // assert
    verify(posicionMock).moverHaciaArriba();
  }

  @Test
  public void test02DireccionSMueveHaciaAbajo() {
    // arrange
    Posicion posicionMock = mock(Posicion.class);
    Direccion direccion = new Direccion();
    // act
    direccion.moverA(posicionMock, 's');
    // assert
    verify(posicionMock).moverHaciaAbajo();
  }

  @Test
  public void test03DireccionAMueveHaciaIzquierda() {
    // arrange
    Posicion posicionMock = mock(Posicion.class);
    Direccion direccion = new Direccion();
    // act
    direccion.moverA(posicionMock, 'a');
    // assert
    verify(posicionMock).moverHaciaIzquierda();
  }

  @Test
  public void test04DireccionDMueveHaciaDerecha() {
    // arrange
    Posicion posicionMock = mock(Posicion.class);
    Direccion direccion = new Direccion();
    // act
    direccion.moverA(posicionMock, 'd');
    // assert
    verify(posicionMock).moverHaciaDerecha();
  }

  @Test
  public void test05TrasladarConDireccionWCambiaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Direccion direccion = new Direccion();
    // act
    Posicion siguientePosicion = direccion.moverA(posicion, 'w');
    // assert
    assertEquals(Posicion.getPosicion(0, 1), siguientePosicion);
  }

  @Test
  public void test06TrasladarConDireccionSCambiaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Direccion direccion = new Direccion();
    // act
    Posicion siguientePosicion = direccion.moverA(posicion, 's');
    // assert
    assertEquals(Posicion.getPosicion(0, -1), siguientePosicion);
  }

  @Test
  public void test07TrasladarConDireccionACambiaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Direccion direccion = new Direccion();
    // act
    Posicion siguientePosicion = direccion.moverA(posicion, 'a');
    // assert
    assertEquals(Posicion.getPosicion(-1, 0), siguientePosicion);
  }

  @Test
  public void test08TrasladarConDireccionDCambiaPosicion() {
    // arrange
    Posicion posicion = Posicion.getPosicion(0, 0);
    Direccion direccion = new Direccion();
    // act
    Posicion siguientePosicion = direccion.moverA(posicion, 'd');
    // assert
    assertEquals(Posicion.getPosicion(1, 0), siguientePosicion);
  }
}