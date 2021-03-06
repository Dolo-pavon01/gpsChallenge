package edu.fiuba.algo3.Modelo.Vehiculo;

import edu.fiuba.algo3.Modelo.HayPiqueteException;
import edu.fiuba.algo3.Modelo.ObstaculoEsNulo;
import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.Modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Sentido;
import edu.fiuba.algo3.Modelo.Vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Mapa {
  private HashMap<Posicion, Obstaculo> obstaculos;
  private HashMap<Posicion, Sorpresa> sorpresas;
  private Posicion meta;
  private static final String NOMBRE_META = "meta";
  private static final String SEPARADOR = ";";
  private boolean llegoAMeta;
  private int alto;
  private int ancho;

  public Mapa(HashMap obstaculos, HashMap sorpresas, Posicion meta, int alto, int ancho) {
    this.obstaculos = obstaculos;
    this.sorpresas = sorpresas;
    this.meta = meta;
    this.alto = alto;
    this.ancho = ancho;
  }

  public boolean llegoAMeta() {
    return this.llegoAMeta;
  }

  public int getAlto() {
    return this.alto;
  }

  public void avanzar(Vehiculo vehiculo, char direccion) {
    Posicion posicion = vehiculo.getPosicionSiguiente(direccion);
    if (meta.equals(posicion)) {
      this.llegoAMeta = true;
    }
    if (posicion.estaFueraDeLimites(this.ancho, this.alto )) return;
    try {
      this.pasarPorObstaculos(vehiculo, posicion);
    } catch (HayPiqueteException e) {
      return;
    }
    this.abrirSorpresas(vehiculo, posicion);
    vehiculo.moverse(posicion);
  }

  private void pasarPorObstaculos(Vehiculo vehiculo, Posicion posicion) {
    vehiculo.pasarPor(this.obstaculos.get(posicion));
  }

  private void abrirSorpresas(Vehiculo vehiculo, Posicion posicion) {
    vehiculo.abrirSopresa(this.sorpresas.get(posicion));
  }

  private Sorpresa obtenerSorpresaEn(Posicion posicion) {
    return this.sorpresas.get(posicion);
  }

  public ArrayList<String> getSorpresas() {
    ArrayList<String> sorpresasObtenidas = new ArrayList();
    for (int i = 0; i < this.ancho; i++) {
      for (int j = 0; j <= this.alto; j++) {
        Posicion posicion = Posicion.getPosicion(i, j);
        Sorpresa sorpresa = this.obtenerSorpresaEn(posicion);
        if (sorpresa.nombreSorpresa() != "sorpresaNula") {
          sorpresasObtenidas.add(sorpresa.obtenerNombreEnPosicion(posicion));
        }
      }
    }

    return sorpresasObtenidas;
  }

  private Obstaculo obtenerObstaculoEn(Posicion posicion) {
    return this.obstaculos.get(posicion);
  }

  public ArrayList<String> getObstaculos() {
    ArrayList<String> obstaculosObtenidos = new ArrayList();
    for (int i = 0; i < this.ancho; i++) {
      for (int j = 0; j <= this.alto; j++) {
        Posicion posicion = Posicion.getPosicion(i, j);
        Obstaculo obstaculo = this.obtenerObstaculoEn(posicion);
        if (obstaculo.nombreObstaculo() != "obstaculoNulo") {
          obstaculosObtenidos.add(obstaculo.obtenerNombreEnPosicion(posicion));
        }
      }
    }
    return obstaculosObtenidos;
  }

  public String getMeta() {
    return this.meta.posicionAString() + SEPARADOR + NOMBRE_META;
  }

}
