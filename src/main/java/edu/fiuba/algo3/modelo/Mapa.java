package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Mapa {
  private HashMap<Posicion, IVisitor> obstaculos;
  private HashMap<Posicion, Sorpresa> sorpresas;
  private HashMap<Posicion, Pared> paredes;
  private Posicion meta;

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

  // TODO: ver cómo reemplazar esa excepción porque no tiene sentido lanzarla para terminar el juego
  // (además está mal)
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

  public Sorpresa sorpresaEnPosicion(Posicion posicion) {
    return this.sorpresas.get(posicion);
  }

  public IVisitor obstaculoEnPosicion(Posicion posicion) {
    return this.obstaculos.get(posicion);
  }
}
