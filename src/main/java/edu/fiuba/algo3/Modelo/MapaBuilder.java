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
  //protected Posicion posVehiculo;
  private Random randomizador;
  private final int FACTOR_DE_CARGA = 3;

  public MapaBuilder() {
    this.randomizador = new Random();
    this.alto = (this.randomizador.nextInt(4) + 2) * 2;
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
    this.obstaculos.put(Posicion.getPosicion(x, y), obstaculo);
  }

  public Mapa crearGameplay() {
    this.mapaVacio(this.alto, this.ancho);
    for (int i = 0; i < this.cantElementos; i++) {
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
    int yDeMeta = this.randomizador.nextInt(this.alto)+1;
    this.meta = Posicion.getPosicion(this.ancho,yDeMeta);
  }

  /*protected void definirPosicionVehiculo(){
    this.posVehiculo = Posicion.getPosicion(0, this.alto/2);
  }*/
}
