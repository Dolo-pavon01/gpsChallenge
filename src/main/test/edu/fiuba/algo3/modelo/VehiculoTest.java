package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VehiculoTest {
  @Test
  public void test01TipoAutoPasaPorPozoYEsPenalizadoCon3() {
    // arrange
    Auto auto = new Auto();
    Pozo pozoMock = mock(Pozo.class);
    when(pozoMock.visit(auto)).thenReturn(3);
    // act
    int multa = auto.pasarPor(pozoMock);
    // assert
    assertEquals(3, multa);
  }

  @Test
  public void test02TipoMotoPasaPorPozoYEsPenalizadoCon3() {
    // arrange
    Moto moto = new Moto();
    Pozo pozoMock = mock(Pozo.class);
    when(pozoMock.visit(moto)).thenReturn(3);
    // act
    int multa = moto.pasarPor(pozoMock);
    // assert
    assertEquals(3, multa);
  }

  @Test
  public void test03TipoAuto4x4PasaPorPozoYEsPenalizadoCon0() {
    // arrange
    Auto4x4 auto4x4 = new Auto4x4();
    Pozo pozoMock = mock(Pozo.class);
    when(pozoMock.visit(auto4x4)).thenReturn(3);
    // act
    int multa = auto4x4.pasarPor(pozoMock);
    // assert
    assertEquals(3, multa);
  }

  @Test
  public void test04MotoCambiaTipoAAuto() {
    // arrange
    Moto moto = new Moto();
    // act & assert
    assertEquals(Auto.class, moto.cambiarTipo().getClass());
  }

  @Test
  public void test05AutoCambiaTipoAAuto4x4() {
    // arrange
    Auto auto = new Auto();
    // act & assert
    assertEquals(Auto4x4.class, auto.cambiarTipo().getClass());
  }

  @Test
  public void test06Auto4x4CambiaTipoAMoto() {
    // arrange
    Auto4x4 auto4x4 = new Auto4x4();
    // act & assert
    assertEquals(Moto.class, auto4x4.cambiarTipo().getClass());
  }

  @Test
  public void test08PasarTipoMotoPasaPorPozoEsPenalizado() {
    // arrange
    Moto moto = new Moto();
    Pozo pozo = new Pozo();
    // act
    int multa = moto.pasarPor(pozo);
    // assert
    assertEquals(3, multa);
  }

  @Test
  public void test09PasarTipoMotoPasaPorPiqueteEsPenalizado() {
    // arrange
    Moto moto = new Moto();
    Piquete piquete = new Piquete();
    // act
    int multa = moto.pasarPor(piquete);
    // assert
    assertEquals(2, multa);
  }

  @Test
  public void test10PasarTipoAutoPasaPorPozoEsPenalizado() {
    // arrange
    Pozo pozo = new Pozo();
    Auto auto = new Auto();
    // act
    int multa = auto.pasarPor(pozo);
    // assert
    assertEquals(3, multa);
  }

  @Test
  public void test11PasarTipoAutoPasaPorPiqueteLanzaExcepcion() {
    // arrange
    Piquete piquete = new Piquete();
    Auto auto = new Auto();
    // act & assert
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          auto.pasarPor(piquete);
        });
  }

  @Test
  public void test12PasarTipoAuto4x4PasaPorPozoUnaVezNoEsPenalizado() {
    // arrange
    Pozo pozo = new Pozo();
    Auto4x4 auto4x4 = new Auto4x4();
    // act
    int multa = auto4x4.pasarPor(pozo);
    // assert
    assertEquals(0, multa);
  }

  @Test
  public void test13PasarTipoAuto4x4PasaPorPozo3VecesEsPenalizado() {
    // arrange
    Pozo pozo = new Pozo();
    Auto4x4 auto4x4 = new Auto4x4();
    // act
    auto4x4.pasarPor(pozo);
    auto4x4.pasarPor(pozo);
    int multa = auto4x4.pasarPor(pozo);
    // assert
    assertEquals(2, multa);
  }

  @Test
  public void test14PasarTipoAuto4x4PasaPorPiqueteLanzaExcepcion() {
    // arrange
    Piquete piquete = new Piquete();
    Auto4x4 auto4x4 = new Auto4x4();
    // act & assert
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          auto4x4.pasarPor(piquete);
        });
  }
}
