package edu.fiuba.algo3.Modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MapaTest {
  @Test
  public void test01MotoSeMuevePorMapaPasaPorPozoEsPenalizado() {
    // arrange
    MapaBuilder fabrica = new MapaBuilder(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(),Posicion.getPosicion(1,0));
    Vehiculo moto = new Vehiculo(new Moto(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(4, moto.movimientos());
  }

  @Test
  public void test02MotoSeMueveEnMapaPasaPorPiqueteEsPenalizado() {
    // arrange
    MapaBuilder fabrica = new MapaBuilder(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Piquete(),Posicion.getPosicion(1,0));
    Vehiculo moto = new Vehiculo(new Moto(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(3, moto.movimientos());
  }

  @Test
  public void test03AutoSeMueveEnMapaPasaPorPozoEsPenalizado() {
    // arrange
    MapaBuilder fabrica = new MapaBuilder(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(),Posicion.getPosicion(1,0));
    Vehiculo auto = new Vehiculo(new Auto(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(auto, 'd');
    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test04AutoSeMueveEnMapaPasaPorPiqueteNoPuedePasar() {
    // arrange
    MapaBuilder fabrica = new MapaBuilder(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Piquete(),Posicion.getPosicion(1,0));
    Vehiculo auto = new Vehiculo(new Auto(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(auto, 'd');
    //assert
    assertEquals(0,auto.movimientos());
    assertEquals(Posicion.getPosicion(0,0),auto.getPosicion());
  }

  @Test
  public void test05Auto4x4SeMueveEnMapaPasaPorPozoNoEsPenalizado() {
    // arrange
    MapaBuilder fabrica = new MapaBuilder(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(),Posicion.getPosicion(1,0));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(auto4x4, 'd');

    // assert
    assertEquals(1, auto4x4.movimientos());
  }

  @Test
  public void test06Auto4x4SeMueveEnMapaPasaPorPozo3VecesEsPenalizado() {
    // arrange
    MapaBuilder fabrica = new MapaBuilder(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Pozo(),Posicion.getPosicion(1,0));
    fabrica.agregar(new Pozo(),Posicion.getPosicion(2,0));
    fabrica.agregar(new Pozo(),Posicion.getPosicion(3,0));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(0,0));
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
    MapaBuilder fabrica = new MapaBuilder(10,10);
    Mapa mapa = fabrica.crearMapa();
    fabrica.agregar(new Piquete(),Posicion.getPosicion(1,0));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(0,0));
    // act
    mapa.avanzar(auto4x4, 'd');
    //assert
    assertEquals(0,auto4x4.movimientos());
    assertEquals(Posicion.getPosicion(0,0),auto4x4.getPosicion());
  }

    @Test
    public void test08Auto4x4SeMueveEnMapaChocaParedDeDerechaYNoSeMueve() {
        // arrange
        MapaBuilder fabrica = new MapaBuilder(2,2);
        Mapa mapa = fabrica.crearMapa();
        Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(1,1));
        // act
        mapa.avanzar(auto4x4, 'd');
        //assert
        assertEquals(0,auto4x4.movimientos());
        assertEquals(Posicion.getPosicion(1,1),auto4x4.getPosicion());
    }

  @Test
  public void test09Auto4x4SeMueveEnMapaChocaParedDeAbajoYNoSeMueve() {
    // arrange
    MapaBuilder fabrica = new MapaBuilder(2,2);
    Mapa mapa = fabrica.crearMapa();
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(1,1));
    // act
    mapa.avanzar(auto4x4, 's');
    //assert
    assertEquals(0,auto4x4.movimientos());
    assertEquals(Posicion.getPosicion(1,1),auto4x4.getPosicion());
  }
}


