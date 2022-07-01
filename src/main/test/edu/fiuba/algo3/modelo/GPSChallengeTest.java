package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GPSChallengeTest {

  @Test
  public void test01MotoAtraviesaCiudadDeUnaCuadraAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    MapaFactory fabrica = new MapaFactory(10,10);

    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(),Posicion.getPosicion(1,0));

    Vehiculo moto = new Vehiculo(new Moto(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(4, moto.movimientos());
  }

  @Test
  public void
      test02AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {

    // arrange
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(),Posicion.getPosicion(1,0));
    Vehiculo auto = new Vehiculo(new Auto(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(auto, 'd');
    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test03Auto4x4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada() {
    // arrange
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(),Posicion.getPosicion(1,0));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(auto4x4, 'd');
    // assert
    assertEquals(1, auto4x4.movimientos());
  }

  @Test
  public void test04MotoAtraviesaCiudadSeEncuentraCon2PozosYEsPenalizada() {
    // arrange
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(),Posicion.getPosicion(1,0));
    fabrica.agregar(new Pozo(),Posicion.getPosicion(2,0));
    Vehiculo moto = new Vehiculo(new Moto(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(moto, 'd');
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(8, moto.movimientos());
  }

  @Test
  public void test05MotoAtraviesaCiudadAtraviesaPiquete() {
    // arrange
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Piquete(),Posicion.getPosicion(1,0));
    Vehiculo moto = new Vehiculo(new Moto(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(3, moto.movimientos());
  }

  @Test
  public void
      test06AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(),Posicion.getPosicion(1,0));
    Vehiculo auto = new Vehiculo(new Auto(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(auto, 'd');
    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test07Auto4x4AtraviesaLaCiudadYSeEncuentraCon3PozosYEsPenalizada() {
    // arrange
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(),Posicion.getPosicion(1,0));
    fabrica.agregar(new Pozo(),Posicion.getPosicion(2,0));
    fabrica.agregar(new Pozo(),Posicion.getPosicion(3,0));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(0,0));
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
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Piquete(),Posicion.getPosicion(1,0));
    Vehiculo auto = new Vehiculo(new Auto(),Posicion.getPosicion(0,0));
    // act & assert

    mapa.avanzar(auto, 'd');
    assertEquals(0, auto.movimientos());
  }

  @Test
  public void test09AutoAtraviesaCiudadYSeEncuentraConSorpresaFavorable() {
    // arrange
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new SorpresaFavorable(),Posicion.getPosicion(5,0));
    Vehiculo auto = new Vehiculo(new Auto(),Posicion.getPosicion(0,0));
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
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new SorpresaDesfavorable(),Posicion.getPosicion(5,0));
    Vehiculo auto = new Vehiculo(new Auto(),Posicion.getPosicion(0,0));
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
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new SorpresaCambioVehiculo(),Posicion.getPosicion(1,0));
    fabrica.agregar(new Pozo(),Posicion.getPosicion(2,0));
    Vehiculo auto = new Vehiculo(new Auto(),Posicion.getPosicion(0,0));
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
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new SorpresaCambioVehiculo(),Posicion.getPosicion(1,0));
    fabrica.agregar(new Pozo(),Posicion.getPosicion(2,0));
    Vehiculo auto = new Vehiculo(new Auto4x4(),Posicion.getPosicion(0,0));
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
    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new SorpresaCambioVehiculo(),Posicion.getPosicion(1,0));
    fabrica.agregar(new Piquete(),Posicion.getPosicion(2,0));
    Vehiculo moto = new Vehiculo(new Moto(),Posicion.getPosicion(0,0));
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

    MapaFactory fabrica = new MapaFactory(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new ControlPolicial(),Posicion.getPosicion(1,0));
    Vehiculo moto = new Vehiculo(tipoMoto,Posicion.getPosicion(0,0));
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
