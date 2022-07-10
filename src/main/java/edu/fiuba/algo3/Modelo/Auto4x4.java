package edu.fiuba.algo3.Modelo;

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
  public String getNombre() {
    return "Auto4x4";
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
