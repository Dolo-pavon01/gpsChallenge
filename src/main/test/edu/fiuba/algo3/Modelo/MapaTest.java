package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.mocks.BuilderMock;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MapaTest {
  @Test
  public void test01MotoSeMuevePorMapaPasaPorPozoEsPenalizado() {
    // arrange
    BuilderMock fabrica = new BuilderMock(10,10);
    fabrica.agregar(new Pozo(),Posicion.getPosicion(2,1));
    Mapa mapa = fabrica.getMapa();
    Vehiculo moto = new Vehiculo(new Moto(),Posicion.getPosicion(1,1));
    // act
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(4, moto.movimientos());
  }

  @Test
  public void test02MotoSeMueveEnMapaPasaPorPiqueteEsPenalizado() {
    // arrange
    BuilderMock fabrica = new BuilderMock(10,10);
    fabrica.agregar(new Piquete(),Posicion.getPosicion(2,1));
    Mapa mapa = fabrica.getMapa();
    Vehiculo moto = new Vehiculo(new Moto(),Posicion.getPosicion(1,1));
    // act
    mapa.avanzar(moto, 'd');
    // assert
    assertEquals(3, moto.movimientos());
  }

  @Test
  public void test03AutoSeMueveEnMapaPasaPorPozoEsPenalizado() {
    // arrange
    BuilderMock fabrica = new BuilderMock(10,10);
    fabrica.agregar(new Pozo(),Posicion.getPosicion(2,1));
    Mapa mapa = fabrica.getMapa();
    Vehiculo auto = new Vehiculo(new Auto(),Posicion.getPosicion(1,1));
    // act
    mapa.avanzar(auto, 'd');
    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test04AutoSeMueveEnMapaPasaPorPiqueteNoPuedePasar() {
    // arrange
    BuilderMock fabrica = new BuilderMock(10,10);
    fabrica.agregar(new Piquete(),Posicion.getPosicion(2,1));
    Mapa mapa = fabrica.getMapa();
    Vehiculo auto = new Vehiculo(new Auto(),Posicion.getPosicion(1,1));
    // act
    mapa.avanzar(auto, 'd');
    //assert
    assertEquals(0,auto.movimientos());
    assertEquals(Posicion.getPosicion(1,1),auto.getPosicion());
  }

  @Test
  public void test05Auto4x4SeMueveEnMapaPasaPorPozoNoEsPenalizado() {
    // arrange
    BuilderMock fabrica = new BuilderMock(10,10);
    fabrica.agregar(new Pozo(),Posicion.getPosicion(2,1));
    Mapa mapa = fabrica.getMapa();
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(1,1));
    // act
    mapa.avanzar(auto4x4, 'd');

    // assert
    assertEquals(1, auto4x4.movimientos());
  }

  @Test
  public void test06Auto4x4SeMueveEnMapaPasaPorPozo3VecesEsPenalizado() {
    // arrange
    BuilderMock fabrica = new BuilderMock(10,10);
    fabrica.agregar(new Pozo(),Posicion.getPosicion(2,1));
    fabrica.agregar(new Pozo(),Posicion.getPosicion(3,1));
    fabrica.agregar(new Pozo(),Posicion.getPosicion(4,1));
    Mapa mapa = fabrica.getMapa();
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(1,1));
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
    BuilderMock fabrica = new BuilderMock(10,10);
    fabrica.agregar(new Piquete(),Posicion.getPosicion(2,1));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(1,1));
    Mapa mapa = fabrica.getMapa();
    // act
    mapa.avanzar(auto4x4, 'd');
    //assert
    assertEquals(0,auto4x4.movimientos());
    assertEquals(Posicion.getPosicion(1,1),auto4x4.getPosicion());
  }

    @Test
    public void test08Auto4x4SeMueveEnMapaChocaParedDeDerechaYNoSeMueve() {
        // arrange
      BuilderMock fabrica = new BuilderMock(2,2);
      Mapa mapa = fabrica.getMapa();
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
    BuilderMock fabrica = new BuilderMock(2,2);
    Mapa mapa = fabrica.getMapa();
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(1,1));
    // act
    mapa.avanzar(auto4x4, 's');
    //assert
    assertEquals(0,auto4x4.movimientos());
    assertEquals(Posicion.getPosicion(1,1),auto4x4.getPosicion());
  }

  @Test
  public void test10Auto4x4SeMueveEnMapaPasaPorSorpresaFavorable() {
    // arrange
    BuilderMock fabrica = new BuilderMock(10,10);
    Mapa mapa = fabrica.getMapa();
    fabrica.agregar(new SorpresaFavorable(),Posicion.getPosicion(6,1));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(1,1));
    // act
    mapa.avanzar(auto4x4, 'd');
    mapa.avanzar(auto4x4, 'd');
    mapa.avanzar(auto4x4, 'd');
    mapa.avanzar(auto4x4, 'd');
    mapa.avanzar(auto4x4, 'd');
    //assert
    assertEquals(4,auto4x4.movimientos());
    assertEquals(Posicion.getPosicion(6,1),auto4x4.getPosicion());
  }
  @Test
  public void test11Auto4x4SeMueveEnMapaPasaPorSorpresaDesfavorable() {
    // arrange
    BuilderMock fabrica = new BuilderMock(10,10);
    Mapa mapa = fabrica.getMapa();
    fabrica.agregar(new SorpresaDesfavorable(),Posicion.getPosicion(6,1));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(1,1));
    // act
    mapa.avanzar(auto4x4, 'd');
    mapa.avanzar(auto4x4, 'd');
    mapa.avanzar(auto4x4, 'd');
    mapa.avanzar(auto4x4, 'd');
    mapa.avanzar(auto4x4, 'd');
    //assert
    assertEquals(6,auto4x4.movimientos());
    assertEquals(Posicion.getPosicion(6,1),auto4x4.getPosicion());
  }
  @Test
  public void test12Auto4x4SeMueveEnMapaPasaPorSorpresaCambioVehiculoYPiqueteNoPuedePasar() {
    // arrange
    BuilderMock fabrica = new BuilderMock(10,10);
    Mapa mapa = fabrica.getMapa();
    fabrica.agregar(new SorpresaCambioVehiculo(), Posicion.getPosicion(2,1));
    fabrica.agregar(new Piquete(),Posicion.getPosicion(3,1));
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(),Posicion.getPosicion(1,1));
    // act
    mapa.avanzar(auto4x4, 'd');
    mapa.avanzar(auto4x4, 'd');
    //assert
    assertEquals(4,auto4x4.movimientos());
    assertEquals(Posicion.getPosicion(3,1),auto4x4.getPosicion());
  }
}


