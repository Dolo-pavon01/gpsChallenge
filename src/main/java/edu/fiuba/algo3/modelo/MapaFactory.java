package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Random;

public class MapaFactory {
  private int largo;
  private int ancho;
  private int cantidadDeElementos;
  private HashMap obstaculos;
  private HashMap sorpresas;
  private HashMap paredes;
  private Posicion meta;

  public MapaFactory(int largo, int ancho) {
    this.largo = largo;
    this.ancho = ancho;
    this.cantidadDeElementos = largo / 8;
    this.obstaculos = new HashMap<>();
    this.sorpresas = new HashMap<>();
    this.paredes = new HashMap<>();
  }

  public Mapa crearGameplay() {
    Random randomizador = new Random();
    Mapa mapa = this.crearMapa();

    for (int i = 0; i < this.cantidadDeElementos; i++) {
      int x = randomizador.nextInt(this.ancho);
      int y = randomizador.nextInt(this.largo);
      mapa = this.agregar(new SorpresaFavorable(), Posicion.getPosicion(x, y));
    }

    for (int i = 0; i < this.cantidadDeElementos; i++) {
      int x = randomizador.nextInt(this.ancho);
      int y = randomizador.nextInt(this.largo);
      mapa = this.agregar(new Pozo(), Posicion.getPosicion(x, y));
    }

    for (int i = 0; i < this.cantidadDeElementos; i++) {
      int x = randomizador.nextInt(this.ancho);
      int y = randomizador.nextInt(this.largo);
      mapa = this.agregar(new SorpresaCambioVehiculo(), Posicion.getPosicion(x, y));
    }

    for (int i = 0; i < this.cantidadDeElementos; i++) {
      int x = randomizador.nextInt(this.ancho);
      int y = randomizador.nextInt(this.largo);
      mapa = this.agregar(new ControlPolicial(), Posicion.getPosicion(x, y));
    }

    for (int i = 0; i < this.cantidadDeElementos; i++) {
      int x = randomizador.nextInt(this.largo);
      int y = randomizador.nextInt(ancho);
      mapa = this.agregar(new Piquete(), Posicion.getPosicion(x, y));
    }

    for (int i = 0; i < this.cantidadDeElementos; i++) {
      int x = randomizador.nextInt(this.largo);
      int y = randomizador.nextInt(this.ancho);
      mapa = this.agregar(new SorpresaDesfavorable(), Posicion.getPosicion(x, y));
    }
    return mapa;
  }

  public Mapa agregar(IVisitor obstaculo, Posicion posicion) {
    this.obstaculos.put(posicion, obstaculo);
    return new Mapa(this.paredes, this.obstaculos, this.sorpresas, this.meta);
  }

  public Mapa agregar(Sorpresa sorpresa, Posicion posicion) {
    this.sorpresas.put(posicion, sorpresa);
    return new Mapa(this.paredes, this.obstaculos, this.sorpresas, this.meta);
  }

  // TODO: Sacar hardcodeo de randomizador para que funcione
  public Mapa crearMapa() {
    Random randomizador = new Random();
    this.obstaculos = new CreadorObstaculos().crear(this.largo, this.ancho);
    this.sorpresas = new CreadorSorpresas().crear(this.largo, this.ancho);
    this.paredes = new CreadorParedes().crear(this.largo, this.ancho);
    int xDeMeta = this.ancho;
    int yDeMeta = randomizador.nextInt(this.largo);
    this.meta = Posicion.getPosicion(xDeMeta, yDeMeta);
    return new Mapa(this.paredes, this.obstaculos, this.sorpresas, this.meta);
  }
}
