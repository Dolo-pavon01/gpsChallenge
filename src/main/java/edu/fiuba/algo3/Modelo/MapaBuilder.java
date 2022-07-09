package edu.fiuba.algo3.Modelo;

import java.util.HashMap;
import java.util.Random;

public class MapaBuilder {
  protected int alto;
  protected int ancho;
  private int cantElementos;

  protected HashMap obstaculos;
  protected HashMap sorpresas;

  protected Mapa mapa;

  protected Posicion meta;

  public MapaBuilder() {
    Random randomizador = new Random();
    this.cantElementos = 5;

    this.alto = (randomizador.nextInt(5) + 1 )* 2;
    this.ancho = this.alto*2;
    this.mapa = this.crearMapa(this.alto,this.ancho);
  }

  public Mapa getMapa()
  {
    return this.mapa;
  }
  /*
   Para VistaMapa necesita tener las dimensiones del Mapa Ancho,Alto
   y el Random() Entre 2 y 10 de a pares.
   El ramdom por dos siempre sera las calles Y.

   (nextInt(5) + 1 )* 2


   */


  //preguntar a mel??
  /*
  public int procesar(HashMap<> obstaculos,HashMap<> sorpresas){
    Random random = new Random();
    this.ancho = random.nextInt(3)+1;
    return this.ancho;
  }

   */

  public Mapa crearGameplay() {
    Random randomizador = new Random();
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho)+1;
      int y = randomizador.nextInt(alto)+1;
      this.sorpresas.put( Posicion.getPosicion(x, y),new SorpresaFavorable());
      //System.out.print(" puse una sorpresa favorable en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho)+1;
      int y = randomizador.nextInt(alto)+1;
      this.obstaculos.put( Posicion.getPosicion(x, y),new Pozo());
      System.out.print(" puse un pozo en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho)+1;
      int y = randomizador.nextInt(alto)+1;
      this.sorpresas.put( Posicion.getPosicion(x, y),new SorpresaCambioVehiculo());
      //System.out.print(" puse una sorpresa cambio de vehiculo en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho)+1;
      int y = randomizador.nextInt(alto)+1;
      this.obstaculos.put( Posicion.getPosicion(x, y),new ControlPolicial());
      System.out.print(" puse un control policial en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(alto)+1;
      int y = randomizador.nextInt(ancho)+1;
      this.obstaculos.put( Posicion.getPosicion(x, y),new Piquete());
      System.out.print(" puse un piquete en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(alto)+1;
      int y = randomizador.nextInt(ancho)+1;
      this.sorpresas.put(Posicion.getPosicion(x, y),new SorpresaDesfavorable());
      //System.out.print(" puse una sorpresa desfavorable en " + x + "," + y + " ");
    }
    return mapa;
  }
  protected void mapaVacio(int alto, int ancho)
  {
    this.obstaculos = new CreadorObstaculos().crear(alto, ancho);
    this.sorpresas = new CreadorSorpresas().crear(alto,ancho);
  }

  // TODO: Sacar hardcodeo de randomizador para que funcione
  public Mapa crearMapa(int alto,int ancho) {
    mapaVacio(alto,ancho);
    Random randomizador = new Random();
    int xDeMeta = ancho;
    int yDeMeta = randomizador.nextInt(alto);
    this.meta = Posicion.getPosicion(xDeMeta, yDeMeta);
    return new Mapa(this.obstaculos, this.sorpresas, this.meta,alto,ancho);
  }
}
