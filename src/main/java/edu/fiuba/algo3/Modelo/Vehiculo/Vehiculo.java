package edu.fiuba.algo3.Modelo.Vehiculo;

import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.Modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Sentido;

public class Vehiculo {
  private TipoVehiculo tipo;
  private Posicion posicion;
  private int movimientos;

  // TODO: Hacer que vehiculo reciba posicion de builder
  // La posicion tiene que ser (0, alto / 2)
  public Vehiculo(TipoVehiculo tipoVehiculo) {
    this.tipo = tipoVehiculo;
    this.movimientos = 0;
    this.posicion = Posicion.getPosicion(0, 1);
  }

  public String datosVehiculo() {
    String datos = this.posicionComoString() + ";";
    datos = datos + this.tipo.getNombre();
    return datos;
  }

  public String posicionComoString() {
    return this.posicion.posicionAString();
  }

  public Vehiculo() {
    this.movimientos = 0;
    this.posicion = Posicion.getPosicion(0, 1);
  }

  public Vehiculo(TipoVehiculo tipo, Posicion posicion) {
    this.movimientos = 0;
    this.tipo = tipo;
    this.posicion = posicion;
  }

  public void pasarPor(Obstaculo visitor) {
    if (visitor == null) return;
    this.movimientos += this.tipo.pasarPor(visitor);
  }

  public void abrirSopresa(Sorpresa sorpresa) {
    if (sorpresa == null) return;
    sorpresa.activar(this);
  }

  public Posicion getPosicion() {
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
