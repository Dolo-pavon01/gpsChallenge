package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GPSChallengeTest {

  @Test
  public void test01MotoAtraviesaCiudadDeUnaCuadraAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1,0), new Pozo());
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
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1,0),new Pozo());
    Auto auto = new Auto();

    // act
    grilla.avanzar(auto,'d');

    // assert
    assertEquals(4, grilla.getMovimientos());

  }

  @Test
  public void test03Auto4x4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1,0),new Pozo());
    Vehiculo auto4x4 = new Auto4x4();

    // act
    grilla.avanzar(auto4x4,'d');

    // assert
    assertEquals(1, grilla.getMovimientos());
  }

  @Test
  public void test04MotoAtraviesaCiudadSeEncuentraCon2PozosYEsPenalizada() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1,0),new Pozo());
    grilla.obstaculos.put(Posicion.getPosicion(2,0),new Pozo());
    Vehiculo moto = new Moto();

    // act
    grilla.avanzar(moto,'d');
    grilla.avanzar(moto,'d');

    // assert
    assertEquals(8, grilla.getMovimientos());
  }

  @Test
  public void test05MotoAtraviesaCiudadAtraviesaPiquete() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1,0),new Piquete());
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
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1,0),new Pozo());
    Vehiculo auto = new Auto();

    // act
    grilla.avanzar(auto,'d');

    // assert
    assertEquals(4, grilla.getMovimientos());
  }

  @Test
  public void test07Auto4x4AtraviesaLaCiudadYSeEncuentraCon3PozosYEsPenalizada() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1,0),new Pozo());
    grilla.obstaculos.put(Posicion.getPosicion(2,0),new Pozo());
    grilla.obstaculos.put(Posicion.getPosicion(3,0),new Pozo());
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
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1,0),new Piquete());
    Auto auto = new Auto();

    // act & assert
    grilla.avanzar(auto,'d');

    assertEquals(1,grilla.getMovimientos());
  }
}
