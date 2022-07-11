package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.Modelo.Sorpresas.SorpresaNula;
import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;
import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Moto;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {

  @Test
  public void test01VehiculoPasaPorVisitorNulo() {
    // arrange
    Vehiculo vehiculo = new Vehiculo(new Moto(),Posicion.getPosicion(1,1));
    // act
    vehiculo.pasarPor(new ObstaculoNulo());
    // assert
    assertEquals(0, vehiculo.movimientos());
  }

  @Test
  public void test02VehiculoPasaPorSorpresaNula() {
    // arrange
    Vehiculo vehiculo = new Vehiculo(new Moto(), Posicion.getPosicion(1,1));
    // act
    vehiculo.abrirSopresa(new SorpresaNula());
    // assert
    assertEquals(0, vehiculo.movimientos());
  }
}
