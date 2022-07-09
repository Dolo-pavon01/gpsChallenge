package edu.fiuba.algo3.Modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Descomentar y agregar nuevas pruebas para Gameplay
public class GameplayTest {
  @Test
  public void test01SeCreaUnaGrillaValida() {
    // arrange
    MapaBuilder builder = new MapaBuilder(10,10);
    builder.agregar(new Pozo(),Posicion.getPosicion(2,1));
    Gameplay gameplay = new Gameplay(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(),Posicion.getPosicion(1,1)));

    // act
    gameplay.jugar('d');

    // assert
    assertEquals(4, gameplay.puntaje());
  }

  @Test
  public void test02NoPuedeAvanzarSiHayPared() {
    // arrange
    MapaBuilder builder = new MapaBuilder(10,10);
    Gameplay gameplay = new Gameplay(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(),Posicion.getPosicion(1,1)));

    // act
    gameplay.jugar('a');
    gameplay.jugar('s');

    // assert
    assertEquals(0, gameplay.puntaje());
  }

  @Test
  public void test03NoPuedeAvanzarSiHayPared() {
    // arrange
    MapaBuilder builder = new MapaBuilder(10,10);
    Gameplay gameplay = new Gameplay(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(),Posicion.getPosicion(9,9)));

    // act
    gameplay.jugar('w');
    gameplay.jugar('d');

    // assert
    assertEquals(0, gameplay.puntaje());
  }

  @Test
  public void test04NoPuedeAvanzarSiHayPared()
  {
    // arrange
    MapaBuilder builder = new MapaBuilder(10,10);
    Gameplay gameplay = new Gameplay(builder);
    gameplay.iniciarJuego(new Vehiculo(new Auto(),Posicion.getPosicion(1,9)));

    // act
    gameplay.jugar('w');
    gameplay.jugar('a');

    // assert
    assertEquals(0, gameplay.puntaje());
  }


}
