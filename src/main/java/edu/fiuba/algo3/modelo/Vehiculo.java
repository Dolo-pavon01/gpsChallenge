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
    if (visitor == null)
      throw new ObstaculoEsNulo();
    this.movimientos += this.tipo.pasarPor(visitor);
  }

  public void abrirSopresa(Sorpresa sorpresa) {
    if (sorpresa == null)
      throw new SorpresaEsNula();
    sorpresa.activar(this);
  }

  public void moverse(Posicion posicion) {
    this.movimientos += 1;
    this.posicion = this.posicion.trasladar(posicion);
  }

  Posicion getPosicionSiguiente(char unaDireccion) {
    return this.posicion.siguiente(unaDireccion);
  }

  public int movimientos() {
    return this.movimientos;
  }

  public void cambiarTipo() {
    this.tipo = this.tipo.cambiarTipo();
  }

  public void recibirSorpresa(double valorSorpresa) {
    this.movimientos *= valorSorpresa;
  }
}
