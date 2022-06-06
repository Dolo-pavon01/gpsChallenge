package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GPSChallengeTest {

  @Test
  public void test01MotoAtraviesaCiudadDeUnaCuadraAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    Grilla grilla = new Grilla(new Pozo(1));
    Moto moto = new Moto();

    // act
    grilla.avanzar(moto);

    // assert
    assertEquals(4, moto.movimientos());
  }

  @Test
  public void
      test02AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    Grilla grilla = new Grilla(new Pozo(1));
    Auto auto = new Auto();

    // act
    grilla.avanzar(auto);

    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test03Auto4x4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada() {
    // arrange
    Grilla grilla = new Grilla(new Pozo(1));
    Auto4x4 auto4x4 = new Auto4x4();

    // act
    grilla.avanzar(auto4x4);

    // assert
    assertEquals(1, auto4x4.movimientos());
  }

  @Test
  public void test04MotoAtraviesaCiudadSeEncuentraCon2PozosYEsPenalizada() {
    // arrange
    Pozo pozo1 = new Pozo(1);
    Pozo pozo2 = new Pozo(2);

    Grilla grilla = new Grilla(pozo1, pozo2);
    Moto moto = new Moto();

    // act
    grilla.avanzar(moto);
    grilla.avanzar(moto);

    // assert
    assertEquals(8, moto.movimientos());
  }

  @Test
  public void test05MotoAtraviesaCiudadAtraviesaPiquete() {
    // arrange
    Grilla grilla = new Grilla(new Piquete(1));
    Moto moto = new Moto();

    // act
    grilla.avanzar(moto);

    // assert
    assertEquals(3, moto.movimientos());
  }

  @Test
  public void
      test06AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    Grilla grilla = new Grilla(new Pozo(1));
    Auto auto = new Auto();

    // act
    grilla.avanzar(auto);

    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test07Auto4x4AtraviesaLaCiudadYSeEncuentraCon3PozosYEsPenalizada() {
    // arrange
    Pozo pozo1 = new Pozo(1);
    Pozo pozo2 = new Pozo(2);
    Pozo pozo3 = new Pozo(3);
    Grilla grilla = new Grilla(pozo1, pozo2, pozo3);
    Auto4x4 auto4x4 = new Auto4x4();

    // act
    grilla.avanzar(auto4x4);
    grilla.avanzar(auto4x4);
    grilla.avanzar(auto4x4);

    // assert
    assertEquals(5, auto4x4.movimientos());
  }

  @Test
  public void test08AutoAtraviesaCiudadIntentaAtravesarPiquiteNoPuede() {
    // arrange
    Piquete piquete = new Piquete(1);
    Grilla grilla = new Grilla(piquete);
    Auto auto = new Auto();

    // act & assert
    assertThrows(RuntimeException.class, () -> {
      grilla.avanzar(auto);
    });
  }
}
