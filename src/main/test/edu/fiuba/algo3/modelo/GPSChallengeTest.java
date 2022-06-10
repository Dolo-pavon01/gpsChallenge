package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GPSChallengeTest {

  @Test
  public void test01MotoAtraviesaCiudadDeUnaCuadraAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange

    Posicion pozo = new Posicion(1,0);
    Grilla grilla = new Grilla(new Pozo(pozo));
    Moto moto = new Moto();


    // act
    grilla.avanzar(moto,'d');

    // assert
    assertEquals(4, grilla.getMovimientos());
  }

  @Test
  public void
      test02AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    Grilla grilla = new Grilla(new Pozo(new Posicion(1,0)));
    Auto auto = new Auto();

    // act
    grilla.avanzar(auto,'d');

    // assert
    assertEquals(4, grilla.getMovimientos());

  }

  @Test
  public void test03Auto4x4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada() {
    // arrange
    Grilla grilla = new Grilla(new Pozo(new Posicion(1,0)));
    Vehiculo auto4x4 = new Auto4x4();

    // act
    grilla.avanzar(auto4x4,'d');

    // assert
    assertEquals(4, grilla.getMovimientos());
  }

  @Test
  public void test04MotoAtraviesaCiudadSeEncuentraCon2PozosYEsPenalizada() {
    // arrange
    Pozo pozo1 = new Pozo(new Posicion(1,0));
    Pozo pozo2 = new Pozo(new Posicion(2,0));

    Grilla grilla = new Grilla(pozo1, pozo2);
    Vehiculo moto = new Moto();

    // act
    grilla.avanzar(moto,'d');
    grilla.avanzar(moto,'d');

    // assert
    assertEquals(4, grilla.getMovimientos());
  }

  @Test
  public void test05MotoAtraviesaCiudadAtraviesaPiquete() {
    // arrange
    Grilla grilla = new Grilla(new Piquete(new Posicion(1,0)));
    Vehiculo moto = new Moto();

    // act
    grilla.avanzar(moto,'d');

    // assert
    assertEquals(3, grilla.getMovimientos());
  }

  @Test
  public void
      test06AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    Grilla grilla = new Grilla(new Pozo(new Posicion(1,0)));
    Vehiculo auto = new Auto();

    // act
    grilla.avanzar(auto,'d');

    // assert
    assertEquals(4, grilla.getMovimientos());
  }

  @Test
  public void test07Auto4x4AtraviesaLaCiudadYSeEncuentraCon3PozosYEsPenalizada() {
    // arrange
    Pozo pozo1 = new Pozo(new Posicion(1,0));
    Pozo pozo2 = new Pozo(new Posicion(2,0));
    Pozo pozo3 = new Pozo(new Posicion(3,0));
    Grilla grilla = new Grilla(pozo1, pozo2, pozo3);
    Auto4x4 auto4x4 = new Auto4x4();

    // act
    grilla.avanzar(auto4x4,'d');
    grilla.avanzar(auto4x4,'d');
    grilla.avanzar(auto4x4,'d');

    // assert
    assertEquals(5, grilla.getMovimientos());
  }

  @Test
  public void test08AutoAtraviesaCiudadIntentaAtravesarPiquiteNoPuede() {
    // arrange
    Piquete piquete = new Piquete(new Posicion(1,0));
    Grilla grilla = new Grilla(piquete);
    Auto auto = new Auto();

    // act & assert

  }
}
