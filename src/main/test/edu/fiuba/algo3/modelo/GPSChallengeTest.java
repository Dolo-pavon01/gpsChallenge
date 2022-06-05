package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GPSChallengeTest {

  /*
      * Gameplay solo conoce al usuario
      * Caso de uso 1
  - Una moto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada
  en tres movimientos.
  Supuestos a tener en cuenta:
  -Pozos: Le suma 3 movimientos de penalización a autos y motos. Para una 4x4 penaliza en 2
  movimientos luego de atravesar 3 pozos.

  Caso de uso 2
  - Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en
  tres movimientos.
  Supuestas a tener en cuenta:
  -Pozos: Le suma 3 movimientos de penalización a autos y motos. Para una 4x4 penaliza en 2
  movimientos luego de atravesar 3 pozos.

  Caso de uso 3
  - Una 4x4 atraviesa la ciudad y se encuentra con un Pozo. No es
  penalizada.
  -Pozos: Le suma 3 movimientos de penalización a autos y motos. Para una 4x4 penaliza en 2
  movimientos luego de atravesar 3 pozos.

  Caso de uso 4
  - A cargo del equipo.

  Caso de uso 5
  - A cargo del equipo.

  Piquete: Autos y 4x4 deben pegar la vuelta, no pueden pasar. Las motos pueden pasar con una
  penalización de 2 movimientos.
  ● Control Policial: Para todos los vehículos la penalización es de 3 movimientos, sin embargo la
  probabilidad de que el vehículo quede demorado por el control y sea penalizado es de 0,3 para las
  4x4, 0,5 para los autos y 0,8 para las motos ya que nunca llevan el casco puesto.
      * */

  @Test
  public void test01MotoAtraviesaCiudadDeUnaCuadraAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    List obstaculos = new ArrayList<Pozo>();
    obstaculos.add(new Pozo(1));

    Grilla grilla = new Grilla(new Pozo(1));
    Moto moto = new Moto();

    // act
    grilla.avanzar(moto, "D");

    // assert
    assertEquals(4, moto.movimientos());
  }

  @Test
  public void
      test02AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    List obstaculos = new ArrayList<Pozo>();
    obstaculos.add(new Pozo(1));

    Grilla grilla = new Grilla(new Pozo(1));
    Auto auto = new Auto();

    // act
    grilla.avanzar(auto, "D");

    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test034x4AtraviesaLaCiudadYSeEncuentraConUnPozoNoEsPenalizada() {
    // arrange
    List obstaculos = new ArrayList<Pozo>();
    obstaculos.add(new Pozo(1));

    Grilla grilla = new Grilla(new Pozo(1));
    Auto4x4 auto4x4 = new Auto4x4();

    // act
    grilla.avanzar(auto4x4, "D");

    // assert
    assertEquals(1, auto4x4.movimientos());
  }

  @Test
  public void test04MotoAtraviesaCiudadSeEncuentraCon2PozosYEsPenalizada() {
    // arrange
    List obstaculos = new ArrayList<Pozo>();
    obstaculos.add(new Pozo(1));
    obstaculos.add(new Pozo(2));

    Grilla grilla = new Grilla(obstaculos);
    Moto moto = new Moto();

    // act
    grilla.avanzar(moto, "D");
    grilla.avanzar(moto, "D");

    // assert
    assertEquals(8, moto.movimientos());
  }

  @Test
  public void test05MotoAtraviesaCiudadAtraviesaPiquete() {
    // arrange
    List obstaculos = new ArrayList<>();
    obstaculos.add(new Piquete(1));

    Grilla grilla = new Grilla(obstaculos);
    Moto moto = new Moto();

    // act
    grilla.avanzar(moto, "D");

    // assert
    assertEquals(3, moto.movimientos());
  }

  @Test
  public void
      test06AutoAtraviesaCiudadConUnMovimientoAtraviesaPozoYTiene3MovimientosDePenalizacion() {
    // arrange
    List obstaculos = new ArrayList<Pozo>();
    obstaculos.add(new Pozo(1));

    Grilla grilla = new Grilla(new Pozo(1));
    Auto auto = new Auto();

    // act
    grilla.avanzar(auto, "D");

    // assert
    assertEquals(4, auto.movimientos());
  }

  @Test
  public void test074x4AtraviesaLaCiudadYSeEncuentraCon3PozosYEsPenalizada() {
    // arrange
    List obstaculos = new ArrayList<Obstaculo>();
    obstaculos.add(new Pozo(1));
    obstaculos.add(new Pozo(2));
    obstaculos.add(new Pozo(3));

    Grilla grilla = new Grilla(obstaculos);
    Auto4x4 auto4x4 = new Auto4x4();

    // act
    grilla.avanzar(auto4x4, "D");
    grilla.avanzar(auto4x4, "D");
    grilla.avanzar(auto4x4, "D");

    // assert
    assertEquals(5, auto4x4.movimientos());
  }
}
