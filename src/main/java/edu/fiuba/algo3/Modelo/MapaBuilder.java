package edu.fiuba.algo3.Modelo;

import java.util.HashMap;
import java.util.Random;

public class MapaBuilder {
  private int alto;
  private int ancho;
  private int cantElementos;

  private HashMap paredes;
  private HashMap obstaculos;
  private HashMap sorpresas;

  private Posicion meta;

  public MapaBuilder(int alto, int ancho) {
    this.cantElementos = 5;
    this.alto = alto;
    this.ancho = ancho;
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
    /*
    double generarElementos = Math.random();

    if(generarElemenetos < 0.1){
    return new Pozo(posicion)

    }
     */
    Random randomizador = new Random();
    Mapa mapa = crearMapa();
    /*
    generarElementosEnElMapa(Posicion posicionDelElemento){
      double generar = Math.random();

      if(generar < 0.1)
        return new Pozo(posicionDelElemento)

      if(generar < 0.2)
        return new Piquete(posicionDelElemento)
    }
     */
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho)+1;
      int y = randomizador.nextInt(alto)+1;
      this.agregar(new SorpresaFavorable(), Posicion.getPosicion(x, y));
      //System.out.print(" puse una sorpresa favorable en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho)+1;
      int y = randomizador.nextInt(alto)+1;
      this.agregar(new Pozo(), Posicion.getPosicion(x, y));
      System.out.print(" puse un pozo en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho)+1;
      int y = randomizador.nextInt(alto)+1;
      this.agregar(new SorpresaCambioVehiculo(), Posicion.getPosicion(x, y));
      //System.out.print(" puse una sorpresa cambio de vehiculo en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho)+1;
      int y = randomizador.nextInt(alto)+1;
      this.agregar(new ControlPolicial(), Posicion.getPosicion(x, y));
      System.out.print(" puse un control policial en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(alto)+1;
      int y = randomizador.nextInt(ancho)+1;
      this.agregar(new Piquete(), Posicion.getPosicion(x, y));
      System.out.print(" puse un piquete en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(alto)+1;
      int y = randomizador.nextInt(ancho)+1;
      this.agregar(new SorpresaDesfavorable(), Posicion.getPosicion(x, y));
      //System.out.print(" puse una sorpresa desfavorable en " + x + "," + y + " ");
    }
    return mapa;
  }

  public void agregar(Obstaculo obstaculo, Posicion posicion) {
    this.obstaculos.put(posicion, obstaculo);
  }

  public void agregar(Sorpresa sorpresa, Posicion posicion) {
    this.sorpresas.put(posicion, sorpresa);
  }

  // TODO: Sacar hardcodeo de randomizador para que funcione
  public Mapa crearMapa() {
    Random randomizador = new Random();
    this.obstaculos = new CreadorObstaculos().crear(alto, ancho);
    this.sorpresas = new CreadorSorpresas().crear(alto,ancho);
    int xDeMeta = this.ancho;
    int yDeMeta = randomizador.nextInt(alto);
    this.meta = Posicion.getPosicion(xDeMeta, yDeMeta);
    return new Mapa(obstaculos, sorpresas, meta,this.alto,this.ancho);
  }
}
