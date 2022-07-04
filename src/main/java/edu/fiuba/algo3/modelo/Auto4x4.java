package edu.fiuba.algo3.modelo;

public class Auto4x4 implements TipoVehiculo {
  private int contadorPozos;

  public Auto4x4() {
    this.contadorPozos = 0;
  }

  @Override
  public int pasarPor(Obstaculo visitor) {
    return visitor.visit(this);
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
