package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Grilla {
  HashMap<Posicion, IVisitor> obstaculos;
  HashMap<Posicion, Sorpresa> sorpresas;

  public Grilla() {
    this.obstaculos = new HashMap<Posicion, IVisitor>(10, 70);
    this.sorpresas = new HashMap<Posicion, Sorpresa>(10, 70);
  }

  public void avanzar(Vehiculo vehiculo, char direccion)
  {
    Posicion posicion = vehiculo.getPosicionSiguiente(direccion);
    this.pasarPorObstaculos(vehiculo, posicion);
    this.abrirSorpresas(vehiculo, posicion);
    vehiculo.moverse(posicion);
  }

  private void pasarPorObstaculos(Vehiculo vehiculo, Posicion posicion)
  {
    IVisitor obstaculo = obstaculos.get(posicion);
    try{
      vehiculo.pasarPor(obstaculo);
    }
    catch(ObstaculoEsNulo e)
    {
    }
  }

  private void abrirSorpresas(Vehiculo vehiculo, Posicion posicion)
  {
    Sorpresa sorpresa = sorpresas.get(posicion);
    try{
      vehiculo.abrirSopresa(sorpresa);
    }
    catch(SorpresaEsNula e)
    {
    }
  }
}
