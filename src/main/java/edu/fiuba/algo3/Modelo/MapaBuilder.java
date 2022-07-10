package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Obstaculos.*;
import edu.fiuba.algo3.Modelo.Sorpresas.*;
import edu.fiuba.algo3.Modelo.Vehiculo.Mapa;
import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;

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
  private Random randomizador;
  private final int FACTOR_DE_CARGA = 2;

  public MapaBuilder() {
    this.randomizador = new Random();
    this.alto = (this.randomizador.nextInt(5) + 1) * 2;
    this.ancho = this.alto * 2;
    this.cantElementos = (this.alto * this.ancho) / FACTOR_DE_CARGA;
  }

  public Mapa getMapa() {
    return this.mapa;
  }

  private void agregarElemento(Sorpresa sorpresa) {
    int x = this.randomizador.nextInt(this.ancho) + 1;
    int y = this.randomizador.nextInt(this.alto) + 1;
    this.sorpresas.put(Posicion.getPosicion(x, y), sorpresa);
  }

  private void agregarElemento(Obstaculo obstaculo) {
    int x = this.randomizador.nextInt(this.ancho) + 1;
    int y = this.randomizador.nextInt(this.alto) + 1;
    this.sorpresas.put(Posicion.getPosicion(x, y), obstaculo);
  }

  // TODO: Revisar si estos comentarios son necesarios para que funcione crearGameplay()
  public Mapa crearGameplay() {
    this.mapaVacio(this.alto, this.ancho);
    for (int i = 0; i < this.cantElementos; i++) {
      /*
      int x = this.randomizador.nextInt(this.ancho) + 1;
      int y = this.randomizador.nextInt(this.alto) + 1;
      this.sorpresas.put(Posicion.getPosicion(x, y), new SorpresaFavorable());

      x = this.randomizador.nextInt(this.ancho) + 1;
      y = this.randomizador.nextInt(this.alto) + 1;
      this.sorpresas.put(Posicion.getPosicion(x, y), new SorpresaCambioVehiculo());

      x = this.randomizador.nextInt(this.alto) + 1;
      y = this.randomizador.nextInt(this.ancho) + 1;
      this.sorpresas.put(Posicion.getPosicion(x, y), new SorpresaDesfavorable());

      x = this.randomizador.nextInt(this.ancho) + 1;
      y = this.randomizador.nextInt(this.alto) + 1;
      this.obstaculos.put(Posicion.getPosicion(x, y), new Pozo());

      x = this.randomizador.nextInt(this.ancho) + 1;
      y = this.randomizador.nextInt(this.alto) + 1;
      this.obstaculos.put(Posicion.getPosicion(x, y), new ControlPolicial());

      x = this.randomizador.nextInt(this.alto) + 1;
      y = this.randomizador.nextInt(this.ancho) + 1;
      this.obstaculos.put(Posicion.getPosicion(x, y), new Piquete());
      */
      this.agregarElemento(new SorpresaFavorable());
      this.agregarElemento(new SorpresaDesfavorable());
      this.agregarElemento(new SorpresaCambioVehiculo());
      this.agregarElemento(new Pozo());
      this.agregarElemento(new ControlPolicial());
      this.agregarElemento(new Piquete());
    }
    this.definirMeta();
    return new Mapa(this.obstaculos, this.sorpresas, this.meta, alto, ancho);
  }

  protected void mapaVacio(int alto, int ancho) {
    this.obstaculos = new CreadorObstaculos().crear(alto, ancho);
    this.sorpresas = new CreadorSorpresas().crear(alto, ancho);
  }

  protected void definirMeta() {
    int yDeMeta = this.randomizador.nextInt(this.alto);
    this.meta = Posicion.getPosicion(this.ancho, yDeMeta);
  }
}
