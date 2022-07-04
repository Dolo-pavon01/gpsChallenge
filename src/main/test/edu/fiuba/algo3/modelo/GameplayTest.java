package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameplayTest {
  private final int LARGO = 10;
  private final int ANCHO = 10;

  @Test
  public void test01SeCreaJuegoConMapa() {
    // arrange
    MapaFactory mapaFactory = new MapaFactory(LARGO, ANCHO);
    Gameplay gameplay = new Gameplay(mapaFactory);
    // act
    Mapa mapa = gameplay.iniciarJuego(new Vehiculo(new Auto()));
    // assert
    assertEquals(mapa, gameplay.getMapa());
  }
  // TODO: Bastante preocupante que todos los metodos de factory devuelvan mapa. Parece que se pisan
  // al crear gameplay
  // TODO: En caso de no llegar a resolver todo el modelo, hacer mock de MapaFactory
  /*
   @Test
   public void test02SeCreaJuegoConObstaculoPozoYVehiculoPasaEsPenalizado() {
     // arrange
     MapaFactory mapaFactory = new MapaFactory(LARGO, ANCHO);
     mapaFactory.agregar(new Pozo(), Posicion.getPosicion(6, 1));
     Gameplay gameplay = new Gameplay(mapaFactory);
     Vehiculo vehiculoMoto = new Vehiculo(new Moto());
     // act
     gameplay.iniciarJuego(vehiculoMoto);
     gameplay.jugar('d');
     // assert
     assertEquals(4, vehiculoMoto.movimientos());
   }
  */
}
