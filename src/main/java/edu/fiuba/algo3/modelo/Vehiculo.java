package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {
  protected int posicion;
  protected int movimientos;

  public Vehiculo() {
    this.posicion = 0;
    this.movimientos = 0;
  }

  public int movimientos() {
    return this.movimientos;
  }

  public void mover() {
    this.posicion += 1;
    this.movimientos += 1;
  }

  public abstract void pasarPor(Obstaculo obstaculo);

  public abstract void serPenalizadoCon(int puntosPenalizacion);
}
