package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Obstaculos.ControlPolicial;
import edu.fiuba.algo3.Modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.Modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.Modelo.Sorpresas.SorpresaCambioVehiculo;
import edu.fiuba.algo3.Modelo.Sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.Modelo.Sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.Modelo.Vehiculo.*;
import edu.fiuba.algo3.Modelo.mocks.BuilderMock;
import edu.fiuba.algo3.Modelo.mocks.GameplayMock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameplayTest {
  @Test
  public void test01SeCreaUnaGrillaValida() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new Pozo(), Posicion.getPosicion(2, 1));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));
    // act
    gameplay.jugar('d');
    // assert
    assertEquals(4, gameplay.puntaje());
  }

  @Test
  public void test02NoPuedeAvanzarSiHayPared() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(0, 1));
    gameplay.iniciarJuego(auto);
    // act
    gameplay.jugar('a');
    gameplay.jugar('a');
    // assert
    assertEquals(0, gameplay.puntaje());
    assertEquals(Posicion.getPosicion(0, 1), auto.getPosicion());
  }

  @Test
  public void test03NoPuedeAvanzarSiHayPared() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(9, 10));
    gameplay.iniciarJuego(auto);
    // act
    gameplay.jugar('w');
    gameplay.jugar('w');
    // assert
    assertEquals(0, gameplay.puntaje());
    assertEquals(Posicion.getPosicion(9, 10), auto.getPosicion());
  }

  @Test
  public void test04NoPuedeAvanzarSiHayPared() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(0, 0));
    gameplay.iniciarJuego(auto);
    // act
    gameplay.jugar('s');
    gameplay.jugar('s');
    // assert
    assertEquals(0, gameplay.puntaje());
    assertEquals(Posicion.getPosicion(0, 0), auto.getPosicion());
  }

  @Test
  public void test05LLegaAMeta() {
    // arrange
    MapaBuilder builderMock = new BuilderMock(10, 10);
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(8, 5));
    gameplay.iniciarJuego(auto);
    // act
    gameplay.jugar('d');
    // assert
    assertEquals(Posicion.getPosicion(9, 5), auto.getPosicion());
    assertTrue(gameplay.llegoAMeta());
  }

  @Test
  public void test06LaPosicionDeMetaEsLaCorrecta() {
    // arrange
    MapaBuilder builderMock = new BuilderMock(10, 10);
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(8, 5));
    gameplay.iniciarJuego(auto);
    // act
    String meta = gameplay.getMeta();
    // assert
    assertEquals("9;5;meta", meta);
  }

  @Test
  public void test06ChocaParedPasePorUnPozoYLlegueAMeta() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new Pozo(), Posicion.getPosicion(9, 4));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
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
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new SorpresaCambioVehiculo(), Posicion.getPosicion(2, 1));
    builderMock.agregar(new Pozo(), Posicion.getPosicion(3, 1));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
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
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new Pozo(), Posicion.getPosicion(3, 1));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));
    // act
    List obtenido = gameplay.getObstaculos();
    // assert
    assertTrue(obtenido.contains("3;1;pozo"));
  }

  @Test
  public void test09SeObtienePiqueteComoStringEnPosicion8_5() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new Piquete(), Posicion.getPosicion(8, 5));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));
    // act
    List obtenido = gameplay.getObstaculos();
    // assert
    assertTrue(obtenido.contains("8;5;piquete"));
  }

  @Test
  public void test10SeObtieneControlPolicialComoStringEnPosicion5_8() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new ControlPolicial(), Posicion.getPosicion(5, 8));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));
    // act
    List obtenido = gameplay.getObstaculos();
    // assert
    assertTrue(obtenido.contains("5;8;controlPolicial"));
  }

  @Test
  public void test11SeObtieneSorpresaCambioDeVehiculoComoStringEnPosicion_2_1() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new SorpresaCambioVehiculo(), Posicion.getPosicion(2, 1));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));
    // act
    List obtenido = gameplay.getSorpresas();
    // assert
    assertTrue(obtenido.contains("2;1;sorpresa"));
  }

  @Test
  public void test12SeObtieneSorpresaFavorableComoStringEnPosicion_3_2() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new SorpresaFavorable(), Posicion.getPosicion(3, 2));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));
    // act
    List obtenido = gameplay.getSorpresas();
    // assert
    assertTrue(obtenido.contains("3;2;sorpresa"));
  }

  @Test
  public void test12SeObtieneSorpresaDesavorableComoStringEnPosicion_5_4() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new SorpresaDesfavorable(), Posicion.getPosicion(5, 4));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));
    // act
    List obtenido = gameplay.getSorpresas();
    // assert
    assertTrue(obtenido.contains("5;4;sorpresa"));
  }

  @Test
  public void test13SeObtieneDatosDelVehiculoQueEsTipoAuto() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    gameplay.iniciarJuego(new Vehiculo(new Auto(), Posicion.getPosicion(1, 1)));
    // act
    String datos = gameplay.getVehiculo();
    // assert
    assertEquals("1;1;Auto", datos);
  }

  @Test
  public void test14SeObtieneDatosDelVehiculoQueEsTipoMoto() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    gameplay.iniciarJuego(new Vehiculo(new Moto(), Posicion.getPosicion(1, 1)));
    // act
    String datos = gameplay.getVehiculo();
    // assert
    assertEquals("1;1;Moto", datos);
  }

  @Test
  public void test15SeObtieneDatosDelVehiculoQueEsTipoAuto4x4() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    gameplay.iniciarJuego(new Vehiculo(new Auto4x4(), Posicion.getPosicion(1, 1)));
    // act
    String datos = gameplay.getVehiculo();
    // assert
    assertEquals("1;1;Auto4x4", datos);
  }

  @Test
  public void test16SeRegistraUsuarioConAuto() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    String tipoVehiculo = "Auto";
    String nombreJugador = "jugador";
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    // act
    gameplay.registrarUsuario(nombreJugador, tipoVehiculo);
    String posicionVehiculo = gameplay.getVehiculo();
    // assert
    assertTrue(posicionVehiculo.contains(tipoVehiculo));
  }

  @Test
  public void test17SeRegistraUsuarioConMoto() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    String tipoVehiculo = "Moto";
    String nombreJugador = "jugador";
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    // act
    gameplay.registrarUsuario(nombreJugador, tipoVehiculo);
    String posicionVehiculo = gameplay.getVehiculo();
    // assert
    assertTrue(posicionVehiculo.contains(tipoVehiculo));
  }

  @Test
  public void test18SeRegistraUsuarioConAuto4x4() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    String tipoVehiculo = "Auto4x4";
    String nombreJugador = "jugador";
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    // act
    gameplay.registrarUsuario(nombreJugador, tipoVehiculo);
    String posicionVehiculo = gameplay.getVehiculo();
    // assert
    assertTrue(posicionVehiculo.contains(tipoVehiculo));
  }

  @Test
  public void test19SeRegistraUsuarioConAuto4x4() {
    // arrange
    String tipoVehiculo = "Auto4x4";
    String nombreJugador = "jugador";
    String posicionEsperada = "0;5";
    BuilderMock builderMock = new BuilderMock(10, 10);
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    // act
    gameplay.registrarUsuario(nombreJugador, tipoVehiculo);
    String posicionJugador = gameplay.posicionJugador();
    // assert
    assertEquals(posicionEsperada, posicionJugador);
  }

  @Test
  public void test20SeCreaUnMapaValidoConSorpresas() {
    // act
    ArrayList<String> listaSorpresas = Gameplay.getInstance().getSorpresas();
    // assert
    assertFalse(listaSorpresas.isEmpty());
  }

  @Test
  public void test21SeCreaUnMapaValidoConObstaculos() {
    // act
    ArrayList<String> listaObstaculos = Gameplay.getInstance().getObstaculos();
    // assert
    assertFalse(listaObstaculos.isEmpty());
  }


}
