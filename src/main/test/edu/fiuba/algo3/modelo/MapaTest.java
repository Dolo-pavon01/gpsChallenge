package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapaTest {
  private final int LARGO = 10;
  private final int ANCHO = 10;

  @Test
  public void test01MotoSeMuevePorMapaPasaPorPozoEsPenalizado() {
    // arrange
    MapaFactory fabrica = new MapaFactory(LARGO, ANCHO);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(), Posicion.getPosicion(1, 0));
    Vehiculo moto = new Vehiculo(new Moto(), Posicion.getPosicion(0, 0));
    // act
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(4, moto.movimientos());
  }

  @Test
  public void test02MotoSeMueveEnMapaPasaPorPiqueteEsPenalizado() {
    // arrange
    MapaFactory fabrica = new MapaFactory(LARGO, ANCHO);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Piquete(), Posicion.getPosicion(1, 0));
    Vehiculo moto = new Vehiculo(new Moto(), Posicion.getPosicion(0, 0));
    // act
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(3, moto.movimientos());
  }

  @Test
  public void test03AutoSeMueveEnMapaPasaPorPozoEsPenalizado() {
    // arrange
    MapaFactory fabrica = new MapaFactory(LARGO, ANCHO);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(), Posicion.getPosicion(1, 0));
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(0, 0));
    // act
    mapa.avanzar(auto, 'd');
    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test04AutoSeMueveEnMapaPasaPorPiqueteNoPuedePasar() {
    // arrange
    MapaFactory fabrica = new MapaFactory(LARGO, ANCHO);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Piquete(), Posicion.getPosicion(1, 0));
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(0, 0));
    // act
    mapa.avanzar(auto, 'd');
    // assert
    assertEquals(0, auto.movimientos());
    assertEquals(Posicion.getPosicion(0, 0), auto.getPosicion());
  }

  @Test
  public void test05Auto4x4SeMueveEnMapaPasaPorPozoNoEsPenalizado() {
    // arrange
    MapaFactory fabrica = new MapaFactory(LARGO, ANCHO);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(), Posicion.getPosicion(1, 0));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(), Posicion.getPosicion(0, 0));
    // act
    mapa.avanzar(auto4x4, 'd');

    // assert
    assertEquals(1, auto4x4.movimientos());
  }

  @Test
  public void test06Auto4x4SeMueveEnMapaPasaPorPozo3VecesEsPenalizado() {
    // arrange
    MapaFactory fabrica = new MapaFactory(LARGO, ANCHO);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(), Posicion.getPosicion(1, 0));
    fabrica.agregar(new Pozo(), Posicion.getPosicion(2, 0));
    fabrica.agregar(new Pozo(), Posicion.getPosicion(3, 0));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(), Posicion.getPosicion(0, 0));
    // act
    for (int i = 0; i < 3; i++) {
      mapa.avanzar(auto4x4, 'd');
    }
    // assert
    assertEquals(5, auto4x4.movimientos());
  }

  @Test
  public void test07Auto4x4SeMueveEnMapaPasaPorPiqueteNoPuedePasar() {
    // arrange
    MapaFactory fabrica = new MapaFactory(LARGO, ANCHO);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Piquete(), Posicion.getPosicion(1, 0));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(), Posicion.getPosicion(0, 0));
    // act
    mapa.avanzar(auto4x4, 'd');
    // assert
    assertEquals(0, auto4x4.movimientos());
    assertEquals(Posicion.getPosicion(0, 0), auto4x4.getPosicion());
  }

  @Test
  public void test08SorpresaEnPosicionEsLaCorrecta() {
    // arrange
    SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
    SorpresaFavorable sorpresaEsperada = sorpresaFavorable;
    Posicion posicionSorpresa = Posicion.getPosicion(1, 0);
    MapaFactory fabrica = new MapaFactory(LARGO, ANCHO);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(sorpresaFavorable, posicionSorpresa);
    // act & assert
    assertEquals(sorpresaEsperada, mapa.sorpresaEnPosicion(Posicion.getPosicion(1, 0)));
  }

  @Test
  public void test09ObstaculoEnPosicionEsLaCorrecta() {
    // arrange
    IVisitor obstaculo = new Piquete();
    IVisitor obstaculoEsperado = obstaculo;
    Posicion posicionObstaculo = Posicion.getPosicion(1, 0);
    MapaFactory fabrica = new MapaFactory(LARGO, ANCHO);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(obstaculo, posicionObstaculo);
    // act & assert
    assertEquals(obstaculoEsperado, mapa.obstaculoEnPosicion(Posicion.getPosicion(1, 0)));
  }
}
