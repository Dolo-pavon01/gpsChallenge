package edu.fiuba.algo3.modelo;

public class Moto extends Vehiculo {

  public Moto() {
    super();
  }

  @Override
  public void pasarPor(Obstaculo obstaculo) {
    String nombreObstaculo = obstaculo.getNombre();
    if (nombreObstaculo.equals("pozo")) {
      this.movimientos += 3;
    }
    if (nombreObstaculo.equals("piquete")) {
      this.movimientos += 2;
    }
  }
}
