package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GPSChallengeTest {

  @Test
  public void test01MotoAtraviesaCiudadDeUnaCuadraAtraviesaPozoYTiene3MovimientosDePenalizacion() {
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
  public void
      test02AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {

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
  public void test03Auto4x4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4());
    // act
    mapa.avanzar(auto4x4, 'd');
    // assert
    assertEquals(1, auto4x4.movimientos());
  }

  @Test
  public void test04MotoAtraviesaCiudadSeEncuentraCon2PozosYEsPenalizada() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    mapa.obstaculos.put(Posicion.getPosicion(2, 0), new Pozo());
    Vehiculo moto = new Vehiculo(new Moto());
    // act
    mapa.avanzar(moto, 'd');
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(8, moto.movimientos());
  }

  @Test
  public void test05MotoAtraviesaCiudadAtraviesaPiquete() {
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
  public void
      test06AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {
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
  public void test07Auto4x4AtraviesaLaCiudadYSeEncuentraCon3PozosYEsPenalizada() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), new Pozo());
    mapa.obstaculos.put(Posicion.getPosicion(2, 0), new Pozo());
    mapa.obstaculos.put(Posicion.getPosicion(3, 0), new Pozo());
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4());
    // act
    mapa.avanzar(auto4x4, 'd');
    mapa.avanzar(auto4x4, 'd');
    mapa.avanzar(auto4x4, 'd');
    // assert
    assertEquals(5, auto4x4.movimientos());
  }

  @Test
  public void test08AutoAtraviesaCiudadIntentaAtravesarPiquiteNoPuede() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), new Piquete());
    Vehiculo auto = new Vehiculo(new Auto());
    // act & assert

    mapa.avanzar(auto, 'd');
    assertEquals(0, auto.movimientos());
  }

  @Test
  public void test09AutoAtraviesaCiudadYSeEncuentraConSorpresaFavorable() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.sorpresas.put(Posicion.getPosicion(5, 0), new SorpresaFavorable());
    Vehiculo auto = new Vehiculo(new Auto());
    // act
    for (int i = 0; i < 5; i++) {
      mapa.avanzar(auto, 'd');
    }
    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test10AutoAtraviesaCiudadYSeEncuentraConSorpresaDesfavorable() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.sorpresas.put(Posicion.getPosicion(5, 0), new SorpresaDesfavorable());
    Vehiculo auto = new Vehiculo(new Auto());
    // act
    for (int i = 0; i < 5; i++) {
      mapa.avanzar(auto, 'd');
    }
    // assert
    assertEquals(6, auto.movimientos());
  }

  @Test
  public void test11AutoPasaPorSorpresaCambioDeVehiculoCambiaA4x4YAlPasarPorPozoNoEsPenalizado() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.sorpresas.put(Posicion.getPosicion(1, 0), new SorpresaCambioVehiculo());
    mapa.obstaculos.put(Posicion.getPosicion(2, 0), new Pozo());
    mapa.obstaculos.put(Posicion.getPosicion(3, 0), new Pozo());
    Vehiculo auto = new Vehiculo(new Auto());
    // act
    mapa.avanzar(auto, 'd');
    mapa.avanzar(auto, 'd');
    mapa.avanzar(auto, 'd');
    // assert
    assertEquals(3, auto.movimientos());
  }

  @Test
  public void test12Auto4x4PasaPorSorpresaCambioDeVehiculoCambiaAMotoYAlPasarPorPozoEsPenalizado() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.sorpresas.put(Posicion.getPosicion(1, 0), new SorpresaCambioVehiculo());
    mapa.obstaculos.put(Posicion.getPosicion(2, 0), new Pozo());
    Vehiculo auto = new Vehiculo(new Auto4x4());
    // act
    mapa.avanzar(auto, 'd');
    mapa.avanzar(auto, 'd');
    // assert
    assertEquals(5, auto.movimientos());
  }

  @Test
  public void
      test13MotoPasaPorSorpresaCambioDeVehiculoCambiaAAutoYAlPasarPorPozoNoPuedePasarPorPiquete() {
    // arrange
    Mapa mapa = new Mapa();
    mapa.sorpresas.put(Posicion.getPosicion(1, 0), new SorpresaCambioVehiculo());
    mapa.obstaculos.put(Posicion.getPosicion(2, 0), new Piquete());
    Vehiculo moto = new Vehiculo(new Moto());
    // act
    mapa.avanzar(moto, 'd');
    mapa.avanzar(moto, 'd');

    // assert

    assertEquals(1, moto.movimientos());
  }

  @Test
  public void test14MotoPasaPorControlYEsMultadoPorLaYuta() {
    // arrange
    Moto tipoMoto = new Moto();
    IVisitor controlMock = mock(IVisitor.class);
    when(controlMock.visit(tipoMoto)).thenReturn(3);

    Mapa mapa = new Mapa();
    mapa.obstaculos.put(Posicion.getPosicion(1, 0), controlMock);
    Vehiculo moto = new Vehiculo(tipoMoto);
    // act
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(4, moto.movimientos());
  }

  /*
   @Test
   public void test14AutoPasaPorControlYEsMultadoPorLaYuta() {
     // arrange
     ControlPolicial controlMock = mock(ControlPolicial.class);
     Auto tipoAuto = new Auto();
     when(controlMock.visit(tipoAuto)).thenReturn(3);
     Mapa mapa = new Mapa();
     mapa.obstaculos.put(Posicion.getPosicion(1, 0), controlMock);
     Vehiculo auto = new Vehiculo(tipoAuto);
     // act
     mapa.avanzar(auto, 'd');
     // assert
     assertEquals(4, auto.movimientos());
   }

  */
}
