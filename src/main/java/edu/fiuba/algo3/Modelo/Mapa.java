package edu.fiuba.algo3.Modelo;

import java.util.HashMap;

public class Mapa {
  private HashMap<Posicion, Obstaculo> obstaculos;
  private HashMap<Posicion, Sorpresa> sorpresas;
  private HashMap<Posicion, Pared> paredes;
  private Posicion meta;
  private Vehiculo vehiculoEnElMapa;
  private int alto;
  private int ancho;

  public Mapa()
  {
    this.obstaculos = new HashMap<>();
    this.sorpresas = new HashMap<>();
    this.paredes = new HashMap<>();
    //randomizar
    this.meta = Posicion.getPosicion(20, 0);
  }

  public Mapa(HashMap paredes, HashMap obstaculos, HashMap sorpresas, Posicion meta,int alto,int ancho)
  {
    this.obstaculos = obstaculos;
    this.sorpresas = sorpresas;
    this.paredes = paredes;
    this.meta = meta;
    this.alto = alto;
    this.ancho = ancho;
  }

//preguntar
  /*
  public void generarMapa(Vehiculo vehiculo)
  {
   this.vehiculoEnElMapa = vehiculo;
   this.dimension = new MapaBuilder().procesar(this.obstaculos,this.sorpresas);
  }

   */

  public int getDimension()
  {
    return this.alto;
  }

  public void avanzar(Vehiculo vehiculo, char direccion)
  {
    Posicion posicion = vehiculo.getPosicionSiguiente(direccion);
    if (posicion.estaFueraDeLimites(this.ancho,this.alto))
    {

      System.out.print("bb");
      return;
    }
       //


    try {
      this.pasarPorObstaculos(vehiculo, posicion);
    } catch (HayPiqueteException e) {
      return;
    }
    try {
      //this.pasarPorPared(posicion);
    } catch (HayParedException e) {
      return;
    }
    this.abrirSorpresas(vehiculo, posicion);
    vehiculo.moverse(posicion);
    //this.llegoAMeta(posicion);
  }

  private void llegoAMeta(Posicion posicion)
  {
    if (meta.equals(posicion))
    {
      throw new LlegoAMetaException();
    }
  }

  // TODO: Revisar implementación de posicion y paredes
  private void pasarPorPared(Posicion posicion)
  {
    if (this.paredes.get(posicion) != null) throw new HayParedException();
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
