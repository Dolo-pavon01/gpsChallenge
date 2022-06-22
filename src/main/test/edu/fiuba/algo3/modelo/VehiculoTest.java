package edu.fiuba.algo3.modelo;

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
}
