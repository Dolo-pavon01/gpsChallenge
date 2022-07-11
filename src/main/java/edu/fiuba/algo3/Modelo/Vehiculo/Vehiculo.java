package edu.fiuba.algo3.Modelo.Vehiculo;

import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.Modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Sentido;

public class Vehiculo {
  private final int CANTIDAD_MOVIMIENTOS_INICIAL = 0;

  private TipoVehiculo tipo;
  private Posicion posicion;
  private int movimientos;

  public String datosVehiculo() {
    // return this.tipo.obtenerNombreEnPosicion(this.posicion);

    return this.posicion.posicionAString()+";"+this.tipo.getNombre();
  }

  public String posicionComoString() {
    return this.posicion.posicionAString();
  }

  public Vehiculo(TipoVehiculo tipo, Posicion posicion) {
    this.movimientos = CANTIDAD_MOVIMIENTOS_INICIAL;
    this.tipo = tipo;
    this.posicion = posicion;
  }

  public void pasarPor(Obstaculo visitor) {
    this.movimientos += this.tipo.pasarPor(visitor);
  }

  public void abrirSopresa(Sorpresa sorpresa) {
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
