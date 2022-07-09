package edu.fiuba.algo3.Modelo;

import java.util.HashMap;

public class Mapa {
  private  HashMap<Posicion, Obstaculo> obstaculos;
  private HashMap<Posicion, Sorpresa> sorpresas;
  private Posicion meta;
  private int alto;
  private int ancho;

  private boolean llegoAMeta;


  public Mapa( HashMap obstaculos, HashMap sorpresas, Posicion meta,int alto,int ancho)
  {
    this.obstaculos = obstaculos;
    this.sorpresas = sorpresas;
    this.meta = meta;
    this.alto = alto;
    this.ancho = ancho;
  }

  public int getDimension()
  {
    return this.alto;
  }
  public int getAlto()
  {
    return this.alto;
  }
  public int getAncho()
  {
    return this.ancho;
  }
  public boolean llegoAMeta()
  {
    return this.llegoAMeta;
  }

  public void avanzar(Vehiculo vehiculo, char direccion)
  {
    Posicion posicion = vehiculo.getPosicionSiguiente(direccion);
    if (posicion.estaFueraDeLimites(this.ancho,this.alto))
      return;
    try {
      this.pasarPorObstaculos(vehiculo, posicion);
    } catch (HayPiqueteException e) {
      return;
    }

    this.abrirSorpresas(vehiculo, posicion);
    vehiculo.moverse(posicion);
    if (meta.equals(posicion))
    {
      this.llegoAMeta = true;
    }
  }

  private void pasarPorObstaculos(Vehiculo vehiculo, Posicion posicion) {
    vehiculo.pasarPor(this.obstaculos.get(posicion));
  }

  private void abrirSorpresas(Vehiculo vehiculo, Posicion posicion)
  {
    vehiculo.abrirSopresa(this.sorpresas.get(posicion));
    //this.sorpresas.put(posicion,new SorpresaNula()); si quisiesemos que desaparezcan :/
  }

  public Sorpresa sorpresaEnPosicion(Posicion posicion)
  {
    return this.sorpresas.get(posicion);
  }

  public Obstaculo obstaculoEnPosicion(Posicion posicion)
  {
    return this.obstaculos.get(posicion);
  }
}
