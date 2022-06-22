package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Mapa {
  HashMap<Posicion, IVisitor> obstaculos;
  HashMap<Posicion, Sorpresa> sorpresas;

  HashMap<Posicion,Pared> paredes;
  int tamanio;

  public Mapa() {
    this.obstaculos = new HashMap<Posicion, IVisitor>(10, 70);
    this.sorpresas = new HashMap<Posicion, Sorpresa>(10, 70);
    this.paredes = new HashMap<>(10,70);
  }

  public void avanzar(Vehiculo vehiculo, char direccion)
  {
    Posicion posicion = vehiculo.getPosicionSiguiente(direccion);
    if(paredes.get(posicion) != null)
      return;
    this.pasarPorObstaculos(vehiculo, posicion);
    this.abrirSorpresas(vehiculo, posicion);
    vehiculo.moverse(posicion);
  }

  private void pasarPorObstaculos(Vehiculo vehiculo, Posicion posicion)
  {
    IVisitor obstaculo = obstaculos.get(posicion);
    vehiculo.pasarPor(obstaculo);
  }

  private void abrirSorpresas(Vehiculo vehiculo, Posicion posicion)
  {
    Sorpresa sorpresa = sorpresas.get(posicion);
    vehiculo.abrirSopresa(sorpresa);
  }
}
