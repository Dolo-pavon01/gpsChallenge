package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class VisitorTest {
  @Test
  public void test01PozoEsVisitadoPorMotoRetornaMulta3() {
    // arrange
    int multaEsperada = 3;
    Moto motoMock = mock(Moto.class);
    Pozo pozo = new Pozo();
    // act
    int multa = pozo.visit(motoMock);
    // assert
    assertEquals(multaEsperada, multa);
  }

  @Test
  public void test02PozoEsVisitadoPorAutoRetornaMulta3() {
    // arrange
    int multaEsperada = 3;
    Auto autoMock = mock(Auto.class);
    Pozo pozo = new Pozo();
    // act
    int multa = pozo.visit(autoMock);
    // assert
    assertEquals(multaEsperada, multa);
  }

  @Test
  public void test03PiqueteEsVisitadoPorMotoRetornaPenalizacion2() {
    // arrange
    int multaEsperada = 2;
    Moto motoMock = mock(Moto.class);
    Piquete piquete = new Piquete();
    // act
    int multa = piquete.visit(motoMock);
    // assert
    assertEquals(multaEsperada, multa);
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
}