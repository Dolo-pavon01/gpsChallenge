package edu.fiuba.algo3.modelo;

public class BuilderPruebas {
  private int tamanio;
  private Creador creadorObstaculos;
  private Creador creadorSorpresas;
  private Creador creadorParedes;

  public BuilderPruebas(int tamanio) {
    this.tamanio = tamanio;
  }

  public Mapa crearGameplay() {
    Mapa mapa = new Mapa();
    this.creadorObstaculos = new CreadorObstaculos();
    this.creadorParedes = new CreadorParedes();
    this.creadorSorpresas = new CreadorSorpresas();
    mapa.obstaculos = creadorObstaculos.crear(tamanio);
    mapa.sorpresas = creadorSorpresas.crear(tamanio);
    mapa.paredes = creadorParedes.crear(tamanio);
    return mapa;
  }
}
