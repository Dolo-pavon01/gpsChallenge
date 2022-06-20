package edu.fiuba.algo3.modelo;

import java.util.HashMap;

// TODO: Ver como pasarle el tamanio a mapa
public class Mapa {
  HashMap<Posicion, IVisitor> obstaculos;
  HashMap<Posicion, Sorpresa> sorpresas;
  private int tamanio;

  public Mapa() {
    this.obstaculos = new HashMap<Posicion, IVisitor>(10, 70);
    this.sorpresas = new HashMap<Posicion, Sorpresa>(10, 70);
  }

  private boolean perteneceADominio(Posicion posicion) {
    return posicion.pertenceADominio(this.tamanio);
  }

  public void avanzar(Vehiculo vehiculo, char direccion) {
    Posicion posicion = vehiculo.getPosicionSiguiente(direccion);
    if (this.perteneceADominio(posicion)) {
      return;
    }
    this.pasarPorObstaculos(vehiculo, posicion);
    this.abrirSorpresas(vehiculo, posicion);
    vehiculo.moverse(posicion);
  }

  private void pasarPorObstaculos(Vehiculo vehiculo, Posicion posicion) {
    vehiculo.pasarPor(this.obstaculos.get(posicion));
  }

  private void abrirSorpresas(Vehiculo vehiculo, Posicion posicion) {
    vehiculo.abrirSopresa(this.sorpresas.get(posicion));
  }
}