package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VisitorTest {
  @Test
  public void test01PozoEsVisitadoPorMotoRetornaMulta3() {
    // arrange
    Moto motoMock = mock(Moto.class);
    Pozo pozo = new Pozo();
    // act
    int multa = pozo.visit(motoMock);
    // assert
    assertEquals(3, multa);
  }

  @Test
  public void test02PozoEsVisitadoPorAutoRetornaMulta3() {
    // arrange
    Auto autoMock = mock(Auto.class);
    Pozo pozo = new Pozo();
    // act
    int multa = pozo.visit(autoMock);
    // assert
    assertEquals(3, multa);
  }

  @Test
  public void test03PiqueteEsVisitadoPorMotoRetornaPenalizacion2() {
    // arrange
    Moto motoMock = mock(Moto.class);
    Piquete piquete = new Piquete();
    // act
    int multa = piquete.visit(motoMock);
    // assert
    assertEquals(2, multa);
  }

  @Test
  public void test04PiqueteEsVisitadoPorAutoLanzaExcepcion() {
    // arrange
    Auto autoMock = mock(Auto.class);
    Piquete piquete = new Piquete();
    // act & assert
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          piquete.visit(autoMock);
        });
  }

  @Test
  public void test05PiqueteEsVisitadoPorAuto4x4LanzaExcepcion() {
    // arrange
    Auto4x4 autoMock = mock(Auto4x4.class);
    Piquete piquete = new Piquete();
    // act & assert
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          piquete.visit(autoMock);
        });
  }

  @Test
  public void test06ControlPolicialEsVisitadoPorMotoYMotoNoEsMultado() {
    // arrange
    Moto motoMock = mock(Moto.class);
    Random randomizadorMock = mock(Random.class);
    when(randomizadorMock.nextInt(10)).thenReturn(9);
    ControlPolicial controlPolicial = new ControlPolicial(randomizadorMock);
    // act
    int multa = controlPolicial.visit(motoMock);
    // assert
    assertEquals(0, multa);
  }

  @Test
  public void test07ControlPolicialEsVisitadoPorMotoYMotoEsMultado() {
    // arrange
    Moto motoMock = mock(Moto.class);
    Random randomizadorMock = mock(Random.class);
    when(randomizadorMock.nextInt(10)).thenReturn(7);
    ControlPolicial controlPolicial = new ControlPolicial(randomizadorMock);
    // act
    int multa = controlPolicial.visit(motoMock);
    // assert
    assertEquals(3, multa);
  }

  @Test
  public void test08ControlPolicialEsVisitadoPorAutoYAutoNoEsMultado() {
    // arrange
    Auto autoMock = mock(Auto.class);
    Random randomizadorMock = mock(Random.class);
    when(randomizadorMock.nextInt(10)).thenReturn(6);
    ControlPolicial controlPolicial = new ControlPolicial(randomizadorMock);
    // act
    int multa = controlPolicial.visit(autoMock);
    // assert
    assertEquals(0, multa);
  }

  @Test
  public void test09ControlPolicialEsVisitadoPorAutoYAutoEsMultado() {
    // arrange
    Auto autoMock = mock(Auto.class);
    Random randomizadorMock = mock(Random.class);
    when(randomizadorMock.nextInt(10)).thenReturn(4);
    ControlPolicial controlPolicial = new ControlPolicial(randomizadorMock);
    // act
    int multa = controlPolicial.visit(autoMock);
    // assert
    assertEquals(3, multa);
  }

  @Test
  public void test10ControlPolicialEsVisitadoPorAuto4x4YAuto4x4NoEsMultado() {
    // arrange
    Auto4x4 autoMock = mock(Auto4x4.class);
    Random randomizadorMock = mock(Random.class);
    when(randomizadorMock.nextInt(10)).thenReturn(4);
    ControlPolicial controlPolicial = new ControlPolicial(randomizadorMock);
    // act
    int multa = controlPolicial.visit(autoMock);
    // assert
    assertEquals(0, multa);
  }
}