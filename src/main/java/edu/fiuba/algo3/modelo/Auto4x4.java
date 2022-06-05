package edu.fiuba.algo3.modelo;

public class Auto4x4 extends Vehiculo {
  private int contadorPozos;

  public Auto4x4() {
    super();
    this.contadorPozos = 0;
  }

  @Override
  public void pasarPor(Obstaculo obstaculo) {
    if (this.contadorPozos < 2) {
      this.contadorPozos += 1;
    } else {
      this.movimientos += 2;
      this.contadorPozos = 0;
    }
  }
}
