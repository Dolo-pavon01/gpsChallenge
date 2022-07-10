package edu.fiuba.algo3.Modelo.Vehiculo;

import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;

public class Auto4x4 implements TipoVehiculo {
  private int contadorPozos;
  private final String NOMBRE = "Auto4x4";

  public Auto4x4() {
    this.contadorPozos = 0;
  }

  @Override
  public int pasarPor(Obstaculo visitor) {
    return visitor.visit(this);
  }

  @Override
  public String getNombre() {
    return NOMBRE;
  }

  @Override
  public String obtenerNombreEnPosicion(Posicion posicion) {
    return posicion.posicionAString() + ";" + NOMBRE;
  }

  @Override
  public TipoVehiculo cambiarTipo() {
    return new Moto();
  }

  public void recibirImpacto() {
    this.contadorPozos += 1;
  }

  public void reiniciarImpactosRecibidos() {
    this.contadorPozos = 0;
  }

  public boolean esPenalizado(int limitePozosAtravesados) {
    return this.contadorPozos > limitePozosAtravesados;
  }
}
