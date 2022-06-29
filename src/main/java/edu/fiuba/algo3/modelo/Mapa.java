package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Mapa {
  HashMap<Posicion, IVisitor> obstaculos;
  HashMap<Posicion, Sorpresa> sorpresas;
  HashMap<Posicion, Pared> paredes;
  Posicion meta;

  public Mapa() {
    this.obstaculos = new HashMap<>();
    this.sorpresas = new HashMap<>();
    this.paredes = new HashMap<>();
    this.meta = Posicion.getPosicion(20, 0);
  }

  public Mapa(HashMap paredes, HashMap obstaculos, HashMap sorpresas, Posicion meta) {
    this.obstaculos = obstaculos;
    this.sorpresas = sorpresas;
    this.paredes = paredes;
    this.meta = meta;
  }

  public void avanzar(Vehiculo vehiculo, char direccion) {
    Posicion posicion = vehiculo.getPosicionSiguiente(direccion);
    try {
      this.pasarPorObstaculos(vehiculo, posicion);
    } catch (HayPiqueteException e) {
      return;
    }
    try {
      this.pasarPorPared(posicion);
    } catch (HayParedException e) {
      return;
    }
    this.abrirSorpresas(vehiculo, posicion);
    vehiculo.moverse(posicion);
    this.llegoAMeta(posicion);
  }

  private void llegoAMeta(Posicion posicion) {
    if (meta.equals(posicion)) {
      throw new LlegoAMetaException();
    }
  }

  // TODO: Revisar implementación de posicion y paredes
  private void pasarPorPared(Posicion posicion) {
    if (this.paredes.get(posicion) != null) throw new HayParedException();
  }

  private void pasarPorObstaculos(Vehiculo vehiculo, Posicion posicion) {
    vehiculo.pasarPor(this.obstaculos.get(posicion));
  }

  private void abrirSorpresas(Vehiculo vehiculo, Posicion posicion) {
    vehiculo.abrirSopresa(this.sorpresas.get(posicion));
  }
}
