package edu.fiuba.algo3.Modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {

  @Test
  public void test01VehiculoPasaPorVisitorNulo() {
    // arrange
    Vehiculo vehiculo = new Vehiculo(new Moto());
    // act
    vehiculo.pasarPor(null);
    // assert
    assertEquals(0, vehiculo.movimientos());
  }

  @Test
  public void test02VehiculoPasaPorSorpresaNula() {
    // arrange
    Vehiculo vehiculo = new Vehiculo(new Moto());
    // act
    vehiculo.abrirSopresa(null);
    // assert
    assertEquals(0, vehiculo.movimientos());
  }
}
