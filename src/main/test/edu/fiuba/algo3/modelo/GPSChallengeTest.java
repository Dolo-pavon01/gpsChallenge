package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GPSChallengeTest {

  @Test
  public void test01MotoAtraviesaCiudadDeUnaCuadraAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), Pozo.getInstance());
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
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), Pozo.getInstance());
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
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), Pozo.getInstance());
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4());
    // act
    grilla.avanzar(auto4x4, 'd');
    // assert
    assertEquals(1, auto4x4.movimientos());
    Pozo.getInstance().resetContadorPozos();
  }

  @Test
  public void test04MotoAtraviesaCiudadSeEncuentraCon2PozosYEsPenalizada() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), Pozo.getInstance());
    grilla.obstaculos.put(Posicion.getPosicion(2, 0), Pozo.getInstance());
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
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), Piquete.getInstance());
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
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), Pozo.getInstance());
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
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), Pozo.getInstance());
    grilla.obstaculos.put(Posicion.getPosicion(2, 0), Pozo.getInstance());
    grilla.obstaculos.put(Posicion.getPosicion(3, 0), Pozo.getInstance());
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4());
    // act
    grilla.avanzar(auto4x4, 'd');
    grilla.avanzar(auto4x4, 'd');
    grilla.avanzar(auto4x4, 'd');
    // assert
    assertEquals(5, auto4x4.movimientos());
    Pozo.getInstance().resetContadorPozos();
  }

  @Test
  public void test08AutoAtraviesaCiudadIntentaAtravesarPiquiteNoPuede() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.obstaculos.put(Posicion.getPosicion(1, 0), Piquete.getInstance());
    Vehiculo auto = new Vehiculo(new Auto());
    // act & assert
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          grilla.avanzar(auto, 'd');
        });
    assertEquals(0, auto.movimientos());
  }

  @Test
  public void test09AutoAtraviesaCiudadYSeEncuentraConSorpresaFavorable() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.sorpresas.put(Posicion.getPosicion(5, 0), new SorpresaFavorable());
    Vehiculo auto = new Vehiculo(new Auto());
    // act
    for (int i = 0; i < 5; i++) {
      grilla.avanzar(auto, 'd');
    }
    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test10AutoAtraviesaCiudadYSeEncuentraConSorpresaDesfavorable() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.sorpresas.put(Posicion.getPosicion(5, 0), new SorpresaDesfavorable());
    Vehiculo auto = new Vehiculo(new Auto());
    // act
    for (int i = 0; i < 5; i++) {
      grilla.avanzar(auto, 'd');
    }
    // assert
    assertEquals(6, auto.movimientos());
  }

  @Test
  public void test11AutoPasaPorSorpresaCambioDeVehiculoCambiaA4x4YAlPasarPorPozoNoEsPenalizado() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.sorpresas.put(Posicion.getPosicion(1, 0), new SorpresaCambioVehiculo());
    grilla.obstaculos.put(Posicion.getPosicion(2, 0), Pozo.getInstance());
    grilla.obstaculos.put(Posicion.getPosicion(3, 0), Pozo.getInstance());
    Vehiculo auto = new Vehiculo(new Auto());
    // act
    grilla.avanzar(auto, 'd');
    grilla.avanzar(auto, 'd');
    grilla.avanzar(auto, 'd');
    // assert
    assertEquals(3, auto.movimientos());
  }

  @Test
  public void test12Auto4x4PasaPorSorpresaCambioDeVehiculoCambiaAMotoYAlPasarPorPozoEsPenalizado() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.sorpresas.put(Posicion.getPosicion(1, 0), new SorpresaCambioVehiculo());
    grilla.obstaculos.put(Posicion.getPosicion(2, 0), Pozo.getInstance());
    Vehiculo auto = new Vehiculo(new Auto4x4());
    // act
    grilla.avanzar(auto, 'd');
    grilla.avanzar(auto, 'd');
    // assert
    assertEquals(5, auto.movimientos());
    Pozo.getInstance().resetContadorPozos();
  }

  @Test
  public void
      test13MotoPasaPorSorpresaCambioDeVehiculoCambiaAAutoYAlPasarPorPozoNoPuedePasarPorPiquete() {
    // arrange
    Grilla grilla = new Grilla();
    grilla.sorpresas.put(Posicion.getPosicion(1, 0), new SorpresaCambioVehiculo());
    grilla.obstaculos.put(Posicion.getPosicion(2, 0), Piquete.getInstance());
    Vehiculo auto = new Vehiculo(new Moto());
    // act
    grilla.avanzar(auto, 'd');
    Assertions.assertThrows(
        RuntimeException.class,
        () -> {
          grilla.avanzar(auto, 'd');
        });
  }
}
