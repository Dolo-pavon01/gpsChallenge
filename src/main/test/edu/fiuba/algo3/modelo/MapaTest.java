package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapaTest {
  @Test
  public void test01MotoSeMuevePorMapaPasaPorPozoEsPenalizado() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    Vehiculo moto = new Vehiculo(new Moto());
    // act
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(4, moto.movimientos());
  }

  @Test
  public void test02MotoSeMueveEnMapaPasaPorPiqueteEsPenalizado() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), new Piquete());
    Vehiculo moto = new Vehiculo(new Moto());
    // act
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(3, moto.movimientos());
  }

  @Test
  public void test03AutoSeMueveEnMapaPasaPorPozoEsPenalizado() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    Vehiculo auto = new Vehiculo(new Auto());
    // act
    mapa.avanzar(auto, 'd');
    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test04AutoSeMueveEnMapaPasaPorPiqueteNoPuedePasar() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), new Piquete());
    Vehiculo auto = new Vehiculo(new Auto());
    // act & assert
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          mapa.avanzar(auto, 'd');
        });
  }

  @Test
  public void test05Auto4x4SeMueveEnMapaPasaPorPozoNoEsPenalizado() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    Vehiculo auto = new Vehiculo(new Auto4x4());
    // act
    mapa.avanzar(auto, 'd');

    // assert
    assertEquals(1, auto.movimientos());
  }

  @Test
  public void test06Auto4x4SeMueveEnMapaPasaPorPozo3VecesEsPenalizado() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    Vehiculo auto = new Vehiculo(new Auto4x4());
    // act
    for (int i = 0; i < 3; i++) {
      mapa.avanzar(auto, 'd');
    }
    // assert
    assertEquals(3, auto.movimientos());
  }

  @Test
  public void test07Auto4x4SeMueveEnMapaPasaPorPiqueteNoPuedePasar() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), new Piquete());
    Vehiculo auto = new Vehiculo(new Auto4x4());
    // act & assert
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          mapa.avanzar(auto, 'd');
        });
  }
}
