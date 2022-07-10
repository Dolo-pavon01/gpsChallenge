package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.Modelo.Sorpresas.SorpresaCambioVehiculo;
import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;
import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto4x4;
import edu.fiuba.algo3.Modelo.Vehiculo.Moto;
import edu.fiuba.algo3.Modelo.mocks.BuilderMock;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: Descomentar y agregar nuevas pruebas para Gameplay
public class GameplayTest {
  @Test
  public void test01SeCreaUnaGrillaValida() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new Pozo(), Posicion.getPosicion(2, 1));
    Gameplay gameplay = new Gameplay(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    gameplay.jugar('d');

    // assert
    assertEquals(4, gameplay.puntaje());
  }

  @Test
  public void test02NoPuedeAvanzarSiHayPared() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    Gameplay gameplay = new Gameplay(builder);
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(1, 1));
    gameplay.iniciarJuego(auto);

    // act
    gameplay.jugar('a');
    gameplay.jugar('s');

    // assert
    assertEquals(0, gameplay.puntaje());
    assertEquals(Posicion.getPosicion(1, 1), auto.getPosicion());
  }

  @Test
  public void test03NoPuedeAvanzarSiHayPared() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    Gameplay gameplay = new Gameplay(builder);
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(9, 9));
    gameplay.iniciarJuego(auto);

    // act
    gameplay.jugar('w');
    gameplay.jugar('d');

    // assert
    assertEquals(0, gameplay.puntaje());
    assertEquals(Posicion.getPosicion(9, 9), auto.getPosicion());
  }

  @Test
  public void test04NoPuedeAvanzarSiHayPared() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    Gameplay gameplay = new Gameplay(builder);
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(1, 9));
    gameplay.iniciarJuego(auto);

    // act
    gameplay.jugar('w');
    gameplay.jugar('a');

    // assert
    assertEquals(0, gameplay.puntaje());
    assertEquals(Posicion.getPosicion(1, 9), auto.getPosicion());
  }

  @Test
  public void test05LLegaAMeta() {
    // arrange
    MapaBuilder builder = new BuilderMock(10, 10);
    Gameplay gameplay = new Gameplay(builder);
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(8, 5));
    gameplay.iniciarJuego(auto);

    // act
    gameplay.jugar('d');
    // assert
    assertEquals(Posicion.getPosicion(9, 5), auto.getPosicion());
    assertTrue(gameplay.llegoAMeta());
  }

  @Test
  public void test06ChocaParedPasePorUnPozoYLlegueAMeta() {
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new Pozo(), Posicion.getPosicion(9, 4));
    Gameplay gameplay = new Gameplay(builder);
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(9, 3));
    gameplay.iniciarJuego(auto);

    // act
    gameplay.jugar('d');
    gameplay.jugar('w');
    gameplay.jugar('w');

    // assert
    assertEquals(5, gameplay.puntaje());
    assertEquals(Posicion.getPosicion(9, 5), auto.getPosicion());
    assertTrue(gameplay.llegoAMeta());
  }

  @Test
  public void test07PasaPorSorpresaCambioVehiculo() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new SorpresaCambioVehiculo(), Posicion.getPosicion(2, 1));
    builder.agregar(new Pozo(), Posicion.getPosicion(3, 1));
    Gameplay gameplay = new Gameplay(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    gameplay.jugar('d');
    gameplay.jugar('d');

    // assert
    assertEquals(2, gameplay.puntaje());
  }

  @Test
  public void test08SeObtieneObstaculoComoString() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new Pozo(), Posicion.getPosicion(3, 1));
    Gameplay gameplay = new Gameplay(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    HashMap obtenido = gameplay.getObstaculos();

    // assert
    assertTrue(obtenido.containsKey("3;1"));
    assertEquals("pozo", obtenido.get("3;1"));
  }

  // TODO: Cambiar lo que devuelve gameplay.sorpresas() (y el resto) para que
  // en lugar de devolver un HashMap devuelva un Array
  @Test
  public void test09SeObtieneSorpresaComoString() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new SorpresaCambioVehiculo(), Posicion.getPosicion(2, 1));
    Gameplay gameplay = new Gameplay(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    HashMap obtenido = gameplay.getSorpresas();

    // assert
    assertTrue(obtenido.containsKey("2;1"));
    assertEquals("sorpresa", obtenido.get("2;1"));
  }

  @Test
  public void test10SeObtieneDatosDelVehiculo() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    Gameplay gameplay = new Gameplay(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    String datos = gameplay.getVehiculo();

    // assert

    assertEquals("1;1;Auto", datos);
  }
}
