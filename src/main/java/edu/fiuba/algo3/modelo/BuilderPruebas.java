package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Random;

public class BuilderPruebas {
  private int tamanio;
  private int cantElementos;
  private HashMap<Posicion,IVisitor> obstaculos;
  private HashMap<Posicion,Sorpresa> sorpresas;
  private HashMap<Posicion,Pared> paredes;

  private Posicion meta;

  public BuilderPruebas(int tamanio)
  {
    this.tamanio = tamanio;
    this.cantElementos = tamanio/8;
  }

  public Mapa crearGameplay() {
    Random randomizador = new Random();
    Mapa mapa = crearMapa();
    for(int i =0;i <this. cantElementos;i++)
    {
      int x = randomizador.nextInt(tamanio);
      int y = randomizador.nextInt(tamanio);
      mapa = this.agregar(new SorpresaFavorable(),Posicion.getPosicion(x,y));
      System.out.print(" puse una sorpresa favorable en " + x + "," + y +" ");
    }
    for(int i =0;i <this. cantElementos;i++)
    {
      int x = randomizador.nextInt(tamanio);
      int y = randomizador.nextInt(tamanio);
      mapa = this.agregar(new Pozo(),Posicion.getPosicion(x,y));
      System.out.print(" puse un pozo en " + x + "," + y +" ");
    }
    for(int i =0;i <this. cantElementos;i++)
    {
      int x = randomizador.nextInt(tamanio);
      int y = randomizador.nextInt(tamanio);
      mapa = this.agregar(new SorpresaCambioVehiculo(),Posicion.getPosicion(x,y));
      System.out.print(" puse una sorpresa cambio de vehiculo en " + x + "," + y +" ");
    }
    for(int i =0;i <this. cantElementos;i++)
    {
      int x = randomizador.nextInt(tamanio);
      int y = randomizador.nextInt(tamanio);
      mapa = this.agregar(new ControlPolicial(),Posicion.getPosicion(x,y));
      System.out.print(" puse un control policial en " + x + "," + y +" ");
    }
    for(int i =0;i <this. cantElementos;i++)
    {
      int x = randomizador.nextInt(tamanio);
      int y = randomizador.nextInt(tamanio);
      mapa = this.agregar(new Piquete(),Posicion.getPosicion(x,y));
      System.out.print(" puse un piquete en " + x + "," + y +" ");
    }
    for(int i =0;i <this. cantElementos;i++)
    {
      int x = randomizador.nextInt(tamanio);
      int y = randomizador.nextInt(tamanio);
      mapa = this.agregar(new SorpresaDesfavorable(),Posicion.getPosicion(x,y));
      System.out.print(" puse una sorpresa desfavorable en " + x + "," + y +" ");
    }
    return mapa;

  }

  public Mapa agregar(IVisitor obstaculo,Posicion posicion)
  {
      this.obstaculos.put(posicion,obstaculo);
      return new Mapa(paredes, obstaculos, sorpresas, meta);
  }
  public Mapa agregar(Sorpresa sorpresa,Posicion posicion)
  {
    this.sorpresas.put(posicion,sorpresa);
    return new Mapa(paredes, obstaculos, sorpresas, meta);
  }

  public Mapa crearMapa()
  {
    this.obstaculos = new CreadorObstaculos().crear(tamanio);
    this.sorpresas = new CreadorSorpresas().crear(tamanio);
    this.paredes = new CreadorParedes().crear(tamanio);
    int xDeMeta = 19;//randomizador.nextInt(tamanio);
    int yDeMeta = 1; //randomizador.nextInt(tamanio);
    this.meta = Posicion.getPosicion(xDeMeta,yDeMeta);
    return new Mapa(paredes, obstaculos, sorpresas, meta);
  }
}
