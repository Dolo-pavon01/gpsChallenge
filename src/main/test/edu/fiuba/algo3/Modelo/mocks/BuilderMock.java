package edu.fiuba.algo3.Modelo.mocks;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;
import edu.fiuba.algo3.Modelo.Sorpresas.Sorpresa;
import edu.fiuba.algo3.Modelo.Vehiculo.Mapa;
import edu.fiuba.algo3.Modelo.Vehiculo.Posicion;
import edu.fiuba.algo3.Modelo.Vehiculo.Sentido;


public class BuilderMock extends MapaBuilder {
  public BuilderMock(int alto, int ancho) {
    this.alto = alto;
    this.ancho = ancho;
    this.mapaVacio(alto, ancho);
    this.definirMeta();
    this.mapa = new Mapa(this.obstaculos, this.sorpresas, this.meta, alto, ancho);
  }

  public void agregar(Obstaculo obstaculo, Posicion posicion) {
    this.obstaculos.put(posicion, obstaculo);
    this.mapa = new Mapa(this.obstaculos, this.sorpresas, meta, this.alto, this.ancho);
  }

  public void agregar(Sorpresa sorpresa, Posicion posicion) {
    this.sorpresas.put(posicion, sorpresa);
    this.mapa = new Mapa(this.obstaculos, this.sorpresas, meta, this.alto, this.ancho);
  }

  public Mapa getMapa() {
    return this.mapa;
  }

  @Override
  protected void definirMeta() {
    this.meta = Posicion.getPosicion(9, 5);
  }
}
