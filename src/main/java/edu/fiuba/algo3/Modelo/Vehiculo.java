package edu.fiuba.algo3.Modelo;

public class Vehiculo {
  private TipoVehiculo tipo;
  private Posicion posicion;
  private int movimientos;

  //TODO eliminar duplicados
  public Vehiculo(TipoVehiculo tipoVehiculo) {
    this.tipo = tipoVehiculo;
    this.movimientos = 0;
    this.posicion = Posicion.getPosicion(0, 1);
  }


  public Vehiculo() {
    this.movimientos = 0;
    this.posicion = Posicion.getPosicion(0, 1);
  }

  public Vehiculo(TipoVehiculo tipo,Posicion posicion) {
    this.movimientos = 0;
    this.tipo = tipo;
    this.posicion = posicion;
  }
  public void pasarPor(Obstaculo visitor) {
    if (visitor == null)
      return;
    this.movimientos += this.tipo.pasarPor(visitor);
  }

  public void abrirSopresa(Sorpresa sorpresa) {
    if (sorpresa == null)
      return;
    sorpresa.activar(this);
  }

  public Posicion getPosicion()
  {
    return this.posicion;
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
