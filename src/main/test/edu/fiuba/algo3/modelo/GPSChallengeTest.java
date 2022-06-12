package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GPSChallengeTest {

  @Test
  public void test01MotoAtraviesaCiudadDeUnaCuadraAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    Vehiculo moto = new Vehiculo(new Moto());
    // act
    grilla.avanzar(moto, 'd');
    // assert
    assertEquals(4, moto.movimientos());
  }

  @Test
  public void
      test02AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    Vehiculo auto = new Vehiculo(new Auto());
    // act
    grilla.avanzar(auto, 'd');
    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test03Auto4x4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4());
    // act
    grilla.avanzar(auto4x4, 'd');
    // assert
    assertEquals(1, auto4x4.movimientos());
  }

  @Test
  public void test04MotoAtraviesaCiudadSeEncuentraCon2PozosYEsPenalizada() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    grilla.obstaculos.put(Posicion.getPosicion(2, 0), new Pozo());
    Vehiculo moto = new Vehiculo(new Moto());
    // act
    grilla.avanzar(moto, 'd');
    grilla.avanzar(moto, 'd');
    // assert
    assertEquals(8, moto.movimientos());
  }

  @Test
  public void test05MotoAtraviesaCiudadAtraviesaPiquete() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), new Piquete());
    Vehiculo moto = new Vehiculo(new Moto());
    // act
    grilla.avanzar(moto, 'd');
    // assert
    assertEquals(3, moto.movimientos());
  }

  @Test
  public void
      test06AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    Vehiculo auto = new Vehiculo(new Auto());
    // act
    grilla.avanzar(auto, 'd');
    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test07Auto4x4AtraviesaLaCiudadYSeEncuentraCon3PozosYEsPenalizada() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    grilla.obstaculos.put(Posicion.getPosicion(2, 0), new Pozo());
    grilla.obstaculos.put(Posicion.getPosicion(3, 0), new Pozo());
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4());
    // act
    grilla.avanzar(auto4x4, 'd');
    grilla.avanzar(auto4x4, 'd');
    grilla.avanzar(auto4x4, 'd');
    // assert
    assertEquals(5, auto4x4.movimientos());
  }

  @Test
  public void test08AutoAtraviesaCiudadIntentaAtravesarPiquiteNoPuede() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), new Piquete());
    Vehiculo auto = new Vehiculo(new Auto());
    // act & assert
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          grilla.avanzar(auto, 'd');
        });
    assertEquals(0, auto.movimientos());
  }
}
