package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Obstaculos.ControlPolicial;
import edu.fiuba.algo3.Modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.Modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.Modelo.Sorpresas.SorpresaCambioVehiculo;
import edu.fiuba.algo3.Modelo.Sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.Modelo.Sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.Modelo.Vehiculo.Auto;
import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;
import edu.fiuba.algo3.Modelo.mocks.BuilderMock;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class GameplayTest {
  @Test
  public void test01SeCreaUnaGrillaValida() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new Pozo(), Posicion.getPosicion(2, 1));
    Gameplay gameplay = Gameplay.getInstance(builder);
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
    Gameplay gameplay = Gameplay.getInstance(builder);
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
    Gameplay gameplay = Gameplay.getInstance(builder);
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
    Gameplay gameplay = Gameplay.getInstance(builder);
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
    Gameplay gameplay = Gameplay.getInstance(builder);
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
    Gameplay gameplay = Gameplay.getInstance(builder);
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
    Gameplay gameplay = Gameplay.getInstance(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    gameplay.jugar('d');
    gameplay.jugar('d');

    // assert
    assertEquals(2, gameplay.puntaje());
  }

  @Test
  public void test08SeObtienePozoComoStringEnPosicion3_1() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new Pozo(), Posicion.getPosicion(3, 1));
    Gameplay gameplay = Gameplay.getInstance(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    List obtenido = gameplay.getObstaculos();

    // assert
    assertTrue(obtenido.contains("3;1;pozo"));
  }

  @Test
  public void test09SeObtienePiqueteComoStringEnPosicion8_5() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new Piquete(), Posicion.getPosicion(8, 5));
    Gameplay gameplay = Gameplay.getInstance(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    List obtenido = gameplay.getObstaculos();

    // assert
    assertTrue(obtenido.contains("8;5;piquete"));
  }

  @Test
  public void test10SeObtieneControlPolicialComoStringEnPosicion5_8() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new ControlPolicial(), Posicion.getPosicion(5, 8));
    Gameplay gameplay = Gameplay.getInstance(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    List obtenido = gameplay.getObstaculos();

    // assert
    assertTrue(obtenido.contains("5;8;controlPolicial"));
  }

  @Test
  public void test11SeObtieneSorpresaCambioDeVehiculoComoStringEnPosicion_2_1() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new SorpresaCambioVehiculo(), Posicion.getPosicion(2, 1));
    Gameplay gameplay = Gameplay.getInstance(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    List obtenido = gameplay.getSorpresas();

    // assert
    assertTrue(obtenido.contains("2;1;sorpresa"));
  }

  @Test
  public void test12SeObtieneSorpresaFavorableComoStringEnPosicion_3_2() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new SorpresaFavorable(), Posicion.getPosicion(3, 2));
    Gameplay gameplay = Gameplay.getInstance(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    List obtenido = gameplay.getSorpresas();

    // assert
    assertTrue(obtenido.contains("3;2;sorpresa"));
  }

  @Test
  public void test12SeObtieneSorpresaDesavorableComoStringEnPosicion_5_4() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    builder.agregar(new SorpresaDesfavorable(), Posicion.getPosicion(5, 4));
    Gameplay gameplay = Gameplay.getInstance(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    List obtenido = gameplay.getSorpresas();

    // assert
    assertTrue(obtenido.contains("5;4;sorpresa"));
  }

  @Test
  public void test13SeObtieneDatosDelVehiculo() {
    // arrange
    BuilderMock builder = new BuilderMock(10, 10);
    Gameplay gameplay = Gameplay.getInstance(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));

    // act
    String datos = gameplay.getVehiculo();

    // assert
    assertEquals("1;1;Auto", datos);
  }
}
