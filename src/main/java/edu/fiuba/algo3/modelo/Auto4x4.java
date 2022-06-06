package edu.fiuba.algo3.modelo;

public class Auto4x4 extends Vehiculo {
  private int contadorPozos;
  private static final int LIMITE_POZOS_ATRAVESADOS = 2;

  public Auto4x4() {
    super();
    this.contadorPozos = 0;
  }

  @Override
  public void pasarPor(Obstaculo obstaculo) {
    if (!obstaculo.tieneMismaPosicion(posicion)) {
      return;
    }
    if (this.contadorPozos < LIMITE_POZOS_ATRAVESADOS) {
      this.contadorPozos += 1;
    } else {
      obstaculo.penalizar(this);
      this.contadorPozos = 0;
    }
  }

  @Override
  public void serPenalizadoCon(int puntosPenalizacion) {
    this.movimientos += puntosPenalizacion;
  }
}
