package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SorpresaTest {
  @Test
  public void test01SorpresaFavorableEsInvocadaYHaceQueVehiculoRecibaSorpresa() {
    // arrange
    Vehiculo vehiculoMock = mock(Vehiculo.class);
    SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
    // act
    sorpresaFavorable.activar(vehiculoMock);
    // assert
    verify(vehiculoMock).recibirSorpresa(0.8);
  }

  @Test
  public void test02SorpresaDesfavorableEsInvocadaYHaceQueVehiculoRecibaSorpresa() {
    // arrange
    Vehiculo vehiculoMock = mock(Vehiculo.class);
    SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
    // act
    sorpresaDesfavorable.activar(vehiculoMock);
    // assert
    verify(vehiculoMock).recibirSorpresa(1.25);
  }

  @Test
  public void test03SorpresaCambioDeVehiculoEsInvocadaYHaceQueVehiculoCambieDeVehiculo() {
    // arrange
    Vehiculo vehiculoMock = mock(Vehiculo.class);
    SorpresaCambioVehiculo sorpresa = new SorpresaCambioVehiculo();
    // act
    sorpresa.activar(vehiculoMock);
    // assert
    verify(vehiculoMock).cambiarTipo();
  }
}
