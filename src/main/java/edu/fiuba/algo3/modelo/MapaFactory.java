package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Random;

public class MapaFactory {
  private int largo;
  private int ancho;
  private int cantElementos;
  private HashMap obstaculos;
  private HashMap sorpresas;
  private HashMap paredes;

  private Posicion meta;

  public MapaFactory(int largo, int ancho) {
    this.largo = largo;
    this.ancho = ancho;
    this.cantElementos = largo/8;
    this.obstaculos = new HashMap<>();
    this.sorpresas = new HashMap<>();
    this.paredes = new HashMap<>();
  }

  public Mapa crearGameplay() {
    Random randomizador = new Random();
    Mapa mapa = crearMapa();
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho);
      int y = randomizador.nextInt(largo);
      mapa = this.agregar(new SorpresaFavorable(), Posicion.getPosicion(x, y));
      //System.out.print(" puse una sorpresa favorable en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho);
      int y = randomizador.nextInt(largo);
      mapa = this.agregar(new Pozo(), Posicion.getPosicion(x, y));
      System.out.print(" puse un pozo en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho);
      int y = randomizador.nextInt(largo);
      mapa = this.agregar(new SorpresaCambioVehiculo(), Posicion.getPosicion(x, y));
      //System.out.print(" puse una sorpresa cambio de vehiculo en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(ancho);
      int y = randomizador.nextInt(largo);
      mapa = this.agregar(new ControlPolicial(), Posicion.getPosicion(x, y));
      System.out.print(" puse un control policial en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(largo);
      int y = randomizador.nextInt(ancho);
      mapa = this.agregar(new Piquete(), Posicion.getPosicion(x, y));
      System.out.print(" puse un piquete en " + x + "," + y + " ");
    }
    for (int i = 0; i < this.cantElementos; i++) {
      int x = randomizador.nextInt(largo);
      int y = randomizador.nextInt(ancho);
      mapa = this.agregar(new SorpresaDesfavorable(), Posicion.getPosicion(x, y));
      //System.out.print(" puse una sorpresa desfavorable en " + x + "," + y + " ");
    }
    return mapa;
  }

  public Mapa agregar(IVisitor obstaculo, Posicion posicion) {
    this.obstaculos.put(posicion, obstaculo);
    return new Mapa(paredes, obstaculos, sorpresas, meta);
  }

  public Mapa agregar(Sorpresa sorpresa, Posicion posicion) {
    this.sorpresas.put(posicion, sorpresa);
    return new Mapa(paredes, obstaculos, sorpresas, meta);
  }

  // TODO: Sacar hardcodeo de randomizador para que funcione
  public Mapa crearMapa() {
    Random randomizador = new Random();
    this.obstaculos = new CreadorObstaculos().crear(largo, ancho);
    this.sorpresas = new CreadorSorpresas().crear(largo,ancho);
    this.paredes = new CreadorParedes().crear(largo,ancho);
    int xDeMeta = this.ancho;
    int yDeMeta = randomizador.nextInt(largo);
    this.meta = Posicion.getPosicion(xDeMeta, yDeMeta);
    return new Mapa(paredes, obstaculos, sorpresas, meta);
  }
}
