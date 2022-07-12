package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Obstaculos.Piquetazo;
import edu.fiuba.algo3.Modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.Modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.Modelo.Sorpresas.SorpresaCambioVehiculo;
import edu.fiuba.algo3.Modelo.Vehiculo.*;
import edu.fiuba.algo3.Modelo.mocks.BuilderMock;
import edu.fiuba.algo3.Modelo.mocks.GameplayMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PiquetazoTest {
  @Test
  public void test01AutoPasaPorPiquetazoYNoPuedeAvanzar() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new Piquetazo(), Posicion.getPosicion(1, 5));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    Vehiculo auto = new Vehiculo(new Auto(), Posicion.getPosicion(0, 5));
    gameplay.iniciarJuego(auto);
    // act
    gameplay.jugar('d');
    // assert
    assertEquals(0, gameplay.puntaje());
    assertEquals(Posicion.getPosicion(0, 5), auto.getPosicion());
  }

  @Test
  public void test02MotoPasaPorPiquetazoYNoPuedeAvanzar() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new Piquetazo(), Posicion.getPosicion(1, 5));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    Vehiculo moto = new Vehiculo(new Moto(), Posicion.getPosicion(0, 5));
    gameplay.iniciarJuego(moto);
    // act
    gameplay.jugar('d');
    // assert
    assertEquals(0, gameplay.puntaje());
    assertEquals(Posicion.getPosicion(0, 5), moto.getPosicion());
  }

  @Test
  public void
      test03Auto4x4PasaPorPiquetazoPuedeAvanzarPasaPorSorpresaCambioDeVehiculoYPuedeRegresarYElObstaculoYaNoEsta() {
    // arrange
    BuilderMock builderMock = new BuilderMock(10, 10);
    builderMock.agregar(new Piquetazo(), Posicion.getPosicion(1, 5));
    builderMock.agregar(new SorpresaCambioVehiculo(), Posicion.getPosicion(2, 5));
    GameplayMock gameplay = GameplayMock.getInstance(builderMock);
    Vehiculo auto4x4 = new Vehiculo(new Auto4x4(), Posicion.getPosicion(0, 5));
    gameplay.iniciarJuego(auto4x4);
    // act
    gameplay.jugar('d');
    // assert
    assertEquals(1, gameplay.puntaje());
    assertEquals(Posicion.getPosicion(1, 5), auto4x4.getPosicion());

    gameplay.jugar('d');
    gameplay.jugar('a');

    // assert
    assertEquals(3, gameplay.puntaje());
    assertEquals(Posicion.getPosicion(1, 5), auto4x4.getPosicion());
  }
}
