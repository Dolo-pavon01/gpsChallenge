package edu.fiuba.algo3.modelo;

public class Vehiculo {
  private TipoVehiculo tipo;
  private Posicion posicion;

  private int movimientos;

  public Vehiculo(TipoVehiculo tipoVehiculo) {
    this.tipo = tipoVehiculo;
    this.movimientos = 0;
    this.posicion = Posicion.getPosicion(0, 0);
  }

  public void pasarPor(IVisitor visitor) {
    this.movimientos += this.tipo.pasarPor(visitor);
  }

  public void abrirSopresa(Sorpresa sorpresa) {
    if (sorpresa == null) return;
    this.movimientos *= sorpresa.activar();
  }

  public void moverse(Posicion posicion) {
    this.movimientos += 1;
    this.posicion.trasladar(posicion);
  }

  Posicion getPosicion() {
    return this.posicion;
  }

  public int movimientos() {
    return this.movimientos;
  }
}
